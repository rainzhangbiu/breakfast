package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Shops;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopsRepositoryTest {
    @Autowired
    private ShopsRepository shopsRepository;

    @Test
    void test() {
        List<Shops> shops = shopsRepository.findAll();
        for (Shops shop : shops) {
            System.out.println(shop);
        }
    }

}