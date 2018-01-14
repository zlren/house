package lab.zlren.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "homepage/index";
    }
}
