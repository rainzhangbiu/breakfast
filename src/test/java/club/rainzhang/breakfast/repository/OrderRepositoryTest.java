package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    void test() {
        List<Order> orderList = ordersRepository.findAll();
        for(Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    void test1() {
        Order order = new Order();
        order.setUserId(21);
        order.setShopId(11);
        order.setStatus(1);
        order.setAddress("七舍");
        ordersRepository.save(order);
    }
}