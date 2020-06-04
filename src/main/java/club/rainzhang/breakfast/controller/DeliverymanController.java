package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Orders;
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

    @GetMapping("/findOrders")
    public List<Orders> findByStatus() {
        return deliverymanService.findOrderNeededDelivered();
    }

    @GetMapping("/changeOrder/{orderId}/{userId}")
    public int getOrder(@PathVariable("orderId") Integer orderId, @PathVariable("userId") Integer userId) {
        User deliveryman = new User();
        deliveryman.setUserId(userId);
        return deliverymanService.changeOrder(orderId,deliveryman);
    }

    @GetMapping("/findMyOrders/{deliverymanId}")
    public List<Orders> findMyOrders(@PathVariable("deliverymanId") Integer deliverymanId) {
        return deliverymanService.findMyOrders(deliverymanId);
    }



}
