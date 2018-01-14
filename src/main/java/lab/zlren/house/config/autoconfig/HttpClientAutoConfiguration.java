package lab.zlren.house.config.autoconfig;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Configuration
@ConditionalOnClass({HttpClient.class})
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {

    private final HttpClientProperties properties;

    public HttpClientAutoConfiguration(HttpClientProperties properties) {
        this.properties = properties;
    }

    /**
     * httpclient bean 定义
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(HttpClient.class)
    public HttpClient httpClient() {
        //构建requestConfig
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间，默认1秒
                .setConnectTimeout(properties.getConnectTimeOut())
                // 设置读超时时间，默认10秒
                .setSocketTimeout(properties.getSocketTimeOut()).build();
        HttpClient client = HttpClientBuilder.create()
                // 设置requestConfig
                .setDefaultRequestConfig(requestConfig)
                // 设置User-Agent
                .setUserAgent(properties.getAgent())
                // 设置一个远端IP最大的连接数
                .setMaxConnPerRoute(properties.getMaxConnPerRoute())
                // 设置总的连接数
                .setMaxConnTotal(properties.getMaxConnTotal())
                // .setConnectionReuseStrategy(new NoConnectionReuseStrategy())//不重用连接，默认是重用，建议保持默认开启连接池，节省建立连接开销
                .build();
        return client;
    }
}
