package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Shops;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟商店表表（shops）有关的数据库操作
 */
public interface ShopsRepository extends JpaRepository<Shops,Integer> {
    Shops findAllByShopId(Integer shopId);

    List<Shops> findAllByShopName(String shopName);

    List<Shops> getByShopStatus(int i);

    List<Shops> findAllByUserId(Integer userId);
}
