package club.rainzhang.breakfast.service;


import club.rainzhang.breakfast.entity.*;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author wrj
 */

public interface CustomerService {
    /**
     * 首页获取店铺及部分商品信息
     * @return 暂时返回商店信息
     */
    List<Shop> getShopList();

    /**
     * 模糊搜索根据名称搜索特定店铺
     * @param name 店铺名
     * @return 店铺列表
     */
    List<Shop> getCertainShopList(String name);


    /**
     * 查看个人信息
     * @param userId 用户Id
     * @return 返回该用户信息
     */
    User getPersonalInfo(Integer userId);

    /**
     * 修改个人信息
     * @param user 个人信息
     * @return 状态码
     */
    int updatePersonalInfo(User user);

    /**
     *创建订单
     * @param orderInfo 订单信息
     * @return 状态码
     */
    Order generateOrder(JSONObject orderInfo);

    /**
     * 查看所有订单
     * @param userId 用户id
     * @return 订单列表
     */
    List<Order> getAllOrders(Integer userId);

    /**
     * 查看特定订单详情
     * @param orderId 订单id
     * @return orderInfo list
     */
    List<OrderInfo> getOrderDetail(Integer orderId);

    /**
     * 确认收货
     * @param orderId 订单的 orderId
     * @return 状态码
     */
    int ensureOrder(Integer orderId);

    /**
     * 获取收货地址列表
     * @param userId 用户的 userId
     * @return 地址集合
     */
    List<Address> getAddresses(Integer userId);

    /**
     * 添加收货地址
     * @param address 地址
     * @param userId 用户的 userId
     * @return 状态码
     */
    int addAddress(Integer userId,String address);

    /**
     * 修改现有收货地址
     * @param address 地址对象
     * @return 状态码
     */
    int updateAddress(Address address);

    /**
     * TODO
     * 删除收货地址
     * @param addressId 地址的 addressId
     * @return 状态码
     */
    int deleteAddress(Integer addressId);

    /**
     * 查看店铺内商品
     * @param shopId 商店 Id
     * @return list
     */
    List<Food> getFoodList(Integer shopId);

    /**
     * 根据名称模糊查找店铺内特定商品
     * @param  shopId  foodName
     * @param foodName 店铺的名字
     * @return foodlist
     */
    List<Food> getCertainFoodList(Integer shopId, String foodName);

}
