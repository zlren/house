package lab.zlren.house.web.controller;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Controller
public class IndexController {

    @Autowired
    private HttpClient httpClient;

    @GetMapping("index")
    public String index() {
        return "homepage/index";
    }
}
