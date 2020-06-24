package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sukang
 * @Date: 2020/6/22 20:17
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    JdbcTemplate jdbcTemplate;

    @PostMapping("create/order/{userId}/{orderCount}")
    public Integer create(@PathVariable("userId") String userId, @PathVariable("orderCount") int orderCount){

        String sql = "INSERT INTO `order`.`order_tbl`(`user_id`, `commodity_code`, `count`, `money`)" +
                " VALUES ('%s', 'aa', %d, 300);";


        String format = String.format(sql, userId, orderCount);

        if (orderCount >= 3){
         throw new IllegalArgumentException("模拟参数错误，订单创建失败回滚");
        }
        int update = jdbcTemplate.update(format);

        log.info("创建订单成功");
        return update;
    }









}
