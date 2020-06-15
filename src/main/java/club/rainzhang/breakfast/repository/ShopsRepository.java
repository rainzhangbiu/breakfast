package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟商店表表（shops）有关的数据库操作
 */
public interface ShopsRepository extends JpaRepository<Shop,Integer> {
    /**
     * 查找指定的店铺
     * @param shopId 店铺的 shopId
     * @return 指定的店铺
     */
    Shop findAllByShopId(Integer shopId);

    /**
     * 根据店铺名查找
     * @param shopName 店铺名
     * @return 店铺集合
     */
    List<Shop> findAllByShopName(String shopName);

    /**
     * 根据店铺状态进行查找
     * @param i 店铺状态
     * @return 店铺集合
     */
    List<Shop> getByShopStatus(int i);

    /**
     * 查找指定用户的店铺
     * @param userId 用户的 userId
     * @return 店铺集合
     */
    List<Shop> findAllByUserId(Integer userId);

    /**
     * 根据店铺名进行查找（模糊查找）
     * @param shopName 店铺名
     * @return 店铺集合
     */
    List<Shop> findAllByShopNameLike(String shopName);
}
