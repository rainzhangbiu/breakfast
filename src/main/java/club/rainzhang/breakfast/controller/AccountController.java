package club.rainzhang.breakfast.controller;

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

    @PostMapping("/login/{userId}/{password}")
    public int login(@PathVariable("userId") Integer userId,@PathVariable("password") String password) {
        return accountService.login(userId,password);
    }
}
