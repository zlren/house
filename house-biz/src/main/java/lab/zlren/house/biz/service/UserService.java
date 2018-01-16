package lab.zlren.house.biz.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import lab.zlren.house.biz.mapper.UserMapper;
import lab.zlren.house.common.entity.User;
import lab.zlren.house.common.utils.BeanHelper;
import lab.zlren.house.common.utils.HashUtil;
import lab.zlren.house.common.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private FileService fileService;

    @Autowired
    private MailService mailService;

    @Value("${file.prefix}")
    private String imgPrefix;

    /**
     * 1.插入数据库，非激活;密码加盐md5;保存头像文件到本地
     * 2.生成key，绑定email
     * 3.发送邮件给用户
     *
     * @param account
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addAccount(UserVO account) {
        User user = new User();
        BeanUtils.copyProperties(account, user);
        user.setPasswd(HashUtil.encryPassword(user.getPasswd()));

        List<String> imgList = fileService.getImgPaths(Lists.newArrayList(account.getAvatarFile()));
        if (!imgList.isEmpty()) {
            user.setAvatar(imgList.get(0));
        }
        // 填充默认属性，因为mysql不允许null
        BeanHelper.setDefaultProp(user, User.class);
        // 更新时间戳
        BeanHelper.onInsert(user);
        // 默认不激活
        account.setEnable(1);

        insert(user);

        // mailService.registerNotify(account.getEmail());

        return true;
    }


    public boolean enable(String key) {
        return mailService.enable(key);
    }

    /**
     * 验证用户名密码
     *
     * @param username
     * @param password
     * @return
     */
    public User auth(String username, String password) {

        User user = selectOne(new EntityWrapper<>(
                new User()
                        .setEmail(username)
                        .setEnable(1)
        ));

        if (user.getPasswd().equals(HashUtil.encryPassword(password))) {
            user.setAvatar(imgPrefix + user.getAvatar());
            return user;
        }

        return null;
    }
}
