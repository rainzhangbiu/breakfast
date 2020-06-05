package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.Shops;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ShopService {

    int getMaxFoodId();
    //修改商品名字
    int updateFoodName(String newName,Integer foodId);
    //修改店铺状态
    int updateShopStatus(Integer shopId,Integer status);
    //修改店铺名字
    int updateShopName(Integer shopId,String newName);
    //修改店铺简介
    int updateShopDescription(Integer shopId,String newDes);
    //修改商品价格
    int updateFoodPrice(Integer foodId, BigDecimal newPrice);
    //修改商品图片
    int updateFoodImage(Integer foodId,String newImage);
    //修改商品名描述
    int updateFoodDescription(Integer foodId,String newDes);
    //上架商品
    int addFood(Foods foods);
    //下架商品
    int deleteFood(Integer foodId);
    //查看所有商品信息
    List<Foods> findAllFoods(Integer shopId);
    //查看某一商品信息
    Foods findFood(Integer foodId);
    //获取店铺信息
    Shops findShop(Integer userId);
    //获取自己店铺订单
    List<Orders> findAllOrders(Integer shopId);
    //修改订单状态
    int updateOrderStatus(Integer orderId);
    //修改商品信息
    int updateFoodInfo(Foods foods);
    //修改店铺信息
    int updateShopInfo(Shops shops);
    //修改订单信息
    int updateOrderInfo(Orders orders);

}
