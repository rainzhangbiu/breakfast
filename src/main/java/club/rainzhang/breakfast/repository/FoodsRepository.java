package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟食品表（foods）有关的数据库操作
 */
public interface FoodsRepository extends JpaRepository<Food,Integer> {

    /**
     * 根据食品的 foodId 查找食品信息
     * @param foodId 食品的 foodID
     * @return 商品对象
     */
    Food findAllByFoodId(Integer foodId);

    /**
     * 根据店铺的 shopId 查找该店铺的所有商品
     * @param shopId 店铺的 shopId
     * @return 食品集合
     */
    List<Food> findAllByShopId(Integer shopId);

    /**
     * 查找店铺中与输入食品名想匹配的食品
     * @param shopId 指定店铺的 shopId
     * @param s 输入的食品名
     * @return 食品集合
     */
    List<Food> findAllByShopIdAndFoodNameLike(Integer shopId, String s);
}
