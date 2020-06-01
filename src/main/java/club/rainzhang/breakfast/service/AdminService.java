package club.rainzhang.breakfast.service;

import club.rainzhang.breakfast.entity.Shops;

import java.util.List;

/**
 * @author zyyy
 */
public interface AdminService {
    /**
     * 查询所有的店家
     * @return 店家信息集合
     */
    List<Shops> findAll();

    /**
     * 修改店家状态
     * @param shopId 店铺 Id
     * @param status 要修改的状态
     * @return 成功返回 1，失败返回 0
     */
    int changeShopStatus(Integer shopId,Integer status);
}
