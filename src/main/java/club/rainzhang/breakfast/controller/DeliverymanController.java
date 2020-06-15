package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.service.DeliverymanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zyyy
 */
@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {
    @Autowired
    private DeliverymanService deliverymanService;

    /**
     * 查看所有需要配送的订单
     * @return 需要配送的订单集合
     */
    @GetMapping("/findOrders")
    public List<Order> findByStatus() {
        return deliverymanService.findOrderNeededDelivered();
    }

    /**
     * 改变订单的状态
     * @param orderId 订单的 id
     * @param userId 配送员的 id
     * @return 操作的结果
     */
    @GetMapping("/changeOrder/{orderId}/{userId}")
    public int getOrder(@PathVariable("orderId") Integer orderId, @PathVariable("userId") Integer userId) {
        User deliveryman = new User();
        deliveryman.setUserId(userId);
        return deliverymanService.changeOrder(orderId,deliveryman);
    }

    /**
     * 查看自己的所有订单
     * @param deliverymanId 配送员 id
     * @return 订单集合
     */
    @GetMapping("/findMyOrders/{deliverymanId}")
    public List<Order> findMyOrders(@PathVariable("deliverymanId") Integer deliverymanId) {
        return deliverymanService.findMyOrders(deliverymanId);
    }

}
