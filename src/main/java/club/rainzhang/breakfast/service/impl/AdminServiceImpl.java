package club.rainzhang.breakfast.service.impl;

import club.rainzhang.breakfast.entity.Shops;
import club.rainzhang.breakfast.repository.ShopsRepository;
import club.rainzhang.breakfast.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyyy
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ShopsRepository shopsRepository;

    @Override
    public List<Shops> findAll() {
        return shopsRepository.findAll();
    }

    @Override
    public int changeShopStatus(Integer shopId, Integer status) {
        Shops shop = shopsRepository.findById(shopId).get();
        shop.setShopStatus(status);
        shopsRepository.saveAndFlush(shop);
        return 0;
    }
}
