package club.rainzhang.breakfast.service;


import club.rainzhang.breakfast.entity.*;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * @author wrj
 */

public interface CustomerService {
    /**
     * 首页获取店铺及部分商品信息
     * @return 暂时返回商店信息
     */
    List<Shops> getShopList();

    /**
     * 模糊搜索根据名称搜索特定店铺
     * @return 店铺列表
     */
    List<Shops> getCertainShopList(String name);


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
    Orders generateOrder(JSONObject orderInfo);

    /**
     * 查看所有订单
     * @param userId 用户id
     * @return 订单列表
     */
    List<Orders> getAllOrders(Integer userId);

    /**
     * 查看特定订单详情
     * @param orderId 订单id
     * @return orderInfo list
     */
    List<OrderInfo> getOrderDetail(Integer orderId);

    /**
     * 确认收货
     *
     * @return 状态码
     */
    int ensureOrder(Integer orderId);

    /**
     * 获取收货地址列表
     *
     *
     */
    List<Addresses> getAddresses(Integer userId);

    /**
     * 添加收货地址
     *
     * @return 状态码
     */
    int addAddress(Integer userId,String address);

    /**
     * 修改现有收货地址
     * @return 状态码
     */
    int updateAddress(Addresses address);

    /**
     * 删除收货地址
     *TODO 待实现
     * @return 状态码
     */
    int deleteAddress(Integer addressId);

    /**
     * 查看店铺内商品
     * @param shopId 商店 Id
     * @return list
     */
    List<Foods> getFoodList(Integer shopId);

    /**
     * 根据名称模糊查找店铺内特定商品
     * @param  shopId  foodName
     * @return foodlist
     */
    List<Foods> getCertainFoodList(Integer shopId,String foodName);




}
