package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟订单信息表（order_info）有关的数据库操作
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfo,Integer> {
    /**
     * 根据订单的 orderId 来查找该订单的详细信息
     * @param orderId 订单的 orderId
     * @return 订单信息集合
     */
    List<OrderInfo> findAllByOrderId(Integer orderId);
}
