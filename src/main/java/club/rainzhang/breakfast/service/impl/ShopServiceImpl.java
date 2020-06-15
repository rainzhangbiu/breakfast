package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Food;
import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.Shop;
import club.rainzhang.breakfast.repository.FoodsRepository;
import club.rainzhang.breakfast.repository.OrdersRepository;
import club.rainzhang.breakfast.repository.ShopsRepository;
import club.rainzhang.breakfast.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private FoodsRepository foodsRepository;
    @Autowired
    private ShopsRepository shopsRepository;
    @Autowired
    private OrdersRepository ordersRepository;


    @Override
    public int getMaxFoodId() {
        List<Food> foods=foodsRepository.findAll();
        int[]foodIds = new int[99];
        for(int i=0;i<foods.size();i++){
            Integer foodId=foods.get(i).getFoodId();
            foodIds[i]=foodId;
        }
        int maxFoodId=0;
        for (int foodId : foodIds) {
            if (foodId >= maxFoodId) {
                maxFoodId = foodId;
            }
        }
        return maxFoodId;
    }

//

    @Override
    public int addFood(Food food) {
        int id=getMaxFoodId();
        food.setFoodId(id+1);
        foodsRepository.save(food);
        return 0;
    }

    @Override
    public int deleteFood(Integer foodId) {
        Food food =foodsRepository.findAllByFoodId(foodId);
        foodsRepository.delete(food);
        return 0;
    }

    @Override
    public List<Food> findAllFoods(Integer shopId) {
        return foodsRepository.findAllByShopId(shopId);
    }

    @Override
    public Food findFood(Integer foodId) {
        return foodsRepository.findAllByFoodId(foodId);
    }

    @Override
    public Shop findShop(Integer userId) {
        List<Shop> shops=shopsRepository.findAllByUserId(userId);
        if(shops!=null){
            Integer shopId=shops.get(0).getShopId();
            return shopsRepository.findAllByShopId(shopId);
        }
        return null;
    }

    @Override
    public List<Order> findAllOrders(Integer shopId) {
        return ordersRepository.findAllByShopId(shopId);
    }

    @Override
    public int updateOrderStatus(Integer orderId,Integer newStatus) {
        Order order =ordersRepository.findAllByOrderId(orderId);
        int status= order.getStatus();
        if(newStatus>status){
            order.setStatus(newStatus);
            ordersRepository.saveAndFlush(order);
            return 0;
        }
        return 1;
    }

    @Override
    public int updateFoodInfo(Food food) {
        try{
            Food food1 = foodsRepository.findAllByFoodId(food.getFoodId());
            if(food1.equals(food)){
                //信息未更改
                return 1;
            }
            else {
                foodsRepository.saveAndFlush(food);
                //修改成功
                return 0;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //出错
            return -1;
        }
    }

    @Override
    public int updateShopInfo(Shop shop) {
        try{
            Shop shop1 = shopsRepository.findAllByShopId(shop.getShopId());
            if(shop1.equals(shop)){
                //信息未更改
                return 1;
            }
            else {
                shopsRepository.saveAndFlush(shop);
                //修改成功
                return 0;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //出错
            return -1;
        }
    }

    @Override
    public int updateOrderInfo(Order order) {
        try{
            Order order1 = ordersRepository.findAllByOrderId(order.getOrderId());
            if(order1 == order){
                //信息未更改
                return 1;
            }
            else {
                ordersRepository.saveAndFlush(order);
                //修改成功
                return 0;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //出错
            return -1;
        }
    }

//    @Override
//    public int updateFoodName(String newName, Integer foodId) {
//        Food food =foodsRepository.findAllByFoodId(foodId);
//        food.setFoodName(newName);
//        foodsRepository.saveAndFlush(food);
//        return 0;
//    }
//
//    @Override
//    public int updateShopStatus(Integer shopId, Integer status) {
//        Shop shop =shopsRepository.findAllByShopId(shopId);
//        shop.setShopStatus(status);
//        shopsRepository.saveAndFlush(shop);
//        return 0;
//    }
//
//    @Override
//    public int updateShopName(Integer shopId, String newName) {
//        Shop shop =shopsRepository.findAllByShopId(shopId);
//        shop.setShopName(newName);
//        shopsRepository.saveAndFlush(shop);
//        return 0;
//    }
//
//    @Override
//    public int updateShopDescription(Integer shopId, String newDes) {
//        Shop shop =shopsRepository.findAllByShopId(shopId);
//        shop.setShopDesc(newDes);
//        shopsRepository.saveAndFlush(shop);
//        return 0;
//    }
//
//    @Override
//    public int updateFoodPrice(Integer foodId, BigDecimal newPrice) {
//        Food food =foodsRepository.findAllByFoodId(foodId);
//        food.setFoodPrice(newPrice);
//        foodsRepository.saveAndFlush(food);
//        return 0;
//    }
//
//    @Override
//    public int updateFoodImage(Integer foodId, String newImage) {
//        Food food =foodsRepository.findAllByFoodId(foodId);
//        food.setFoodImage(newImage);
//        foodsRepository.saveAndFlush(food);
//        return 0;
//    }
//
//    @Override
//    public int updateFoodDescription(Integer foodId, String newDes) {
//        Food food =foodsRepository.findAllByFoodId(foodId);
//        food.setFoodDesc(newDes);
//        foodsRepository.saveAndFlush(food);
//        return 0;
//    }


}
