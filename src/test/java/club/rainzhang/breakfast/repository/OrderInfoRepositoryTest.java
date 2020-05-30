package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderInfoRepositoryTest {
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Test
    void test() {
        List<OrderInfo> orderInfoList = orderInfoRepository.findAll();
        for (OrderInfo orderInfo : orderInfoList) {
            System.out.println(orderInfo);
        }
    }
}