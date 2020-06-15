package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.Shop;

import java.util.List;

/**
 * @author zyyy
 */
public interface AdminService {
    /**
     * 查询所有的店家
     * @return 店家信息集合
     */
    List<Shop> findAll();

    /**
     * 修改店家状态
     * @param shopId 店铺 Id
     * @return 成功返回 1，失败返回 0
     */
    int changeShopStatus(Integer shopId);

    /**
     * 根据店铺名来进行查找
     * @param shopName 店铺名
     * @return 符合要求的店铺集合
     */
    List<Shop> findAllByShopName(String shopName);

    /**
     * 查看所有的订单
     * @return 订单集合
     */
    List<Order> findAllOrders();
}
