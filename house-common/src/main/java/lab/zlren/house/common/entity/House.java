package lab.zlren.house.common.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 房屋表
 *
 * @author zlren
 * @since 2018-01-14
 */
@Data
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 房产名称
     */
    private String name;
    /**
     * 1销售，2出租
     */
    private Integer type;
    /**
     * 单位元，价格
     */
    private Integer price;
    /**
     * 房屋图片
     */
    private String images;
    /**
     * 面积
     */
    private Integer area;
    /**
     * 卧室数量
     */
    private Integer beds;
    /**
     * 卫生间数量
     */
    private Integer baths;
    /**
     * 评分
     */
    private Double rating;
    /**
     * 房产描述
     */
    private String remarks;
    /**
     * 房产属性
     */
    private String properties;
    /**
     * 户型图
     */
    @TableField("flow_plan")
    private String flowPlan;
    /**
     * 标签
     */
    private String tags;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 城市id
     */
    @TableField("city_id")
    private Integer cityId;
    /**
     * 小区id
     */
    @TableField("community_id")
    private Integer communityId;
    /**
     * 房产地址
     */
    private String address;
    /**
     * 1上架，2下架
     */
    private Integer state;
}
