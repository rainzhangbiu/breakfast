package club.rainzhang.breakfast.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zyyy
 */

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;
    private Integer userId;
    private String shopName;
    private String shopAddress;
    private Integer shopStatus;
    private String shopDesc;
}
