## 介绍
[AirClientWeb](https://github.com/BUGHERE/AirClientWeb)项目是一个航空公司客户数据可视化项目，本项目的技术栈基于 SpringBoot + MyBatis + Thymeleaf + Echarts + Mysql + HDFS + Hive + Sqoop

![image](https://github.com/BUGHERE/AirClientWeb/assets/55886903/8621155f-c771-4cc2-8ffc-cdce62275cbc)

## 数据来源

本项目使用的数据集是RITA数据集，它是美国国内商业航班从1987年到2008年航班到达和起飞详细信息的航空公司数据集，该数据集是以逗号分隔的CSV格式，数据集下载位置：http://stat-computing.org/dataexpo/2009/the-data.html

考虑到设备处理性能，我们并没有用这个完整的数据，我们截取其中的一部分（大概6万条数据）进行分析和处理

## 数据处理（源码不包含这部分，仅作介绍）

本项目使用 HDFS + Hive + HBase 技术进行数据处理和存储，并通过 Sqoop 技术将数据存储到 Mysql 数据库中

为了模拟分布式计算环境，我们构建了一个由三台 CentOS 虚拟机组成的集群。在这个集群中，一台虚拟机被配置为主节点，负责协调和管理整个计算流程；其余两台虚拟机则作为从节点，执行具体的计算任务
