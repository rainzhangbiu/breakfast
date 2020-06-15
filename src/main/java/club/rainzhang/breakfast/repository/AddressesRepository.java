package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author team
 * 跟地址表（addresses）有关的数据库操作
 */
public interface AddressesRepository extends JpaRepository<Address,Integer> {
    /**
     * 跟觉用户账号进行查找
     * @param userId 用户账号
     * @return 地址集合
     */
    List<Address> findAllByUserId(Integer userId);
}
