package club.rainzhang.breakfast.service;


import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.entity.User;
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
    int generateOrder(JSONObject orderInfo);

    /**
     * 查看所有订单
     * @param userId 用户id
     * @return 订单列表
     */
    List<Orders> getAllOrders(Integer userId);


    /**
     * 确认收货
     *
     * @return 状态码
     */
    int ensureOrder(Integer orderId);


    /**
     * 查看店铺内商品
     * @param shopId 商店 Id
     * @return list
     */
    List<Foods> getFoodList(Integer shopId);




}
