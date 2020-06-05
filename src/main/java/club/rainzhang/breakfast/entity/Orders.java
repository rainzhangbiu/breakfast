package club.rainzhang.breakfast.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zyyy
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer userId;
    private Integer shopId;
    private Integer deliverymanId;
    private String deliverymanName;
    private String shopName;
    private Date createTime;
    private String comment;
    private Integer status;
    private String address;
    private BigDecimal price;
}
