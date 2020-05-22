package com.sinodata.lottery.wh_order.controller;

import com.sinodata.lottery.wh_order.core.ApiResp;
import com.sinodata.lottery.wh_order.domain.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.sinodata.lottery.wh_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api(value = "游戏")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/")
    @ApiOperation(notes = "测试", value = "create")
    public ApiResp<Object> crate(@RequestBody Order order) {
        orderService.create(order);
        return ApiResp.ok(order.getId());
    }

    @GetMapping("/{id}")
    @ApiOperation(notes = "测试", value = "getOrderById")
    public ApiResp<Object> findOrderById(@PathVariable("id") Long id) {
        Order o = orderService.findById(id);
        System.out.println(" @@@@@findOrderById " + o);
        return ApiResp.ok(o);
    }

    @PutMapping("/{id}")
    @ApiOperation(notes = "测试", value = "updateById")
    public ApiResp<Object> updateById(@PathVariable("id") Long id, @RequestBody Order order) {
        return ApiResp.ok(orderService.updateById(id, order));
    }

    @GetMapping("/")
    @ApiOperation(notes = "测试", value = "order list")
    public ApiResp<Object> queryGamesForPage(Integer current, Integer size) {
        return ApiResp.ok(orderService.getByPage(current, size));
    }
}
