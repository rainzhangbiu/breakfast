package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zyyy
 */
public interface AccountService {
    /**
     * 登陆功能
     * @param userId 用户账号
     * @param password 用户密码
     * @return 返回一个登陆的结果，成功返回 1，账号不存在返回 2，密码不正确返回 3
     */
    int login(Integer userId,String password);
}
