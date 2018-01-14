package lab.zlren.house.config.autoconfig;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientAutoConfigurationTest {

    @Autowired
    private HttpClient httpClient;

    @Test
    public void httpClient() throws IOException {
        System.out.println(httpClient.execute(new HttpGet("http://www.baidu.com")).getEntity().toString());
    }
}