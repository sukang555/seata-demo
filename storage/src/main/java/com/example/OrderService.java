package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

/**
 * @Author: sukang
 * @Date: 2020/6/22 20:01
 */
@FeignClient(value = "seata-order")
public interface OrderService {

    @PostMapping("create/order/{userId}/{orderCount}")
    Integer create(@PathVariable("userId") String userId,@PathVariable("orderCount") int orderCount);
}
