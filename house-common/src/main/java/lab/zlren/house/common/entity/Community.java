package lab.zlren.house.common.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 小区表
 *
 * @author zlren
 * @since 2018-01-14
 */
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 城市编码
     */
    @TableField("city_code")
    private String cityCode;
    /**
     * 城市名称
     */
    @TableField("city_name")
    private String cityName;
    /**
     * 小区名称
     */
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Community{" +
        ", id=" + id +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", name=" + name +
        "}";
    }
}
