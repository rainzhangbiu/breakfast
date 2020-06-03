package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.form.UserNameAndPassword;
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
            userRepository.save(user);
            return 0;
        }

    }
}
