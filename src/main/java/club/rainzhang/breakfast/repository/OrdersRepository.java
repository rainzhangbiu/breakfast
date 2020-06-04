package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟订单表（orders）有关的数据库操作
 */
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByShopId(Integer shopId);

    Orders findAllByOrderId(Integer orderId);

    List<Orders> findAllByUserId(Integer userId);

    /**
     * 根据订单状态查找订单
     * @param status 订单状态
     * @return 指定状态的订单集合
     */
    List<Orders> findByStatus(Integer status);

    /**
     * 查找该配送员的所有订单
     * @param deliverymanId 配送员 Id
     * @return 该配送员的所有订单集合
     */
    List<Orders> findByDeliverymanId(Integer deliverymanId);
}
