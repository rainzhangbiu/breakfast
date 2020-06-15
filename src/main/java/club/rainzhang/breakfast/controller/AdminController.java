package club.rainzhang.breakfast.controller;

import club.rainzhang.breakfast.entity.Order;
import club.rainzhang.breakfast.entity.Shop;
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

    /**
     * 查看所有的店铺
     * @return 返回店铺集合
     */
    @GetMapping("/findAllShop")
    public List<Shop> findAll() {
        return adminService.findAll();
    }

    /**
     * 改变店铺的状态
     * @param shop json 数据映射为 Shop 对象，这里只需要 shop 的 shopId 属性
     * @return 返回该次操作的结果
     */
    @PostMapping("/changeShopStatus")
    public int changeShopStatus(@RequestBody Shop shop) {
        return adminService.changeShopStatus(shop.getShopId());
    }

    /**
     * 根据店铺名进行查找
     * @param shop json 数据映射为 Shop 对象，这里只需要 shop 的 name 属性
     * @return 返回指定 name 的店铺
     */
    @PostMapping("/findAllByShopName")
    public List<Shop> findAllByShopName(@RequestBody Shop shop) {
        return adminService.findAllByShopName(shop.getShopName());
    }

    /**
     * 查看所有订单
     * @return 订单集合
     */
    @GetMapping("/findAllOrders")
    public List<Order> findAllOrders() {
        return adminService.findAllOrders();
    }
}
