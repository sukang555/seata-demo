# seata-demo
seata整合nacos springcloud
- seata TC服务配置文件 

        1.config/file.conf
     
        2.config/registry.conf

- seata配置文件 seataConfig.txt 
    - https://github.com/seata/seata/blob/develop/script/config-center/config.txt
            

- master分支  order服务和storage服务通过本地配置ip方式将RM注册到 seata-server


- nacos-re分支 order服务和storage服务通过nacos方式将RM注册到 seata-server
