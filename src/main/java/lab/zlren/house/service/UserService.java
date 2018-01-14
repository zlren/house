package lab.zlren.house.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lab.zlren.house.entity.User;
import lab.zlren.house.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
