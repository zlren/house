package lab.zlren.house.web.controller;

import lab.zlren.house.biz.service.UserService;
import lab.zlren.house.common.constant.CommonConstants;
import lab.zlren.house.common.entity.User;
import lab.zlren.house.common.result.ResultMsg;
import lab.zlren.house.common.utils.UserUtil;
import lab.zlren.house.common.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zlren
 * @date 2018-01-14
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 注册验证、发送邮件、验证失败重定向到注册页面
     * 注册页获取：根据account对象为依据判断是否注册页获取请求
     *
     * @param account  account
     * @param modelMap modelMap
     * @return
     */
    @RequestMapping("accounts/register")
    public String accountRegister(UserVO account, ModelMap modelMap) {

        if (account == null || StringUtils.isEmpty(account.getName())) {
            // modelMap.put("agencyList", agencyService.getAllAgency());
            return "/user/accounts/register";
        }
        // 格式验证
        ResultMsg resultMsg = UserUtil.validate(account);
        if (resultMsg.isSuccess() && userService.addAccount(account)) {
            modelMap.put("email", account.getEmail());
            return "/user/accounts/registerSubmit";
        } else {
            return "redirect:/accounts/register?" + resultMsg.asUrlParams();
        }
    }

    @RequestMapping("accounts/verify")
    public String verify(String key) {
        boolean result = userService.enable(key);
        if (result) {
            return "redirect:/index?" + ResultMsg.successMsg("激活成功").asUrlParams();
        } else {
            return "redirect:/accounts/register?" + ResultMsg.errorMsg("激活失败,请确认链接是否过期");
        }
    }

    /**
     * 登录接口
     */
    @RequestMapping("/accounts/signin")
    public String signin(HttpServletRequest req) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String target = req.getParameter("target");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            req.setAttribute("target", target);
            return "/user/accounts/signin";
        }

        User user = userService.auth(username, password);

        if (user == null) {
            return "redirect:/accounts/signin?" + "target=" + target + "&username=" + username + "&"
                    + ResultMsg.errorMsg("用户名或密码错误").asUrlParams();
        } else {
            HttpSession session = req.getSession(true);
            session.setAttribute(CommonConstants.USER_ATTRIBUTE, user);
            session.setAttribute(CommonConstants.PLAIN_USER_ATTRIBUTE, user);
            return StringUtils.isNoneBlank(target) ? "redirect:" + target : "redirect:/index";
        }
    }

    /**
     * 登出操作
     *
     * @param request
     * @return
     */
    @RequestMapping("accounts/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "redirect:/index";
    }
}
