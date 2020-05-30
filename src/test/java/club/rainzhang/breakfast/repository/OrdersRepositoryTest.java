package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Orders;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdersRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    void test() {
        List<Orders> ordersList = ordersRepository.findAll();
        for(Orders order : ordersList) {
            System.out.println(order);
        }
    }

    @Test
    void test1() {
        Orders order = new Orders();
        order.setUserId(21);
        order.setShopId(11);
        order.setStatus(1);
        order.setAddress("七舍");
        ordersRepository.save(order);
    }
}