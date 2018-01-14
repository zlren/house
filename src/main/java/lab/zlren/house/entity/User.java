package lab.zlren.house.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author zlren123
 * @since 2018-01-14
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 自我介绍
     */
    @TableField("about_me")
    private String aboutMe;
    /**
     * 密码，md5加密
     */
    private String passwd;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 1普通用户，2经纪人
     */
    private Integer type;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 1启动，2停用
     */
    private Integer enable;
    /**
     * 经纪人所属经纪机构id
     */
    @TableField("agency_id")
    private Integer agencyId;
}
