package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author team
 * 跟地址表（addresses）有关的数据库操作
 */
public interface AddressesRepository extends JpaRepository<Addresses,Integer> {
}
