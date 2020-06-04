package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.User;

import java.util.List;

/**
 * @author zyyy
 */
public interface DeliverymanService {
    /**
     * 查看需要配送的订单
     * @return 需要配送的订单集合
     */
    List<Orders> findOrderNeededDelivered();

    /**
     * 接单
     * @param orderId 订单 Id
     * @param user 配送员信息
     * @return 返回结果，接单成功返回 1，配送成功，失败返回 0
     */
    int changeOrder(Integer orderId, User user);

    /**
     * 查找该配送员的所有订单
     * @param deliverymanId 配送员 Id
     * @return 该配送员的所有订单
     */
    List<Orders> findMyOrders(Integer deliverymanId);


}
