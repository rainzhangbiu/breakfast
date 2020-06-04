package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.*;
import club.rainzhang.breakfast.repository.*;
import club.rainzhang.breakfast.service.CustomerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public List<Shops> getShopList() {
        return shopsRepository.getByShopStatus(1);
    }

    //搜索特定店铺
    @Override
    public  List<Shops> getCertainShopList(String name){
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
                return 1;    //信息未更改
            }
            else {
                userRepository.saveAndFlush(user);
                return 0;    //修改成功
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;         //出错
        }
    }

    @Override
    public List<Orders> getAllOrders(Integer userId) {
        List<Orders> ordersList = ordersRepository.findAllByUserId(userId);
        return ordersList;
    }

    @Override
    public int generateOrder(JSONObject orderInfo) {
        return 0;
    }





    @Override
    public int ensureOrder(Integer orderId) {
        try{
            Orders order = ordersRepository.findById(orderId).get();
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

    //获取地址
    @Override
    public List<Addresses> getAddresses(Integer userId) {
        try{
            return addressesRepository.findAllByUserId(userId);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //添加地址
    @Override
    public int addAddress(Integer userId, String address) {
        try{
            Addresses addresses = new Addresses();
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

    //修改地址
    @Override
    public int updateAddress(Addresses address)
    {
        try{
            Addresses addresses = addressesRepository.findById(address.getAddressId()).get();
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
    public List<Foods> getFoodList(Integer shopId) {
        try{
            return foodsRepository.findAllByShopId(shopId);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Foods> getCertainFoodList(Integer shopId, String foodName) {
        try{
            return foodsRepository.findAllByShopIdAndFoodNameLike(shopId,"%"+foodName+"%");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
