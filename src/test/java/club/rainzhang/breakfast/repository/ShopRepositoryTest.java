package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShopRepositoryTest {
    @Autowired
    private ShopsRepository shopsRepository;

    @Test
    void test() {
        List<Shop> shops = shopsRepository.findAll();
        for (Shop shop : shops) {
            System.out.println(shop);
        }
    }

}