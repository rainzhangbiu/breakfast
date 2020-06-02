package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.repository.ShopsRepository;
import club.rainzhang.breakfast.repository.UserRepository;
import club.rainzhang.breakfast.service.CustomerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wrj
 */
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ShopsRepository shopsRepository;
    private UserRepository userRepository;


    @Override
    public List<Shops> getShopList() {
        return shopsRepository.findAll();
    }

    @Override
    public Object getPersonalInfo(Integer userId) {
        return userRepository.findById(userId);
    }




    @Override
    public int updatePersonalInfo(JSONObject personalInfo) {
        return 0;
    }

    @Override
    public int generateOrder(JSONObject OrderInfo) {
        return 0;
    }

    @Override
    public int getFood() {
        return 0;
    }

    @Override
    public List<Foods> getFoodList(Integer shopId) {
        return null;
    }

}
