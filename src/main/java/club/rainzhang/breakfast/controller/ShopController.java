package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;


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
    @PostMapping("/get")
    public int getMax(){
        return shopService.getMaxFoodId();
    }

    //修改商品信息
    @PostMapping("/updateFoodInfo")
    public int updateFoodInfo(@RequestBody Foods foods){return shopService.updateFoodInfo(foods);}

    //上架商品
    @PostMapping("/addFood")
    public int addFood(@RequestBody Foods foods){
        return shopService.addFood(foods);
    }

    //下架商品
    @PostMapping("/deleteFood/{foodId}")
    public int deleteFood(@PathVariable("foodId") Integer foodId){
        return shopService.deleteFood(foodId);
    }

    //查看所有商品信息
    @PostMapping("/findAllFoods/{shopId}")
    public List<Foods> findAllFoods(@PathVariable("shopId") Integer shopId){
        return shopService.findAllFoods(shopId);
    }

    //查看某一商品信息
    @PostMapping("/findFood/{foodId}")
    public Foods findFood(@PathVariable("foodId") Integer foodId){
        return shopService.findFood(foodId);
    }

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

    //修改店铺信息
    @PostMapping("/updateShopInfo")
    public int updateShopInfo(@RequestBody Shops shops){return shopService.updateShopInfo(shops);}

    //获取店铺信息
    @PostMapping("/findShop/{userId}")
    public Shops findShop(@PathVariable("userId") Integer userId){
        return shopService.findShop(userId);
    }

    //获取自己店铺订单
    @PostMapping("/findAllOrders/{shopId}")
    public List<Orders> findAllOrders(@PathVariable("shopId") Integer shopId){
        return shopService.findAllOrders(shopId);
    }

    //修改订单状态
    @PostMapping("/updateOrderStatus/{orderId}/{newStatus}")
    public int updateOrderStatus(@PathVariable("orderId") Integer orderId,@PathVariable Integer newStatus){
        return shopService.updateOrderStatus(orderId,newStatus);
    }
    //修改订单信息
    @PostMapping("/updateOrderInfo")
    public int updateOrderInfo(@RequestBody Orders orders){return shopService.updateOrderInfo(orders);}
}
