package lab.zlren.house.common.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 房产用户表
 *
 * @author zlren123
 * @since 2018-01-14
 */
@TableName("house_user")
@Data
public class HouseUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 房屋id
     */
    @TableField("house_id")
    private Long houseId;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 1售卖，2收藏
     */
    private Integer type;
}
