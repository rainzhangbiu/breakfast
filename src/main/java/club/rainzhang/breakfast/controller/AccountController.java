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

    @PostMapping("/login")
    public int login(@RequestBody UserNameAndPassword userNameAndPassword) throws Exception {
        return accountService.login(userNameAndPassword);
    }

    @PostMapping("/register")
    public int register(@RequestBody User user) throws Exception{
        return accountService.register(user);
    }
}
