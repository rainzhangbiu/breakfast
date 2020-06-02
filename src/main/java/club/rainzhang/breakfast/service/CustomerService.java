package club.rainzhang.breakfast.service;


import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.entity.User;
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
    List<Shops> getShopList();

    /**
     * 查看个人信息
     * @param userId 用户Id
     * @return 返回该用户信息
     */
    Object getPersonalInfo(Integer userId);

    /**
     * 修改个人信息
     * @param personalInfo 个人信息
     * @return 状态码
     */
    int updatePersonalInfo(JSONObject personalInfo);

    /**
     *创建订单
     * @param orderInfo 订单信息
     * @return 状态码
     */
    int generateOrder(JSONObject orderInfo);

    /**
     * 确认收货
     *
     * @return 状态码
     */
    int getFood();

    /**
     * 查看店铺内商品
     * @param shopId 商店 Id
     * @return list
     */
    List<Foods> getFoodList(Integer shopId);

    /**
     * 查看订单详情
     * TODO
     */


}
