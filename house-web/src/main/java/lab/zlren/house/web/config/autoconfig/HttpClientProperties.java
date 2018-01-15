package lab.zlren.house.web.config.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zlren
 * @date 2018-01-14
 */
@ConfigurationProperties(prefix = "spring.httpclient")
@Data
public class HttpClientProperties {

    private String agent = "agent";
    private Integer maxConnPerRoute = 10;
    private Integer maxConnTotal = 50;
    private Integer connectTimeOut = 1000;
    private Integer socketTimeOut = 100000;
}
