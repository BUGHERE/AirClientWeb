
# Sqoop Export

`sqoop export` 是指将 HDFS 上的数据导出到 RDBMS 上，而在 RDBMS 上目标表要已经存在。

## 1. HDFS 导出到 MySQL

### 1）原始数据

```bash
[hadoop@h201 ~]$ vi a.txt
101     zs      100000
102     ls      200000
```

（tab 分割）

```bash
[hadoop@h201 ~]$ hadoop fs -put a.txt /hive123
```

### MySQL 创建测试表

```sql
mysql> create table c1(col1 int primary key, col2 varchar(50), coll3 int);
```

### 2）导出到 MySQL

```bash
[hadoop@h201 ~]$ sqoop export --connect jdbc:mysql://h201/spark1 --username spark --password spark123 --export-dir /hive123/a.txt -m 1 --table c1 --fields-terminated-by '\t'
```

## 2. Export 更新数据

### 1）原始数据

```bash
[hadoop@h201 ~]$ cat b.txt 
101     zs      50000
103     ww      90000
#（101 跟任务1中的id相同，但coll3字段不同）
```

```bash
[hadoop@h201 ~]$ hadoop fs -put b.txt /hive123

[hadoop@h201 ~]$ cat c.txt 
103     ww      999999
109     zl      850000

[hadoop@h201 ~]$ hadoop fs -put c.txt /hive123/
```

### 2）参数说明

- `--update-key` 指定要更新的列
- `--update-mode` 对应的参数有两种：`updateonly` 或者 `allowinsert`
  - `allowinsert`：`update-key` 字段存在的更新，不存在的插入
  - `updateonly`：`update-key` 字段存在的更新，不存在的丢弃

### 3）allowinsert

```bash
[hadoop@h201 ~]$ sqoop export --connect jdbc:mysql://h201/spark1 --username spark --password spark123 --export-dir /hive123/b.txt -m 1 --table c1 --input-fields-terminated-by '\t' --update-key col1 --update-mode allowinsert
```

101 对应的 coll3 已经更新

### 4）updateonly

```bash
[hadoop@h201 ~]$ sqoop export --connect jdbc:mysql://h201/spark1 --username spark --password spark123 --export-dir /hive123/c.txt -m 1 --table c1 --input-fields-terminated-by '\t' --update-key col1 --update-mode updateonly
```

103 的值已经更新，但 109 被丢弃

## 3. 批量导出

虽然 Sqoop 的导出功能符合需要，但速度太慢。每一行都插入到单独的 `insert` 语句中，是否有方法将多个 `insert` 语句一起批处理？

- `--batch` 指定是否使用批量处理。默认是一条一条记录处理。

```bash
[hadoop@h201 ~]$ sqoop export --connect jdbc:mysql://h201/spark1 --username spark --password spark123 --export-dir /hive123/a.txt -m 1 --table c1 --fields-terminated-by '\t' --batch
```
