# seata-demo
seata整合nacos springcloud

        1.依赖seata-all
        2.依赖seata-spring-boot-starter，支持yml、properties配置(替代 *.conf)，内部已依赖seata-all
        3.依赖spring-cloud-alibaba-seata，内部集成了seata，并实现了xid传递
- seata TC服务配置文件 

        1.config/file.conf
     
        2.config/registry.conf

- seata配置文件 seataConfig.txt 
    - https://github.com/seata/seata/blob/develop/script/config-center/config.txt
            

- master分支  order服务和storage服务通过本地配置ip方式将RM注册到 seata-server


- @todo nacos-re分支 order服务和storage服务通过nacos方式将RM注册到 seata-server
