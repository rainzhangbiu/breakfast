package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.form.UserNameAndPassword;
import club.rainzhang.breakfast.repository.ShopsRepository;
import club.rainzhang.breakfast.repository.UserRepository;
import club.rainzhang.breakfast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyyy
 */

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopsRepository shopsRepository;

    @Override
    public int login(UserNameAndPassword userNameAndPassword) {
        try {
            User user = userRepository.findById(Integer.parseInt(userNameAndPassword.getUserName())).get();
            if (user.getPassword().equals(userNameAndPassword.getPassword())) {
                return user.getType();
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int register(User user) throws Exception {
        try {
            User user1 = userRepository.findById(user.getUserId()).get();
            return 1;
        } catch (Exception e) {
            if (user.getType() == 1) {
                Shops shops = new Shops();
                shops.setShopName(user.getUserName()+"的店");
                shops.setShopStatus(1);
                shops.setUserId(user.getUserId());
                shops.setShopAddress("");
                shopsRepository.saveAndFlush(shops);
            }
            userRepository.save(user);
            return 0;
        }

    }
}
