# Sqoop Import

## 1. Sqoop 命令

### 1.1 命令帮助

```bash
[hadoop@h201 ~]$ sqoop help
```

```bash
[hadoop@h201 ~]$ sqoop help import
```

### 1.2 基本命令

#### （1）列出 MySQL 上的库

```bash
[hadoop@h201 ~]$ sqoop list-databases --connect jdbc:mysql://h201:3306/ --username spark --password spark123
```

#### （2）列出 MySQL 上 spark1 库中的所有表

```bash
[hadoop@h201 ~]$ sqoop list-tables --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123
```

#### （3）根据关系型数据库中的表创建 Hive 中的表

```bash
[hadoop@h201 ~]$ sqoop create-hive-table --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table f1 --hive-table hf1
```

#### （4）Eval

使用 SQL 语句对关系型数据库进行操作

```bash
[hadoop@h201 ~]$ sqoop eval --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --query "select * from f2"
```

```bash
[hadoop@h201 ~]$ sqoop eval --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --query "insert into f2 values('hangzhou',100)"
```

## 2. 数据导入

### （1）从 RDBMS 导入到 HDFS 中

```bash
[hadoop@h201 hadoop-2.7.2]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table f1 --target-dir /hive123 --fields-terminated-by '\t' -m 1
```

解释：
- `fields-terminated-by '\t'` 分隔符
- `-m` map task 数量

```bash
[hadoop@h201 hadoop-2.7.2]$ hadoop fs -cat /hive123/part-m-00000
202001  shanghai        28
202001  hubei   4950
202001  hebei   700
202001  beijing 342
202001  hunan   301
```

### （2）从 RDBMS 导入到 HDFS 中（where 条件）

```bash
[hadoop@h201 hadoop-2.7.2]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --where "province='hubei'" --table f1 --target-dir /hive123/f1hb --fields-terminated-by '\t' -m 1
```

```bash
[hadoop@h201 hadoop-2.7.2]$ hadoop fs -cat /hive123/f1hb/part-m-00000
202001  hubei   4950
```

### （3）从 RDBMS 导入到 HDFS 中（指定列）

```bash
[hadoop@h201 hadoop-2.7.2]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --columns "province,msum" --where "province='hubei'" --table f1 --target-dir /hive123/f1hb1 --fields-terminated-by '\t' -m 1
```

```bash
[hadoop@h201 hadoop-2.7.2]$ hadoop fs -cat /hive123/f1hb1/part-m-00000
hubei   4950
```

### （4）自定义 SQL 查询

```bash
[hadoop@h201 hadoop-2.7.2]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --target-dir /hive123/f1hb2 --query 'select mdate,msum from f1 where province="hubei" and $CONDITIONS' --fields-terminated-by '\t' -m 1
```

注意：
- `query` 的 `where` 条件当中必须有 `$CONDITIONS` 这个条件，这个条件就相当于一个占位符，动态接收传过来的参数，从而查询出符合条件的结果

```bash
[hadoop@h201 hadoop-2.7.2]$ hadoop fs -cat /hive123/f1hb2/part-m-00000
202001  4950
```

### （5）并发导入

如果导入的数据较大，我们需要多个 map task 执行，如：`-m 10`，设置多个 map task 必须指定分割条件 `split-by`

```bash
[hadoop@h201 hadoop-2.7.2]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table f1 --target-dir /hive123/f1hb3 --fields-terminated-by '\t' --split-by msum -m 2
```

输出目录中有两个数据文件（map task 为 2）

```bash
[hadoop@h201 hadoop-2.7.2]$ hadoop fs -lsr /hive123/f1hb3
-rw-r--r--   2 hadoop supergroup          0 2020-05-05 18:32 /hive123/f1hb3/_SUCCESS
-rw-r--r--   2 hadoop supergroup         72 2020-05-05 18:32 /hive123/f1hb3/part-m-00000
-rw-r--r--   2 hadoop supergroup         18 2020-05-05 18:32 /hive123/f1hb3/part-m-00001
```

#### Split-by 原理：

`split-by` 根据不同的参数类型有不同的切分方法，如 `int` 型，Sqoop 会取最大和最小 `split-by` 字段值，然后根据传入的 `num-mappers` 来确定划分几个区域。比如 `select max(split_by),min(split-by) from` 得到的 `max(split-by)` 和 `min(split-by)` 分别为 1000 和 1，而 `num-mappers`（`-m`）为 2 的话，则会分成两个区域 (1,500) 和 (501-1000)，同时也会分成 2 个 SQL 给 2 个 map 去进行导入操作，分别为 `select XXX from table where split-by>=1 and split-by<500` 和 `select XXX from table where split-by>=501 and split-by<=1000`。最后每个 map 各自获取各自 SQL 中的数据进行导入工作。

### （6）空值处理

```sql
mysql> create table s2 (id int, name varchar(50), sal double);
mysql> insert into s2 values(101, 'zs', 20000);
mysql> insert into s2 (id, name) values(102, 'ls');
mysql> insert into s2 (id) values(103);
mysql> commit;
mysql> select * from s2;
+------+------+-------+
| id   | name | sal   |
+------+------+-------+
|  101 | zs   | 20000 |
|  102 | ls   |  NULL |
|  103 | NULL |  NULL |
+------+------+-------+
```

```bash
[hadoop@h201 ~]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table s2 --target-dir /hive123/ff2 --null-string '' --null-non-string 0 -m 1
```

结果：

```bash
[hadoop@h201 ~]$ hadoop fs -cat /hive123/ff2/part-m-00000 
101,zs,20000.0
102,ls,0
103,,0
```

## 3. 增量导入

在生产环境中，系统可能会定期从与业务相关的关系型数据库向 Hadoop 导入数据，导入数仓后进行后续离线分析。此时不可能再将所有数据重新导一遍，需要增量数据导入模式。

增量数据导入分两种：
1. 基于递增列的增量数据导入（Append 方式）
2. 基于时间列的增量数据导入（LastModified 方式）

### 创建原始数据

```bash
[hadoop@h201 ~]$ mysql -h h201 -u spark -p
mysql> use spark1
mysql> create table s1 (id int, name varchar(50), mdate timestamp not null default current_timestamp);
mysql> insert into s1 (id, name) values(1, 'zs');
mysql> insert into s1 (id, name) values(2, 'ls');
mysql> commit;
```

### （1）Append 方式

#### 1）全量导入

```bash
[hadoop@h201 hadoop-2.7.2]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table s1 --target-dir /hive123/hs1 --fields-terminated-by '\t' -m 1
```

结果：

```bash
[hadoop@h201 ~]$ hadoop fs -cat /hive123/hs1/part-m-00000
1       zs      2020-05-05 19:51:26.0
2       ls      2020-05-05 19:51:33.0
```

#### 2）增量导入

插入新的数据

```sql
mysql> insert into s1 (id, name) values(3, 'ww');
mysql> commit;
```

```bash
[hadoop@h201 ~]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table s1 -m 1 --target-dir /hive123/hs1-l2 --check-column id --incremental append --last-value 2
```

解释：
- `--last-value 2` id 字段大于 2

结果：

```bash
[hadoop@h201 ~]$ hadoop fs -cat /hive123/hs1-l2/part-m-00000
3,ww,2020-05-05 19:59:31.0
```

只有新插入的数据

### （2）LastModified 方式

产生新的数据

```sql
mysql> insert into s1 (id, name) values(4, 'zl');
mysql> commit;
```

```bash
[hadoop@h201 ~]$ sqoop import --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table s1 -m 1 --target-dir /hive123/hs1-sj1 --check-column mdate --incremental lastmodified --last-value '2020-05-05 19:59:32'
```

解释：
- `--last-value '2020-05-05 19:59:32'` 大于 2020-05-05 19:59:32 时间的数据

结果：

```bash
[hadoop@h201 ~]$ hadoop fs -cat /hive123/hs1-sj1/part-m-00000
4,zl,2020-05-05 20:04:11.0
```

只有最新的数据

## 4. 导入到 Hive

### （1）创建 Hive 中表

```bash
[hadoop@h201 ~]$ sqoop create-hive-table --connect jdbc:mysql://h201:3306/spark1 --username spark --password spark123 --table f1 --hive-table hivef1
```

### （2）将 MySQL spark1 库中 f1 表导入到 Hive hivef1 表中

```bash
sqoop import --connect jdbc:mysql://h201:3306/spark1 \
--username spark \
--password spark123 \
-m 1 \
--table f1 \
--hive-database 'default' \
--hive-import \
--hive-overwrite \
--hive-table 'hivef1' \
--fields-terminated-by ' '
```

结果：

```sql
hive> select * from hivef1;
OK
202001  shanghai        28
202001  hubei   4950
202001  hebei   700
202001  beijing 342
202001  hunan   301
```
