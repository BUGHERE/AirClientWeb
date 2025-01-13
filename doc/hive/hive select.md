# Hive 创建 `emp` 表和 `dept` 表

## 1. 创建 `dept` 表

```sql
create table dept(
    deptno int,
    dname string,
    loc string
)
row format delimited fields terminated by ' ';
```

```bash
[hadoop@h201 hhh]$ cat dept.txt
10 ACCOUNTING NewYork
20 RESEARCH Boston
30 SALES Dallas
40 OPERATIONS Chicago
```

```sql
hive> load data local inpath '/home/hadoop/hhh/dept.txt' into table dept;
```

## 2. 创建 `emp` 表

```sql
create table emp(
    empno int,
    ename string,
    job string,
    mgr int,
    hiredate string,
    sal float,
    comm float,
    deptno int
)
row format delimited fields terminated by ' ';
```

```bash
[hadoop@h201 hhh]$ cat emp.txt
MITH CLERK 7902 1980-12-17 800.00 NULL 20
7499 ALLEN SALESMAN 7698 1981-02-20 1600.00 300.00 30
7521 WARD SALESMAN 7698 1981-02-22 1250.00 500.00 30
7566 JONES MANAGER 7839 1981-04-02 2975.00 NULL 20
7654 MARTIN SALESMAN 7698 1981-09-28 1250.00 1400.00 30
7698 BLAKE MANAGER 7839 1981-05-01 2850.00 NULL 30
7782 CLARK MANAGER 7839 1981-06-09 2450.00 NULL 10
7788 SCOTT ANALYST 7566 1987-04-19 3000.00 NULL 20
7839 KING PRESIDENT NULL 1981-11-17 5000.00 NULL 10
7844 TURNER SALESMAN 7698 1981-09-08 1500.00 0.00 30
7876 ADAMS CLERK 7788 1987-05-23 1100.00 NULL 20
7900 JAMES CLERK 7698 1981-12-03 950.00 NULL 30
7902 FORD ANALYST 7566 1981-12-03 3000.00 NULL 20
7934 MILLER CLERK 7782 1982-01-23 1300.00 NULL 10
```

```sql
hive> load data local inpath '/home/hadoop/hhh/emp.txt' into table emp;
```

# 3. `select` 基本操作

## （1）显示列名

```sql
hive> set hive.cli.print.header=true;
```

## （2）限定查询行数

```sql
hive> select * from emp limit 2;
```

## （3）`where` 语句

```sql
hive> select ename, sal from emp where sal > 500 and deptno = 30;
```

## （4）`like` 语句

1. 格式是 `A like B`，其中 `A` 是字符串，`B` 是表达式，表示能否用 `B` 去完全匹配 `A` 的内容，换句话说能否用 `B` 这个表达式去表示 `A` 的全部内容，注意这个和 `rlike` 是有区别的。返回的结果是 `True/False`。
2. `B` 只能使用简单匹配符号 `_` 和 `%`，`_` 表示任意单个字符，字符 `%` 表示任意数量的字符。
3. `like` 的匹配是按字符逐一匹配的，使用 `B` 从 `A` 的第一个字符开始匹配，所以即使有一个字符不同都不行。

```sql
hive> select ename, sal from emp where ename like 'AL%';
hive> select ename, sal from emp where ename not like 'AL%';
```

## （5）`rlike` 语句

1. `A RLIKE B`，表示 `B` 是否在 `A` 里面即可。而 `A LIKE B`，则表示 `B` 是否是 `A`。
2. `B` 中的表达式可以使用 JAVA 中全部正则表达式。

```sql
hive> select ename, sal from emp where ename rlike '^S.*T$';
```

## （6）`Group by` 语句

按一个列或者多个列对数据进行分组，然后对每组的数据进行聚合操作。

```sql
hive> select deptno, avg(sal) from emp group by deptno;
```

## （7）`Having`

```sql
select deptno, avg(sal) from emp group by deptno having avg(sal) > 2000;
```

## （8）`select` 嵌套查询

```sql
hive> select a.dno, a.avgs from (select deptno as dno, avg(sal) as avgs from emp group by deptno) a where a.avgs > 2000;
```

## （9）`case when` 语句

```sql
hive> select ename, sal, case when sal < 500 then 'low' when sal >= 500 and sal < 2000 then 'middle' when sal >= 2000 and sal < 3500 then 'high' else 'very high' end as sal1 from emp;
```

## （10）聚集函数

- 个数统计函数: `count`
- 总和统计函数: `sum`
- 平均值统计函数: `avg`
- 最小值统计函数: `min`
- 最大值统计函数: `max`

# 4. `select` 多表查询

## （1）`inner join`

显示员工名字，对应的地域。

```sql
hive> select e.ename, d.loc from emp e join dept d on e.deptno = d.deptno;
```

Hive 在执行表连接时，会默认最后那个表最大，将前面的表缓存起来，扫描最后的表。因此为了效率，从左到右表的大小应该逐渐增加。

```sql
select /*+STREAMTABLE (d)*/ e.ename, d.loc from emp e join dept d on e.deptno = d.deptno;
```

还可以通过 `/*streamtable(m)*/` 指定驱动表。

## （2）`left outer join`

左连接。如果 `A left outer join B`，则 `A` 中所有记录都会被返回，如果 `B` 中无对应的记录，则相应列值为 `NULL`。

```sql
hive> select d.loc, e.ename from dept d left outer join emp e on d.deptno = e.deptno;
```

## （3）`right outer join`

返回 `join` 右边的表中所有符合条件的记录。左边表若无相应记录，则对应的列用 `NULL` 填充。

## （4）`full outer join`

返回所有表中所有符合条件的记录。连接的表若无相应记录，则对应的列用 `NULL` 填充。

## （5）`left semi join`

`left semi join` 只会返回左边的记录，但前提是右边的表必须满足 `on` 后面定义的判定条件。

```sql
hive> select a.ename, a.deptno from emp a left semi join dept b on a.deptno = b.deptno and b.loc = 'Boston';
```

## （6）笛卡儿积 `join`

笛卡尔积就是将左边表的记录和右边表的记录两两组合。如果左表有 `m` 条记录，右表有 `n` 条，那么将产生 `m * n` 条记录。笛卡儿积会消耗大量的时间。如果设置 `hive.mapred.mode=strict`，Hive 会阻止笛卡儿积查询。

```sql
hive> select a.ename, b.loc from emp a join dept b;
```

# 5. 排序

## （1）`order by`

`order by` 是将所有的记录都按 `order by` 后的字段进行排序。

```sql
hive> select ename, sal from emp order by sal desc limit 3;
```

## （2）`sort by`

`sort by` 是将每个 `reduce` 的数据进行排序，即局部地对每个分片的数据排序，而不是全局排序。

```sql
hive> select ename, sal from emp sort by sal desc limit 3;
```

## （3）`distribute by`

因为 MR 任务可能会包含多个 `reduce`，数据被分成多个分片由不同的 `reduce` 处理。`distributed by` 控制了这些 `map` 输出的数据是如何划分到 `reduce` 的。

```sql
hive> select ename, sal, deptno from emp where sal > 1500 distribute by deptno;
```

按 `deptno` 字段进行 `key` 值划分。

## （4）`cluster by`

`cluster by col` 其实相当于 `distribute by col sort by col asc`。`col` 为列名，`asc` 为升序排列也可以 `desc`。

```sql
hive> select ename, sal, deptno from emp where sal > 1500 cluster by deptno;
```
