package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.User;
import club.rainzhang.breakfast.form.UserNameAndPassword;
import club.rainzhang.breakfast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zyyy
 */

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 登陆功能
     * @param userNameAndPassword 将用户名账号密码映射为表单类，在这里直接映射为 User 类对象也可以
     * @return 返回登陆的结果
     * @throws Exception 账号不存在
     */
    @PostMapping("/login")
    public int login(@RequestBody UserNameAndPassword userNameAndPassword) throws Exception {
        return accountService.login(userNameAndPassword);
    }

    /**
     *
     * @param user 将前端传来的 json 数据映射为 User 实体类
     * @return 返回注册结果
     * @throws Exception 注册账号已经存在
     */
    @PostMapping("/register")
    public int register(@RequestBody User user) throws Exception{
        return accountService.register(user);
    }
}
