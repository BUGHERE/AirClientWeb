# Hive UDF

## 1. UDF

UDF：进来一个出去一个，row mapping。是 row 级别操作开发。

## 2. 原始数据

### 创建销售工资表

```sql
hive> create table if not exists sale12(
    id bigint,
    sal float,
    sale float,
    mdate string
) row format delimited fields terminated by ',';
```

### 本地数据

```bash
[hadoop@h201 hhh]$ cat sale12.txt 
10001,5000,100500,20200202
10002,6000,600000,20200202
10003,5000,50000,20200202
10004,5000,280000,20200202
10005,8000,980000,20200202
10001,5000,205800,20200102
10002,6000,250000,20200102
```

### 导入数据

```sql
hive> load data local inpath '/home/hadoop/hhh/sale12.txt' into table sale12;
```

## 3. 开发

### 开发流程

1. 集成 UDF 类
2. 重写 `evaluate` 方法

```java
package com.hzr;

import org.apache.hadoop.hive.ql.exec.UDF;

public class myudf extends UDF {
    public float evaluate(float a, float b) {
        if (b > 100000 && b <= 200000) {
            return (float) (a + b * 0.05);
        } else if (b > 200000 && b <= 500000) {
            return (float) (a + b * 0.08);
        } else if (b > 500000) {
            return (float) (a + b * 0.15);
        } else {
            return a;
        }
    }
}
```

## 4. 生成 jar 包并执行

### 4.1 拷贝到 Linux 上

```bash
[hadoop@h201 ~]$ cp /ff/hivejar/udf1.jar /home/hadoop/qq/
```

### 4.2 执行 UDF

#### 添加 jar 包到 Hive 中

```sql
hive> add jar /home/hadoop/qq/udf1.jar;
```

#### 创建 UDF 函数 `udf123`

```sql
hive> create temporary function udf123 as 'com.hzr.myudf';
```

#### 显示字段名

```sql
hive> set hive.cli.print.header=true;
```

#### 应用 UDF 函数

```sql
hive> select udf123(sal, sale) as gongzi from sale12;
```

结果：

```text
gongzi
10025.0
96000.0
5000.0
27400.0
155000.0
21464.0
26000.0
```
