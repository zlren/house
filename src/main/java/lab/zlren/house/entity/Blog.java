package lab.zlren.house.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客（百科）表
 *
 * @author zlren
 * @since 2018-01-14
 */
@Data
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标签
     */
    private String tags;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 标题
     */
    private String title;
    /**
     * 分类
     */
    private Integer cat;
}
