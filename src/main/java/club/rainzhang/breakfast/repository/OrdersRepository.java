package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟订单表（orders）有关的数据库操作
 */
public interface OrdersRepository extends JpaRepository<Order,Integer> {
    /**
     * 查找店铺的所有订单
     * @param shopId 店铺的 shopId
     * @return 订单集合
     */
    List<Order> findAllByShopId(Integer shopId);

    /**
     * 查找指定的订单
     * @param orderId 订单的 orderId
     * @return 订单信息
     */
    Order findAllByOrderId(Integer orderId);

    /**
     * 查找配送员的所有订单
     * @param userId 配送员的 userId
     * @return 订单集合
     */
    List<Order> findAllByUserId(Integer userId);

    /**
     * 查找指定状态的订单
     * @param i 订单的状态
     * @return 订单集合
     */
    List<Order> findByStatus(int i);

    /**
     * 查找指定配送员的所有订单
     * @param deliverymanId 配送员的 id
     * @return 订单集合
     */
    List<Order> findByDeliverymanId(Integer deliverymanId);
}
