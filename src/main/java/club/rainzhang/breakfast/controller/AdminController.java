package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zyyy
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/findAllShop")
    public List<Shops> findAll() {
        return adminService.findAll();
    }

    @PostMapping("/changeShopStatus")
    public int changeShopStatus(@RequestBody Shops shop) {
        return adminService.changeShopStatus(shop.getShopId());
    }

    @PostMapping("/findAllByShopName")
    public List<Shops> findAllByShopName(@RequestBody Shops shop) {
        return adminService.findAllByShopName(shop.getShopName());
    }
}
