package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Foods;
import club.rainzhang.breakfast.entity.OrderInfo;
import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.entity.Orders;
import club.rainzhang.breakfast.entity.Addresses;
import club.rainzhang.breakfast.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  @author wrj
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getShopList")
    public List<Shops> getShops(){ return customerService.getShopList(); }


}
