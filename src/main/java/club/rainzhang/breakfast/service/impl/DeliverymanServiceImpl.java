package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.repository.OrdersRepository;
import club.rainzhang.breakfast.repository.UserRepository;
import club.rainzhang.breakfast.service.DeliverymanService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyyy
 */
@Service
public class DeliverymanServiceImpl implements DeliverymanService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Orders> findOrderNeededDelivered() {
        return ordersRepository.findByStatus(3);
    }

    @Override
    public int changeOrder(Integer orderId, User user) {
        Orders order = ordersRepository.findById(orderId).get();
        if (order.getStatus() == 3) {
            order.setStatus(4);
            Integer id = user.getUserId();
            order.setDeliverymanId(id);
            User deliveryman = userRepository.findById(id).get();
            order.setDeliverymanName(deliveryman.getUserName());
            ordersRepository.save(order);
            return 1;
        } else if (order.getStatus() == 4) {
            order.setStatus(5);
            ordersRepository.save(order);
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public List<Orders> findMyOrders(Integer deliverymanId) {
        return ordersRepository.findByDeliverymanId(deliverymanId);
    }


}
