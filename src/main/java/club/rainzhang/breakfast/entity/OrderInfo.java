package club.rainzhang.breakfast.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author zyyy
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;
    private Integer foodId;
    private String foodName;
    private String foodImage;
    private BigDecimal foodPrice;
    private Integer account;
}
