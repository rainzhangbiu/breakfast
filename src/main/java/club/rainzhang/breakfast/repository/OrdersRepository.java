package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟订单表（orders）有关的数据库操作
 */
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByUserId(Integer userId);
}
