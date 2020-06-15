package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FoodRepositoryTest {
    @Autowired
    private FoodsRepository foodsRepository;

    @Test
    void test() {
        List<Food> foodList = foodsRepository.findAll();
        for (Food food : foodList) {
            System.out.println(food);
        }
    }
}