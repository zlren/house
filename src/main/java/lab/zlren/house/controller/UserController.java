package lab.zlren.house.controller;

import lab.zlren.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String getUser(Model model) {
        model.addAttribute("user", userService.selectById(1));
        return "hello";
    }
}
