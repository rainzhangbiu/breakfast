package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.User;
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
    public int login(Integer userId,String password) {
        User user = userRepository.findAllByUserId(userId);
        if (user == null) {
            return 2;
        } else if (user.getPassword().equals(password)) {
            return 1;
        } else {
            return 3;
        }
    }
}
