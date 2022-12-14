package com.atguigu.common.constant;

public class MqConst {

    // 微服务名-event-exchange
    public static final String EXCHANGE_ORDER_EVENT = "order-event-exchange";







    //订单超时
    public static final long ORDER_TIMEOUT = 60000*30;



    //订单关单延迟队列   微服务名-功能-queue
    public static final String QUEUE_ORDER_DELAY = "order-delay-queue";
    public static final String QUEUE_ORDER_DEAD = "order-dead-queue";
    public static final String QUEUE_ORDER_PAYED = "order-payed-queue";
    //
    public static final String QUEUE_WARE_ORDER = "queue.ware.order";




    //订单超时路由键    微服务名-事件
    public static final String RK_ORDER_TIMEOUT = "order.timeout";
    public static final String RK_ORDER_CREATE = "order.create";
    public static final String RK_ORDER_PAYED = "order.payed";


    public static final String EXCHANGE_WARE_SYS = "exchange.direct.ware.stock";
    public static final String RK_WARE_STOCK = "ware.stock";
    public static final String EXCHANGE_SECKILL_EVENT = "seckill-event-exchange";
    public static final String QUEUE_SECKILL_QUEUE = "seckill-queue-queue"; //秒杀排队队列

    public static final String RK_SECKILL_QUEUE = "seckill.queue";

}
