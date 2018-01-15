package lab.zlren.house.common.vo;

import lab.zlren.house.common.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zlren
 * @date 2018-01-15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVO extends User {

    private String confirmPasswd;
    private MultipartFile avatarFile;
}
