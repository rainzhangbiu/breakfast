package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.*;
import club.rainzhang.breakfast.repository.*;
import club.rainzhang.breakfast.service.CustomerService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wrj
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ShopsRepository shopsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodsRepository foodsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private AddressesRepository addressesRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;


    @Override
    public List<Shop> getShopList() {
        return shopsRepository.getByShopStatus(1);
    }

    @Override
    public  List<Shop> getCertainShopList(String name){
        return shopsRepository.findAllByShopNameLike("%"+name+"%");
    }


    @Override
    public User getPersonalInfo(Integer userId) {
        return userRepository.findById(userId).get();
    }


    @Override
    public int updatePersonalInfo(User user) {
        try{
            User user1 = userRepository.findById(user.getUserId()).get();
            if(user1==user){
                //信息未更改
                return 1;
            }
            else {
                userRepository.saveAndFlush(user);
                //修改成功
                return 0;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //出错
            return -1;
        }
    }

    @Override
    public List<Order> getAllOrders(Integer userId) {
        return ordersRepository.findAllByUserId(userId);
    }


    @Override
    public List<OrderInfo> getOrderDetail(Integer orderId) {
        return orderInfoRepository.findAllByOrderId(orderId);
    }


    @Override
    public Order generateOrder(JSONObject orderInfo) {
        try{
            Order order = new Order();
            order.setStatus(1);
            order.setAddress(orderInfo.get("address").toString());
            order.setShopId(Integer.valueOf(orderInfo.get("shopId").toString()));
            order.setComment(orderInfo.get("comment").toString());
            order.setPrice(BigDecimal.valueOf(Double.parseDouble(orderInfo.get("price").toString())));
            order.setCreateTime(new Date());
            order.setUserId(Integer.valueOf(orderInfo.get("userId").toString()));
            order.setShopName(orderInfo.get("shopName").toString());
            ordersRepository.saveAndFlush(order);


            JSONArray foodArray = orderInfo.getJSONArray("foods");
            for(int i = 0; i<foodArray.size(); i++)
            {
                JSONObject foodItem = foodArray.getJSONObject(i);
                Food food = foodsRepository.findById(Integer.valueOf(foodItem.get("foodId").toString())).get();
                OrderInfo orderInfoItem = new OrderInfo();

                orderInfoItem.setOrderId(order.getOrderId());
                orderInfoItem.setAccount(Integer.valueOf(foodItem.get("account").toString()));
                orderInfoItem.setFoodPrice(food.getFoodPrice());
                orderInfoItem.setFoodId(food.getFoodId());
                orderInfoItem.setFoodName(food.getFoodName());
                orderInfoItem.setFoodImage(food.getFoodImage());
                orderInfoRepository.saveAndFlush(orderInfoItem);
            }

            return order;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }


    }


    @Override
    public int ensureOrder(Integer orderId) {
        try{
            Order order = ordersRepository.findById(orderId).get();
            order.setStatus(6);
            ordersRepository.saveAndFlush(order);
            return 0;
        }
        catch (Exception e)
        {
            //未查询到该订单&连接数据库失败
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Address> getAddresses(Integer userId) {
        try{
            return addressesRepository.findAllByUserId(userId);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int addAddress(Integer userId, String address) {
        try{
            Address addresses = new Address();
            addresses.setAddress(address);
            addresses.setUserId(userId);
            addressesRepository.saveAndFlush(addresses);
            return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateAddress(Address address)
    {
        try{
            addressesRepository.findById(address.getAddressId()).get();
            addressesRepository.saveAndFlush(address);
            return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    @Override
    public int deleteAddress(Integer addressId) {
        try{
            addressesRepository.deleteById(addressId);
            return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Food> getFoodList(Integer shopId) {
        try{
            return foodsRepository.findAllByShopId(shopId);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Food> getCertainFoodList(Integer shopId, String foodName) {
        try{
            return foodsRepository.findAllByShopIdAndFoodNameLike(shopId,"%"+foodName+"%");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
