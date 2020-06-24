package com.example.controller;

import com.example.OrderService;
import com.example.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @Author: sukang
 * @Date: 2020/6/22 16:50
 */
@RestController
@Slf4j
public class OrderController {

   @Inject
   private StorageService storageService;

    @GetMapping(value = "/order/buy/{userName}/{orderNum}")
    public String buySomeThings(
            @PathVariable(value = "userName") String userName,
            @PathVariable(value = "orderNum") Integer orderNum){
        return storageService.buy(userName,orderNum);
    }










}
