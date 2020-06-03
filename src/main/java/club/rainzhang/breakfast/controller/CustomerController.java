package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.*;
import club.rainzhang.breakfast.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 *  @author wrj
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //获取店铺列表
    @PostMapping("/getShopList")
    public List<Shops> getShops(){ return customerService.getShopList(); }

    //获取个人信息
    @PostMapping("/getPersonalInfo")
    public User getPersonalData(@RequestBody User user){return customerService.getPersonalInfo(user.getUserId()); }

    //修改个人信息
    @PostMapping("/setPersonalInfo")
    public Integer setPersonalInfo(@RequestBody User user) {
        return customerService.updatePersonalInfo(user);
    }

    //获取店铺商品列表
    @PostMapping("/getFoodsList/")
    public List<Foods> getFoodsList(@RequestBody Shops shop){ return customerService.getFoodList(shop.getShopId());}

    //获取订单列表
    @PostMapping("/getOrdersList")
    public List<Orders> getOrdersList(@RequestBody User user){return customerService.getAllOrders(user.getUserId());}

    //确认收货
    @PostMapping("/ensureOrder")
    public Integer ensureOrder(@RequestBody Orders order){return customerService.ensureOrder(order.getOrderId());}

}
