# seata-demo
seata整合nacos springcloud

        1.依赖seata-all
        2.依赖seata-spring-boot-starter，支持yml、properties配置(替代 *.conf)，内部已依赖seata-all
        3.依赖spring-cloud-alibaba-seata，内部集成了seata，并实现了xid传递
- seata TC服务配置文件存放位置 

        1.config/file.conf
        2.config/registry.conf

- seata配置文件参数详细介绍 
    - https://github.com/seata/seata/blob/develop/script/config-center/config.txt
            

- master分支  order服务和storage服务通过本地配置ip方式将RM注册到 seata-server


- nacos-re分支 order服务和storage服务通过nacos方式将RM注册到 seata-server

- 支持两个服务分别连接两个数据源，以及两个服务连接一个数据源两种模式的分布式事务


-参考文档 https://github.com/seata/seata-samples/tree/master/springcloud-nacos-seata