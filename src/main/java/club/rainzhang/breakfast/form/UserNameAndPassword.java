package club.rainzhang.breakfast.form;

import lombok.Data;

/**
 * @author zyyy
 * 接受前端登陆是传递过来的 json 数据
 */
@Data
public class UserNameAndPassword {
    private String userName;
    private String password;
}
