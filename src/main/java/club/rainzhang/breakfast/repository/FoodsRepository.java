package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author team
 * 跟食品表（foods）有关的数据库操作
 */
public interface FoodsRepository extends JpaRepository<Foods,Integer> {
}
