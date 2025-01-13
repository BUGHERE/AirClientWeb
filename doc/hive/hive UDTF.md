
# Hive UDTF

UDTF (User-Defined Table-Generating Functions) 用来解决输入一行输出多行 (one-to-many mapping) 的需求。

## 1. 编写 UDTF 流程

1. 继承 `org.apache.hadoop.hive.ql.udf.generic.GenericUDTF`。
2. 实现 `initialize()`，`process()`，`close()` 三个方法。
3. UDTF 首先会调用 `initialize()` 方法，此方法返回 UDTF 的返回行的信息（返回个数，类型）。
4. 初始化完成后会调用 `process()` 方法，对传入的参数进行处理，可以通过 `forward()` 方法把结果返回。
5. 最后调用 `close()` 对需要清理的方法进行清理。

## 2. 原始数据

### 创建学生爱好表

```sql
hive> create table student11(
    id int,
    name string,
    hobby string
) row format delimited fields terminated by ' ';
```

### 本地数据

```bash
[hadoop@h201 hhh]$ cat student11.txt 
1001 zs sport:pingpong,sport:basketball,music:folk
1002 ls sport:football,music:rock,art:draw
1003 ww music:rap,sport:basketball
```

### 导入数据

```sql
hive> load data local inpath '/home/hadoop/hhh/student11.txt' overwrite into table student11;
```

## 3. 开发

### 分割爱好字段，多行显示

```java
package com.hzr;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

public class myudtf1 extends GenericUDTF {

    @Override
    public void close() throws HiveException {
    }

    @Override
    public StructObjectInspector initialize(ObjectInspector[] args)
            throws UDFArgumentException {
        List<String> fieldNames = new ArrayList<String>();
        List<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
        fieldNames.add("c1");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("c2");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] args) throws HiveException {
        String input = args[0].toString();
        String[] test = input.split(",");
        for (int i = 0; i < test.length; i++) {
            try {
                String[] result = test[i].split(":");
                forward(result);
            } catch (Exception e) {
                continue;
            }
        }
    }
}
```

## 4. 打包执行

### 4.1 拷贝到 Linux 上

```bash
[hadoop@h201 ~]$ cp /ff/hivejar/myudtf.jar /home/hadoop/qq/
```

### 4.2 执行 UDTF

#### 添加 jar 包到 Hive 中

```sql
hive> add jar /home/hadoop/qq/myudtf.jar;
```

#### 创建 UDTF 函数 `udtf11`

```sql
hive> create temporary function udtf11 as 'com.hzr.myudtf1';
```

#### 查看数据

```sql
hive> select * from student11;
```

结果：

```text
id      name    hobby
1001    zs      sport:pingpong,sport:basketball,music:folk
1002    ls      sport:football,music:rock,art:draw
1003    ww      music:rap,sport:basketball
```

#### 显示字段名

```sql
hive> set hive.cli.print.header=true;
```

#### 应用 UDTF 函数

```sql
hive> select udtf11(hobby) from student11;
```

结果：

```text
c1      c2
sport   pingpong
sport   basketball
music   folk
sport   football
music   rock
art     draw
music   rap
sport   basketball
```
