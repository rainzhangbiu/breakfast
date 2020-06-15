package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Food;
import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.Shop;
import club.rainzhang.breakfast.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 吴勇
 */

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    /**
     * 找到食品 id 的最大值
     * @return 食品 id 的最大值
     */
    @PostMapping("/get")
    public int getMax(){
        return shopService.getMaxFoodId();
    }

    /**
     * 修改商品信息
     * @param food 商品信息
     * @return 操作结果
     */
    @PostMapping("/updateFoodInfo")
    public int updateFoodInfo(@RequestBody Food food){return shopService.updateFoodInfo(food);}

    /**
     * 上架商品
     * @param food 商品信息
     * @return 操作结果
     */
    @PostMapping("/addFood")
    public int addFood(@RequestBody Food food){
        return shopService.addFood(food);
    }

    /**
     * 下架商品
     * @param foodId 商品的 foodId
     * @return 操作结果
     */
    @PostMapping("/deleteFood/{foodId}")
    public int deleteFood(@PathVariable("foodId") Integer foodId){
        return shopService.deleteFood(foodId);
    }

    /**
     * 查看所有商品信息
     * @param shopId 店铺的 shopId
     * @return 商品信息集合
     */
    @PostMapping("/findAllFoods/{shopId}")
    public List<Food> findAllFoods(@PathVariable("shopId") Integer shopId){
        return shopService.findAllFoods(shopId);
    }

    /**
     * 查看某一商品信息
     * @param foodId 指定商品的 foodId
     * @return Food 对象
     */
    @PostMapping("/findFood/{foodId}")
    public Food findFood(@PathVariable("foodId") Integer foodId){
        return shopService.findFood(foodId);
    }

    /**
     * 修改店铺信息
     * @param shop 店铺信息
     * @return 操作结果
     */
    @PostMapping("/updateShopInfo")
    public int updateShopInfo(@RequestBody Shop shop){return shopService.updateShopInfo(shop);}

    /**
     * 获取店铺信息
     * @param userId 商家的 userId
     * @return Shop 对象
     */
    @PostMapping("/findShop/{userId}")
    public Shop findShop(@PathVariable("userId") Integer userId){
        return shopService.findShop(userId);
    }

    /**
     * 获取自己店铺订单
     * @param shopId 店铺的 shopId
     * @return 订单信息集合
     */
    @PostMapping("/findAllOrders/{shopId}")
    public List<Order> findAllOrders(@PathVariable("shopId") Integer shopId){
        return shopService.findAllOrders(shopId);
    }

    /**
     * 修改订单状态
     * @param orderId 订单的 orderId
     * @param newStatus 改变之后的状态
     * @return 操作结果
     */
    @PostMapping("/updateOrderStatus/{orderId}/{newStatus}")
    public int updateOrderStatus(@PathVariable("orderId") Integer orderId,@PathVariable Integer newStatus){
        return shopService.updateOrderStatus(orderId,newStatus);
    }

    /**
     * 修改订单信息
     * @param order 订单信息
     * @return 操作结果
     */
    @PostMapping("/updateOrderInfo")
    public int updateOrderInfo(@RequestBody Order order){return shopService.updateOrderInfo(order);}

    //    //修改商品名字
//    @PostMapping("/updateFoodName/{newName}/{foodId}")
//    public int updateFoodName(@PathVariable("newName") String newName,@PathVariable("foodId") Integer foodId){
//        return shopService.updateFoodName(newName,foodId);
//    }
//
//    //修改商品价格
//    @PostMapping("/updateFoodPrice/{foodId}/{newPrice}")
//    public int updateFoodPrice(@PathVariable("foodId") Integer foodId,@PathVariable("newPrice") BigDecimal newPrice){
//        return shopService.updateFoodPrice(foodId,newPrice);
//    }
//
//    //修改商品图片
//    @PostMapping("/updateFoodImage/{foodId}/{newImage}")
//    public int updateFoodImage(@PathVariable("foodId") Integer foodId,@PathVariable("newImage") String newImage){
//        return shopService.updateFoodImage(foodId,newImage);
//    }
//
//    //修改商品名描述
//    @PostMapping("/updateFoodDesc/{foodId}/{newDesc}")
//    public int updateFoodDesc(@PathVariable("foodId") Integer foodId,@PathVariable("newDesc") String newDes){
//        return shopService.updateFoodDescription(foodId, newDes);
//    }

//    //修改店铺状态
//    @PostMapping("/updateShopStatus/{shopId}/{newStatus}")
//    public int updateShopStatus(@PathVariable("shopId") Integer shopId,@PathVariable("newStatus") Integer newStatus){
//        return shopService.updateShopStatus(shopId, newStatus);
//    }
//
//    //修改店铺名字
//    @PostMapping("/updateShopName/{shopId}/{newName}")
//    public int updateShopName(@PathVariable("shopId") Integer shopId,@PathVariable("newName") String newName){
//        return shopService.updateShopName(shopId, newName);
//    }
//
//    //修改店铺简介
//    @PostMapping("/updateShopDesc/{shopId}/{newDesc}")
//    public int updateShopDesc(@PathVariable("shopId") Integer shopId,@PathVariable("newDesc") String newDesc){
//        return shopService.updateShopDescription(shopId,newDesc);
//    }


}
