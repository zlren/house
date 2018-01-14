package lab.zlren.house.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表
 *
 * @author zlren
 * @since 2018-01-14
 */
@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 房屋id
     */
    @TableField("house_id")
    private Long houseId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 博客id
     */
    @TableField("blog_id")
    private Integer blogId;
    /**
     * 1房产，2博客
     */
    private Integer type;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
}
