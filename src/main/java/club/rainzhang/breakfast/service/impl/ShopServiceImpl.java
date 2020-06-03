package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.Shops;
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
    public Shops findShop(Integer shopId) {
        return shopsRepository.findAllByShopId(shopId);
    }

    @Override
    public List<Orders> findAllOrders(Integer shopId) {
        return ordersRepository.findAllByShopId(shopId);
    }

    @Override
    public int updateOrderStatus(Integer orderId,Integer newStatus) {
        Orders orders=ordersRepository.findAllByOrderId(orderId);
        orders.setStatus(newStatus);
        ordersRepository.saveAndFlush(orders);
        return 0;
    }
}
