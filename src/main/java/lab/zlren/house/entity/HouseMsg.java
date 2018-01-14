package lab.zlren.house.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋信息表
 *
 * @author zlren
 * @since 2018-01-14
 */
@TableName("house_msg")
@Data
public class HouseMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 消息
     */
    private String msg;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 经纪人id
     */
    @TableField("agent_id")
    private Long agentId;
    /**
     * 房屋id
     */
    @TableField("house_id")
    private Long houseId;
    /**
     * 用户的名称
     */
    @TableField("user_name")
    private String userName;
}
