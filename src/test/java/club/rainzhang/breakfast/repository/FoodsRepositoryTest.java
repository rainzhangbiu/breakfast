package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Foods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodsRepositoryTest {
    @Autowired
    private FoodsRepository foodsRepository;

    @Test
    void test() {
        List<Foods> foodsList = foodsRepository.findAll();
        for (Foods foods : foodsList) {
            System.out.println(foods);
        }
    }
}