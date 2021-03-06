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
@DynamicInsert
@DynamicUpdate
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String  password;
    private Integer type;
    private String sex;
    private String profile;
    private Integer phoneNumber;
}
