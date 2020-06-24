package com.example;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Objects;

/**
 * @Author: sukang
 * @Date: 2020/6/24 9:34
 */
@Service
@Slf4j
public class StorageService {

    @Inject
    private OrderService orderService;

    @Resource
    JdbcTemplate jdbcTemplate;

    @GlobalTransactional(rollbackFor = Exception.class,name = "transactional-demo-1")
    public String buy(String userName,Integer orderNum){
        String sql = "UPDATE storage_tbl set count = count - %d WHERE id = 1;";
        //库存服务减库存操作
        int updateId = jdbcTemplate.update(String.format(sql, orderNum));

        Integer query = jdbcTemplate.queryForObject("SELECT count FROM `storage_tbl` WHERE id = 1;", Integer.class);

        log.info("库存{}扣减成功，扣减后的余额为{}",updateId,query);

        //订单服务创建订单
        Integer orderId = orderService.create(userName, orderNum);

        log.info("订单服务创建订单成功{}",orderId);
        Objects.requireNonNull(null);
        return buildResult(userName,orderId);
    }

    private String buildResult(String userName,Integer orderId){
        String result = "{\"code\":\"success\",\"name\":\"%s\",\"resultId\":\"%d\"}";
        return String.format(result,userName,orderId);
    }


}
