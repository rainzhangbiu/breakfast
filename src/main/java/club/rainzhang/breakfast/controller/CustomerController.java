package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.*;
import club.rainzhang.breakfast.service.CustomerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  @author wrj
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 获取店铺列表
     * @return 所有营业中的店铺
     */
    @PostMapping("/getShopList")
    public List<Shop> getShops(){ return customerService.getShopList(); }

    /** 模糊查询店铺列表
     * @param shop json 数据映射为 Shop 对象，这里只需要 shop 的 name 属性
     * @return 符合要求的店铺集合
     */
    @PostMapping("getCertainShopList")
    public List<Shop> getCertainShopList(@RequestBody Shop shop){return customerService.getCertainShopList(shop.getShopName());}

    /**
     * 获取个人信息
     * @param user json 数据映射为 User 对象，这里只需要 user 的 userId 属性
     * @return 用户个人信息
     */
    @PostMapping("/getPersonalInfo")
    public User getPersonalData(@RequestBody User user){return customerService.getPersonalInfo(user.getUserId()); }

    /**
     * 修改个人信息
     * @param user json 数据映射为 User 对象
     * @return 修改的结果
     */
    @PostMapping("/setPersonalInfo")
    public Integer setPersonalInfo(@RequestBody User user) {
        return customerService.updatePersonalInfo(user);
    }

    /**
     * 获取收货地址
     * @param user json 数据映射为 User 对象，这里只需要 user 的 userId 属性
     * @return 地址集合
     */
    @PostMapping("/getAddress")
    public List<Address> getAddress(@RequestBody User user) {return customerService.getAddresses(user.getUserId());}

    /**
     * 添加收货地址
     * @param address json 数据映射为 Address
     * @return 操作的结果
     */
    @PostMapping("/addAddress")
    public Integer addAddress(@RequestBody Address address) {return customerService.addAddress(address.getUserId(), address.getAddress());}

    /**
     * 删除收货地址
     * @param address json 数据映射为 Address 对象，这里只需要 address 的 addressId 属性
     * @return 操作的结果
     */
    @PostMapping("/deleteAddress")
    public Integer deleteAddress(@RequestBody Address address){return customerService.deleteAddress(address.getAddressId());}

    /**
     * 修改收货地址
     * @param address json 数据映射为 Address 对象
     * @return 操作的结果
     */
    @PostMapping("/updateAddress")
    public Integer updateAddress(@RequestBody Address address){return  customerService.updateAddress(address);}


    /**
     * 获取店铺商品列表
     * @param shop json 数据映射为 Shop 对象，这里只需要 shop 的 shopId 属性
     * @return 商品集合
     */
    @PostMapping("/getFoodsList")
    public List<Food> getFoodsList(@RequestBody Shop shop){ return customerService.getFoodList(shop.getShopId());}

    /**
     * 模糊查询特定商品
     * @param food 用户输入的商品名称，将json 数据映射为 Food 对象，这里只需要 food 的 foodName 属性
     * @return 符合要求的商品信息集合
     */
    @PostMapping("/getCertainFoodsList")
    public List<Food> getCertainFoodsList(@RequestBody Food food){return customerService.getCertainFoodList(food.getShopId(),food.getFoodName());}

    /**
     * 获取订单列表
     * @param user json 数据映射为 User 对象，这里只需要 user 的 userId 属性
     * @return 该用户的所有订单
     */
    @PostMapping("/getOrdersList")
    public List<Order> getOrdersList(@RequestBody User user){return customerService.getAllOrders(user.getUserId());}

    /**
     * 创建订单
     * @param jsonObject json 对象，在 Service 层进行处理
     * @return 创建好的订单信息
     */
    @PostMapping("/generateOrder")
    public Order generateOrder(@RequestBody JSONObject jsonObject){return customerService.generateOrder(jsonObject);}

    /**
     * 查看订单详情
     * @param order json 数据映射为 Order 对象，这里只需要 order 的 orderId 属性
     * @return 指定订单的订单详细信息集合
     */
    @PostMapping("/getOrderDetail")
    public List<OrderInfo> getOrderDetail(@RequestBody Order order){return customerService.getOrderDetail(order.getOrderId());}

    /**
     * 确认收货
     * @param order json 数据映射为 Order 对象，这里只需要 order 的 orderId 属性
     * @return 操作的结果
     */
    @PostMapping("/ensureOrder")
    public Integer ensureOrder(@RequestBody Order order){return customerService.ensureOrder(order.getOrderId());}



}
