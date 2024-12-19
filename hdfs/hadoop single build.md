
# Hadoop 3.x 安装说明

安装之前，需要明确几个点：安装方式、Hadoop 三种运行模式、运行 Hadoop 的用户、Hadoop 下载、相关配置。

## 0. 安装方式

1. 确定运行模式
2. 确定运行用户
3. 下载 Hadoop 安装文件
4. 上传 Hadoop 安装文件
5. 解压 Hadoop 安装文件
6. 配置：
   - 配置 XML 文件
   - 配置集群组成文件
   - 配置 Linux 环境变量
   - 配置 Hadoop 环境变量

## 1. Hadoop 三种运行模式

### 1.1 独立(本地)模式

无需任何守护进程，所有程序都在同一个 JVM 上执行。一般在独立模式下测试和调试 MapReduce 程序，多在开发阶段使用该模式。

### 1.2 伪分布模式

Hadoop 守护进程运行在本地机器上，模拟一个小规模的集群。此种方式特别适合部分同学机器性能不能支撑的情况。

### 1.3 集群(全分布)模式

Hadoop 守护进程运行在一个集群的多台机器上。

**思考**：守护进程是什么？有哪些？

## 2. 运行 Hadoop 的用户

一般以指定用户运行 Hadoop，即以指定用户执行 Hadoop 的守护进程。我们的例子中，使用 `icss` 用户。

Hadoop 原生组件：HDFS、YARN、MapReduce

其他组件：Hive、Spark、HBase

## 3. Hadoop 下载

### 3.1 Apache Hadoop

主页：http://hadoop.apache.org/index.html

### 3.2 Hadoop releases

下载地址：http://hadoop.apache.org/releases.html

### 3.3 下载 hadoop-3.1.2

1. 安装文件：`hadoop-3.x.x.tar.gz`
2. 源代码：`hadoop-3.x.x-src.tar.gz`

## 4. 相关配置

Hadoop 的各个组件均可以利用 XML 文件进行配置，相关的 XML 文件如下：

1. `core-site.xml`：核心配置文件，用于配置核心通用属性。
2. `hdfs-site.xml`：HDFS 配置文件，用于配置 HDFS 属性。
3. `mapred-site.xml`：MapReduce 配置文件，用于配置 MapReduce 属性。
4. `yarn-site.xml`：YARN 配置文件，用于配置 YARN 资源管理框架属性。

上述 XML 配置文件均在 Hadoop 安装路径下的 `etc/hadoop` 子目录中。除此之外，集群分布式模式还涉及其他配置文件和配置方法。

## 5. 独立(本地)模式配置和部署

这种模式只需要在 master 机器上单机执行即可。

**说明**：之前，我已经将前面的配置的虚拟机备份了，做完本次操作后，只需要还原到上一步状态，就可以进行后面的操作。

所有操作用户均为：`icss`

所有操作均在 master 上执行：只启动 master

### 5.1 下载

如上所述。

### 5.2 上传

上传 Hadoop 安装文件 `hadoop-3.1.2.tar.gz` 到 HadoopMaster 的主目录的 `software` 目录下。

### 5.3 解压

转到当前 `icss` 用户的主目录：

```bash
cd
```

将 `software` 目录下的 `hadoop-3.1.2.tar.gz` 文件移动到 `icss` 用户的主目录下：

```bash
mv ~/software/hadoop-3.1.2.tar.gz ~/
```

解压文件：

```bash
tar -xzvf hadoop-3.1.2.tar.gz
```

将解压生成的 `hadoop-3.1.2` 文件夹改名为 `hadoop3`：

```bash
mv hadoop-3.1.2 hadoop3
```

### 5.4 配置环境

#### 5.4.1 配置 Hadoop 环境

编辑 `hadoop-env.sh` 文件：

```bash
vi ~/hadoop3/etc/hadoop/hadoop-env.sh
```

加入以下内容：

```bash
export JAVA_HOME=/usr/java/jdk1.8.0_211
```

修改权限：

```bash
chmod +x hadoop-env.sh
```

执行：

```bash
./hadoop-env.sh
```

#### 5.4.2 配置 Linux 环境

编辑 `.bash_profile` 文件：

```bash
vi .bash_profile
```

加入以下内容：

```bash
export HADOOP_HOME=$HOME/hadoop3
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native
export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib/native:$HADOOP_COMMON_LIB_NATIVE_DIR"
export YARN_HOME=$HOME/hadoop3
export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
export YARN_CONF_DIR=$YARN_HOME/etc/hadoop
export HDFS_CONF_DIR=$HADOOP_HOME/etc/hadoop
export PATH=.:$JAVA_HOME/lib:$HADOOP_HOME/sbin:$HADOOP_HOME/bin:$PATH
```

使配置生效：

```bash
source .bash_profile
```

### 5.5 运行 & 验证

以 `icss` 用户完成本操作：

```bash
cd
```

运行 Hadoop：

```bash
hadoop
```

出现用法提示，表示生效。

查看 Hadoop 版本：

```bash
hadoop version
```

#### 5.5.1 运行

让运行环境变量生效：

```bash
source .bash_profile
```

只用在不运行守护进程时才需要执行下述操作：

在 `~/hadoop3/etc/hadoop/` 目录下，执行：

```bash
./hadoop-env.sh
```

#### 5.5.2 运行应用程序进行验证

##### 1. 测试文件正则式匹配

实际上是执行了一个 MapReduce 的操作：

```bash
cd
cd hadoop3
mkdir input
cp etc/hadoop/*.xml input/
hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-3.1.2.jar grep input output/xml 'dfs[a-z.]+'
```

`dfs[a-z.]+'` 是一个正则表达式！

查看输出：

```bash
cat output/xml/*
```

##### 2. 测试计算 PI 值

```bash
cd
cd hadoop3
hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-3.1.2.jar pi 100 1000000
```

值可以先给的小一点，再给的大一点，求 PI 会精确些。

**解决方法**：`Hadoop java.lang.OutOfMemoryError: Java heap space`

修改 `hadoop-env.sh` 文件（路径：`/etc/hadoop/hadoop-env.sh` 或 `hadoop/conf/hadoop-env.sh`）：

```bash
export HADOOP_CLIENT_OPTS="-Xmx2048m"
```

重新运行：

```bash
hadoop jar share/hadoop/mapreduce/hadoop-*-examples-3.1.2.jar pi 100 1000000
```
