package lab.zlren.house.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 经纪机构表
 *
 * @author zlren
 * @since 2018-01-14
 */
@Data
public class Agency implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 经纪机构名称
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 描述
     */
    @TableField("about_us")
    private String aboutUs;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 网站
     */
    @TableField("web_site")
    private String webSite;
}
