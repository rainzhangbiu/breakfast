package club.rainzhang.breakfast.repository;

import club.rainzhang.breakfast.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author team
 * 跟账号表（user）有关的数据库操作
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据用户账号查找用户信息
     * @param userId 用户账号
     * @return 用户信息
     */
    User findAllByUserId(Integer userId);
}
