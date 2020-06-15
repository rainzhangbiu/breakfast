package club.rainzhang.breakfast.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zyyy
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Order {
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

    public void setCreateTime(Date createTime) throws ParseException {
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = dFormat.format(createTime);
        this.createTime = dFormat.parse(formatDate);
    }

    public String getCreateTime() {
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = dFormat.format(createTime);
        return formatDate;
    }
}
