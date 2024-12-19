
# 实践操作

## 1. 集群操作 (Hadoop 集群安装后验证的演示)

### 1.1 整体操作

启动或关闭全部服务：

```bash
start-all.sh
stop-all.sh
```

### 1.2 分步操作

启动或关闭 HDFS 和 YARN：

```bash
start-dfs.sh
stop-dfs.sh
start-yarn.sh
stop-yarn.sh
```

### 1.3 单独操作

#### 1. NameNode

在名称节点上执行：

```bash
hadoop-daemon.sh start namenode
hadoop-daemon.sh stop namenode
```

#### 2. SecondaryNameNode

在名称节点上执行：

```bash
hadoop-daemon.sh start secondarynamenode
hadoop-daemon.sh stop secondarynamenode
```

#### 3. DataNode

在名称节点上执行：

```bash
hadoop-daemons.sh start datanode  # 启动全部数据节点
hadoop-daemons.sh stop datanode   # 停止全部数据节点
```

在某个数据节点上执行：

```bash
hadoop-daemon.sh start datanode   # 启动单个数据节点
hadoop-daemon.sh stop datanode    # 停止单个数据节点
```

#### 4. ResourceManager

在名称节点上执行：

```bash
yarn-daemon.sh start resourcemanager
yarn-daemon.sh stop resourcemanager
```

#### 5. NodeManager

在名称节点上执行：

```bash
yarn-daemons.sh start nodemanager  # 启动全部 NodeManager 节点
yarn-daemons.sh stop nodemanager   # 停止全部 NodeManager 节点
```

### 1.4 替代命令

上述命令 `hadoop-daemon(s).sh` 等是降级的命令，可以替换为以下命令：

#### 整体操作

```bash
start-all.sh
stop-all.sh
```

#### 分步操作

```bash
start-dfs.sh
stop-dfs.sh
start-yarn.sh
stop-yarn.sh
```

#### 单独操作

1. NameNode：

```bash
hdfs --daemon start namenode
hdfs --daemon stop namenode
```

2. SecondaryNameNode：

```bash
hdfs --daemon start secondarynamenode
hdfs --daemon stop secondarynamenode
```

3. DataNode：

在名称节点上执行：

```bash
hdfs --workers --daemon stop datanode
```

在数据节点上执行：

```bash
hdfs --daemon start datanode
hdfs --daemon stop datanode
```

4. ResourceManager：

```bash
yarn --daemon start resourcemanager
```

5. NodeManager：

在 ResourceManager 上执行：

```bash
yarn --worker --daemon start nodemanager
yarn --worker --daemon stop nodemanager
```

在 NodeManager 上执行：

```bash
yarn --daemon start nodemanager
yarn --daemon stop nodemanager
```

## 2. MR (Hadoop 集群安装后验证的演示)

### 2.1 计算 pi

```bash
hadoop jar hadoop3/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.0.3.jar pi 5 5
```

### 2.2 Wordcount

```bash
hdfs dfs -put ~/hadoop3/etc/hadoop/*.xml /user/icss/input
hadoop jar hadoop3/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.0.3.jar grep /user/icss/input /output/xml 'dfs[a-z.]+'
hdfs dfs -cat /output/xml/*
```

## 3. HDFS 操作

### 3.1 查看 HDFS 支持的所有命令

```bash
hdfs dfs
```

### 3.2 查看某个命令的帮助文档

```bash
hdfs dfs –help ls
```

### 3.3 检查 HDFS 状态

```bash
hadoop dfsadmin –report
```

### 3.4 HDFS 安全模式操作

```bash
hadoop dfsadmin –safemode enter
hadoop dfsadmin –safemode leave
hadoop dfsadmin –safemode get
```

### 3.5 检查 HDFS 块状态

```bash
hadoop fsck /
hadoop fsck / -delete
```

### 3.6 显示目录大小

```bash
hdfs dfs –du PATH
hdfs dfs –dus PATH
hdfs dfs -du -s /
```

### 3.7 清空回收站

```bash
hdfs dfs –expunge
```

### 3.8 创建目录

```bash
hdfs dfs -mkdir /user
hdfs dfs -mkdir -p /user/icss/hadoop
```

### 3.9 列出目录内容

```bash
hdfs dfs -ls -R /user/icss/hadoop
hdfs dfs -lsr /
```

### 3.10 删除目录

```bash
hdfs dfs -rm -r -f /user/icss/hadoop
hdfs dfs -rmr -f /user/icss/hadoop
```

### 3.11 上传文件到 HDFS

```bash
hdfs dfs -put 1.txt 2.txt /user/icss
hdfs dfs –copyFromLocal test.txt /user/sunlightcs/test.txt
```

### 3.12 从 HDFS 下载文件到本地

```bash
hdfs dfs -get /user/icss/1.txt a.txt
hdfs dfs –copyToLocal /user/sunlightcs/test.txt test.txt
```

### 3.13 合并文件并下载到本地

```bash
hdfs dfs –getmerge /user /home/t
```

### 3.14 复制文件

```bash
hdfs dfs –cp SRC [SRC …] DST
```

### 3.15 显示文件内容

```bash
hdfs dfs -cat /hdfs上一个文本文件
```

### 3.16 创建空文件

```bash
hdfs dfs -touchz /hdfs上一个文件名
```

### 3.17 重命名文件

```bash
hdfs dfs -mv /data/test03.txt /data/test.txt
```
