package com.sinodata.lottery.wh_order.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@TableName(value = "wh_order")
public class Order {

    Long id;
    String sn;
    Long num;
    Long money;
}
