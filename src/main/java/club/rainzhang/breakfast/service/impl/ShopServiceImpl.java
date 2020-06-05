package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.repository.FoodsRepository;
import club.rainzhang.breakfast.repository.OrdersRepository;
import club.rainzhang.breakfast.repository.ShopsRepository;
import club.rainzhang.breakfast.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        List<Foods> foods=foodsRepository.findAll();
        int[]foodIds = new int[99];
        for(int i=0;i<foods.size();i++){
            Integer foodId=foods.get(i).getFoodId();
            foodIds[i]=foodId;
        }
        int maxFoodId=0;
        for(int i=0;i<foodIds.length;i++){
            if(foodIds[i]>=maxFoodId){
                maxFoodId=foodIds[i];
            }
        }
        return maxFoodId;
    }

    @Override
    public int updateFoodName(String newName, Integer foodId) {
        Foods foods=foodsRepository.findAllByFoodId(foodId);
        foods.setFoodName(newName);
        foodsRepository.saveAndFlush(foods);
        return 0;
    }

    @Override
    public int updateShopStatus(Integer shopId, Integer status) {
        Shops shops=shopsRepository.findAllByShopId(shopId);
        shops.setShopStatus(status);
        shopsRepository.saveAndFlush(shops);
        return 0;
    }

    @Override
    public int updateShopName(Integer shopId, String newName) {
        Shops shops=shopsRepository.findAllByShopId(shopId);
        shops.setShopName(newName);
        shopsRepository.saveAndFlush(shops);
        return 0;
    }

    @Override
    public int updateShopDescription(Integer shopId, String newDes) {
        Shops shops=shopsRepository.findAllByShopId(shopId);
        shops.setShopDesc(newDes);
        shopsRepository.saveAndFlush(shops);
        return 0;
    }

    @Override
    public int updateFoodPrice(Integer foodId, BigDecimal newPrice) {
        Foods foods=foodsRepository.findAllByFoodId(foodId);
        foods.setFoodPrice(newPrice);
        foodsRepository.saveAndFlush(foods);
        return 0;
    }

    @Override
    public int updateFoodImage(Integer foodId, String newImage) {
        Foods foods=foodsRepository.findAllByFoodId(foodId);
        foods.setFoodImage(newImage);
        foodsRepository.saveAndFlush(foods);
        return 0;
    }

    @Override
    public int updateFoodDescription(Integer foodId, String newDes) {
        Foods foods=foodsRepository.findAllByFoodId(foodId);
        foods.setFoodDesc(newDes);
        foodsRepository.saveAndFlush(foods);
        return 0;
    }

    @Override
    public int addFood(Foods foods) {
        Integer id=getMaxFoodId();
        foods.setFoodId(id+1);
        foodsRepository.save(foods);
        return 0;
    }

    @Override
    public int deleteFood(Integer foodId) {
        Foods foods=foodsRepository.findAllByFoodId(foodId);
        foodsRepository.delete(foods);
        return 0;
    }

    @Override
    public List<Foods> findAllFoods(Integer shopId) {
        return foodsRepository.findAllByShopId(shopId);
    }

    @Override
    public Foods findFood(Integer foodId) {
        return foodsRepository.findAllByFoodId(foodId);
    }

    @Override
    public Shops findShop(Integer userId) {
        List<Shops> shops=shopsRepository.findAllByUserId(userId);
        if(shops!=null){
            Integer shopId=shops.get(0).getShopId();
            return shopsRepository.findAllByShopId(shopId);
        }
        return null;
    }

    @Override
    public List<Orders> findAllOrders(Integer shopId) {
        return ordersRepository.findAllByShopId(shopId);
    }

    @Override
    public int updateOrderStatus(Integer orderId,Integer newStatus) {
        Orders orders=ordersRepository.findAllByOrderId(orderId);
        int status=orders.getStatus();
        if(newStatus>status){
            orders.setStatus(newStatus);
            ordersRepository.saveAndFlush(orders);
            return 0;
        }
        return 1;
    }

    @Override
    public int updateFoodInfo(Foods foods) {
        try{
            Foods foods1 = foodsRepository.findAllByFoodId(foods.getFoodId());
            if(foods1.equals(foods)){
                return 1;    //信息未更改
            }
            else {
                foodsRepository.saveAndFlush(foods);
                return 0;    //修改成功
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;         //出错
        }
    }

    @Override
    public int updateShopInfo(Shops shops) {
        try{
            Shops shops1 = shopsRepository.findAllByShopId(shops.getShopId());
            if(shops1.equals(shops)){
                return 1;    //信息未更改
            }
            else {
                shopsRepository.saveAndFlush(shops);
                return 0;    //修改成功
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;         //出错
        }
    }

    @Override
    public int updateOrderInfo(Orders orders) {
        try{
            Orders orders1 = ordersRepository.findAllByOrderId(orders.getOrderId());
            if(orders1==orders){
                return 1;    //信息未更改
            }
            else {
                ordersRepository.saveAndFlush(orders);
                return 0;    //修改成功
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;         //出错
        }
    }
}
