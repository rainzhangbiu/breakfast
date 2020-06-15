package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.Food;
import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.Shop;

import java.util.List;

public interface ShopService {
    /**
     * 找到食品 id 的最大值
     * @return 食品 id 的最大值
     */
    int getMaxFoodId();

    /**
     * 修改商品信息
     * @param food 商品信息
     * @return 操作结果
     */
    int updateFoodInfo(Food food);

    /**
     * 上架商品
     * @param food 商品信息
     * @return 操作结果
     */
    int addFood(Food food);

    /**
     * 下架商品
     * @param foodId 商品的 foodId
     * @return 操作结果
     */
    int deleteFood(Integer foodId);

    /**
     * 查看所有商品信息
     * @param shopId 店铺的 shopId
     * @return 商品信息集合
     */
    List<Food> findAllFoods(Integer shopId);

    /**
     * 查看某一商品信息
     * @param foodId 指定商品的 foodId
     * @return Food 对象
     */
    Food findFood(Integer foodId);

    /**
     * 修改店铺信息
     * @param shop 店铺信息
     * @return 操作结果
     */
    int updateShopInfo(Shop shop);

    /**
     * 获取店铺信息
     * @param userId 商家的 userId
     * @return Shop 对象
     */
    Shop findShop(Integer userId);

    /**
     * 获取自己店铺订单
     * @param shopId 店铺的 shopId
     * @return 订单信息集合
     */
    List<Order> findAllOrders(Integer shopId);

    /**
     * 修改订单状态
     * @param orderId 订单的 orderId
     * @param newStatus 改变之后的状态
     * @return 操作结果
     */
    int updateOrderStatus(Integer orderId,Integer newStatus);

    /**
     * 修改订单信息
     * @param order 订单信息
     * @return 操作结果
     */
    int updateOrderInfo(Order order);

//    修改商品名字
//    int updateFoodName(String newName,Integer foodId);
//    //修改店铺状态
//    int updateShopStatus(Integer shopId,Integer status);
//    //修改店铺名字
//    int updateShopName(Integer shopId,String newName);
//    //修改店铺简介
//    int updateShopDescription(Integer shopId,String newDes);
//    //修改商品价格
//    int updateFoodPrice(Integer foodId, BigDecimal newPrice);
//    //修改商品图片
//    int updateFoodImage(Integer foodId,String newImage);
//    //修改商品名描述
//    int updateFoodDescription(Integer foodId,String newDes);
}
