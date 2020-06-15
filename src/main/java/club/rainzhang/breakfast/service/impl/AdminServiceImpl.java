package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.Shop;
import club.rainzhang.breakfast.repository.OrdersRepository;
import club.rainzhang.breakfast.repository.ShopsRepository;
import club.rainzhang.breakfast.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyyy
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ShopsRepository shopsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Shop> findAll() {
        return shopsRepository.findAll();
    }

    @Override
    public int changeShopStatus(Integer shopId) {
        Shop shop = shopsRepository.findById(shopId).get();
        if (shop.getShopStatus() == 3) {
            shop.setShopStatus(2);
        } else {
            shop.setShopStatus(3);
        }
        shopsRepository.saveAndFlush(shop);
        return 1;
    }

    @Override
    public List<Shop> findAllByShopName(String shopName) {
        return shopsRepository.findAllByShopName(shopName);
    }

    @Override
    public List<Order> findAllOrders() {
        return ordersRepository.findAll();
    }
}
