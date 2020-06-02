package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.form.UserNameAndPassword;
import club.rainzhang.breakfast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zyyy
 */
public interface AccountService {
    /**
     * 登陆功能
     * @param userNameAndPassword 用户账号和密码
     * @return 返回一个登陆的结果，成功返回 1，账号不存在返回 2，密码不正确返回 3
     * @throws Exception 没有账号
     */
    int login(UserNameAndPassword userNameAndPassword) throws Exception;

    /**
     * 注册功能
     * @param user 注册的用户对象
     * @return 结果
     * @throws Exception 账号已存在
     */
    int register(User user) throws Exception;

}
