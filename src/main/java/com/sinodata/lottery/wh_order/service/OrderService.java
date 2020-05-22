package com.sinodata.lottery.wh_order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sinodata.lottery.wh_order.domain.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinodata.lottery.wh_order.domain.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public Order findById(Long id) {
        return  orderMapper.selectById(id);
    }

    public Integer updateById(Long id, Order order){
        Order o = Optional.ofNullable(orderMapper.selectById(id)).orElseThrow(RuntimeException::new);
        return orderMapper.updateById(order);
    }

    public Order create(Order order){
        System.out.println(" @@@@@@@@@@ " + order);
        orderMapper.insert(order);
        return order;
    }

    public Map<String, Object> getByPage(Integer current, Integer size) {
        Map<String, Object> result = new HashMap<>();
        IPage<Order> page = new Page<>(current, size);
        orderMapper.selectPage(page, null);
        result.put("currentPage", current);
        result.put("pageSize", size);
        result.put("total", page.getTotal());
        result.put("data", page.getRecords());
        return result;
    }

}
