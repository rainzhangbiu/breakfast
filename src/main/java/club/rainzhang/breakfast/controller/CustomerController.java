package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.*;
import club.rainzhang.breakfast.service.CustomerService;
import com.alibaba.fastjson.JSONObject;
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

    //模糊查询店铺列表
    @PostMapping("getCertainShopList")
    public List<Shops> getCertainShopList(@RequestBody Shops shop){return customerService.getCertainShopList(shop.getShopName());}

    //获取个人信息
    @PostMapping("/getPersonalInfo")
    public User getPersonalData(@RequestBody User user){return customerService.getPersonalInfo(user.getUserId()); }

    //修改个人信息
    @PostMapping("/setPersonalInfo")
    public Integer setPersonalInfo(@RequestBody User user) {
        return customerService.updatePersonalInfo(user);
    }

    //获取收货地址
    @PostMapping("/getAddress")
    public List<Addresses> getAddress(@RequestBody User user) {return customerService.getAddresses(user.getUserId());}

    //添加收货地址
    @PostMapping("/addAddress")
    public Integer addAddress(@RequestBody Addresses addresses) {return customerService.addAddress(addresses.getUserId(),addresses.getAddress());}

    //删除收货地址
    @PostMapping("/deleteAddress")
    public Integer deleteAddress(@RequestBody Addresses addresses){return customerService.deleteAddress(addresses.getAddressId());}

    //修改收货地址
    @PostMapping("/updateAddress")
    public Integer updateAddress(@RequestBody Addresses address){return  customerService.updateAddress(address);}


    //获取店铺商品列表
    @PostMapping("/getFoodsList")
    public List<Foods> getFoodsList(@RequestBody Shops shop){ return customerService.getFoodList(shop.getShopId());}

    //模糊查询特定商品
    @PostMapping("/getCertainFoodsList")
    public List<Foods> getCertainFoodsList(@RequestBody Foods food){return customerService.getCertainFoodList(food.getShopId(),food.getFoodName());}

    //获取订单列表
    @PostMapping("/getOrdersList")
    public List<Orders> getOrdersList(@RequestBody User user){return customerService.getAllOrders(user.getUserId());}

    //创建订单
    @PostMapping("/generateOrder")
    public Orders generateOrder(@RequestBody JSONObject jsonObject){return customerService.generateOrder(jsonObject);}

    //查看订单详情
    @PostMapping("/getOrderDetail")
    public List<OrderInfo> getOrderDetail(@RequestBody Orders order){return customerService.getOrderDetail(order.getOrderId());}

    //确认收货
    @PostMapping("/ensureOrder")
    public Integer ensureOrder(@RequestBody Orders order){return customerService.ensureOrder(order.getOrderId());}



}
