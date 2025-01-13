
# 伪分布式模式配置和部署

所有操作用户均为：`icss`  
所有操作均在 master 上执行，只启动 master 即可。

## 0. 验证环境准备

```bash
ssh localhost
```

## 1. 下载、上传、解压

### 1.1 移动

```bash
mv ~/software/hadoop-3.1.2.tar.gz ~/
```

### 1.2 解压

```bash
tar -xzvf ~/hadoop-3.1.2.tar.gz
```

### 1.3 目录改名

```bash
mv ~/hadoop-3.1.2 ~/hadoop3
```

## 2. 配置 & 运行

伪分布式配置，需要配置 3 个部分：配置 Hadoop 运行环境、配置 Linux 运行环境、配置 Hadoop 的 XML 配置文件。

### 2.1 配置 Hadoop 运行环境

编辑 `hadoop-env.sh` 文件：

```bash
vi ~/hadoop3/etc/hadoop/hadoop-env.sh
```

加入以下内容：

```bash
# 设置 JAVA_HOME 环境变量，可以使用 Linux 的 ~/.bash_profile 设置的环境变量，推荐使用此处配置
export JAVA_HOME=/usr/java/jdk1.8.0_211
```

### 2.2 配置 Linux 运行环境

编辑 `.bash_profile` 文件：

```bash
vi ~/.bash_profile
```

加入以下内容：

```bash
# for Hadoop
export HADOOP_HOME=$HOME/hadoop3
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native
export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib/native:$HADOOP_COMMON_LIB_NATIVE_DIR"
export YARN_HOME=$HOME/hadoop3
export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
# export YARN_CONF_DIR=$YARN_HOME/etc/hadoop
# YARN_CONF_DIR 是降级的环境变量，应该用 HADOOP_CONF_DIR 替换
export HDFS_CONF_DIR=$HADOOP_HOME/etc/hadoop
export PATH=.:$JAVA_HOME/lib:$HADOOP_HOME/sbin:$HADOOP_HOME/bin:$PATH
```

### 2.3 配置 XML 文件之一：配置 Hadoop 核心和分布式文件系统

#### 2.3.1 配置 core-site.xml

编辑 `core-site.xml` 文件：

```bash
vi ~/hadoop3/etc/hadoop/core-site.xml
```

加入以下内容：

```xml
<configuration>
  <property>
    <name>fs.defaultFS</name>
    <value>hdfs://localhost:9000</value>
    <description>
      设置分布式文件系统的访问端口号，此处必须设置为 localhost
    </description>
  </property>
</configuration>
```

#### 2.3.2 配置 hdfs-site.xml

编辑 `hdfs-site.xml` 文件：

```bash
vi ~/hadoop3/etc/hadoop/hdfs-site.xml
```

加入以下内容：

```xml
<configuration>
  <property>
    <name>dfs.replication</name>
    <value>1</value>
    <description>
      设置分布式文件系统的文件分块的复制块数，推荐最大设置为 3 且不能大于集群中 Datanode 节点的数量
      此处为单机版的伪分布式模式，只有一个节点，故此设置为 1
    </description>
  </property>
</configuration>
```

### 2.4 运行 & 启动 Hadoop HDFS

#### 2.4.1 让运行环境变量生效

```bash
source .bash_profile
```

### 2.5 配置 XML 文件之二：配置 MapReduce 和 YARN

#### 2.5.1 配置 mapred-site.xml

编辑 `mapred-site.xml` 文件：

```bash
vi ~/hadoop3/etc/hadoop/mapred-site.xml
```

加入以下内容：

```xml
<configuration>
  <property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
  </property>
  <property>
    <name>mapreduce.application.classpath</name>
    <value>/home/icss/hadoop3/etc/hadoop:/home/icss/hadoop3/share/hadoop/common/lib/*:/home/icss/hadoop3/share/hadoop/common/*:/home/icss/hadoop3/share/hadoop/hdfs:/home/icss/hadoop3/share/hadoop/hdfs/lib/*:/home/icss/hadoop3/share/hadoop/hdfs/*:/home/icss/hadoop3/share/hadoop/mapreduce/lib/*:/home/icss/hadoop3/share/hadoop/mapreduce/*:/home/icss/hadoop3/share/hadoop/yarn:/home/icss/hadoop3/share/hadoop/yarn/lib/*:/home/icss/hadoop3/share/hadoop/yarn/*</value>
  </property>
</configuration>
```

#### 2.5.2 配置 yarn-site.xml

编辑 `yarn-site.xml` 文件：

```bash
vi ~/hadoop3/etc/hadoop/yarn-site.xml
```

加入以下内容：

```xml
<configuration>
  <property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
    <description>
      NodeManager 上运行的附属服务。需配置成 mapreduce_shuffle，才可运行 MapReduce 程序。
    </description>
  </property>
  <property>
    <name>yarn.resourcemanager.address</name>
    <value>slave01:18040</value>
  </property>
  <property>
    <name>yarn.resourcemanager.scheduler.address</name>
    <value>slave01:18030</value>
  </property>
  <property>
    <name>yarn.resourcemanager.resource-tracker.address</name>
    <value>slave01:18025</value>
  </property>
  <property>
    <name>yarn.resourcemanager.admin.address</name>
    <value>slave01:18141</value>
  </property>
  <property>
    <name>yarn.resourcemanager.webapp.address</name>
    <value>slave01:18080</value>
  </property>
  <property>
    <name>yarn.application.classpath</name>
    <value>/home/icss/hadoop3/etc/hadoop:/home/icss/hadoop3/share/hadoop/common/lib/*:/home/icss/hadoop3/share/hadoop/common/*:/home/icss/hadoop3/share/hadoop/hdfs:/home/icss/hadoop3/share/hadoop/hdfs/lib/*:/home/icss/hadoop3/share/hadoop/hdfs/*:/home/icss/hadoop3/share/hadoop/mapreduce/lib/*:/home/icss/hadoop3/share/hadoop/mapreduce/*:/home/icss/hadoop3/share/hadoop/yarn:/home/icss/hadoop3/share/hadoop/yarn/lib/*:/home/icss/hadoop3/share/hadoop/yarn/*</value>
  </property>
</configuration>
```

### 2.6 运行 & 启动 Hadoop

#### 2.6.1 启动 Hadoop HDFS

##### 1. 格式化 HDFS 文件系统（最初只做一次）

```bash
hdfs namenode -format
```

只要都是 INFO 的信息，就是没有错误。

##### 2. 启动守护进程（Hadoop 的 HDFS 的守护进程）

```bash
start-dfs.sh
```

##### 3. 退出守护进程（Hadoop 的 HDFS 的守护进程）

```bash
stop-dfs.sh
```

#### 2.6.2 验证

```bash
jps
```

输出：

```plaintext
1569 NameNode
1861 SecondaryNameNode
1672 DataNode
```

有这三个进程，就是配置正确了！前面的进程号不重要。

```bash
hdfs dfsadmin -report
```

查看 HDFS 的信息。

### 2.7 启动 Hadoop YARN

#### 2.7.1 启动守护进程（Hadoop 的 MapReduce & YARN 的守护进程）

```bash
start-yarn.sh
```

#### 2.7.2 退出守护进程（Hadoop 的 MapReduce & YARN 的守护进程）

```bash
stop-yarn.sh
```

### 2.8 启动和退出全部守护进程

#### 启动全部守护进程

```bash
start-all.sh
```

#### 退出全部守护进程

```bash
stop-all.sh
```

### 2.9 解决内存不足问题

在 `yarn-site.xml` 文件中配置：

```xml
<property>
  <name>yarn.nodemanager.pmem-check-enabled</name>
  <value>false</value>
</property>
<property>
  <name>yarn.nodemanager.vmem-pmem-ratio</name>
  <value>10</value>
</property>
<property>
  <name>mapreduce.map.memory.mb</name>
  <value>4096</value>
  <source>mapred-default.xml</source>
</property>
<property>
  <name>mapreduce.reduce.memory.mb</name>
  <value>4096</value>
  <source>mapred-default.xml</source>
</property>
```

### 2.10 验证

```bash
jps
```

```bash
http://localhost:9870
```

```bash
yarn resourcemanager -status
```

查看 YARN 的 ResourceManager 节点的状态。
