package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟商店表表（shops）有关的数据库操作
 */
public interface ShopsRepository extends JpaRepository<Shops,Integer> {
    /**
     * 根据店铺名进行查找
     * @param shopName 店铺名
     * @return 店铺列表
     */
    List<Shops> findAllByShopName(String shopName);
}
