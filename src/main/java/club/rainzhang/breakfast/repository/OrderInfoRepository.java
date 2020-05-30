package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author team
 * 跟订单信息表（order_info）有关的数据库操作
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfo,Integer> {
}
