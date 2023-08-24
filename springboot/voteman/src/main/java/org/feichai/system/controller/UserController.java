package org.feichai.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.controller.BaseController;
import org.feichai.common.domain.QueryRequest;
import org.feichai.common.domain.ResponseBo;
import org.feichai.system.domain.User;
import org.feichai.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class UserController extends BaseController {
    // private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public String index(Model model) {
        User user = super.getCurrentUser();
        model.addAttribute("user", user);

        return "system/user/user";
    }

    @GetMapping("user/list")
    @ResponseBody
    public Map<String, Object> userList(QueryRequest request, User user) {
        return super.selectByPageNumSize(request, () -> this.userService.findUserWithDept(user, request));
    }

    @PostMapping("user/add")
    @ResponseBody
    public ResponseBo addUser(User user, Long[] roles) {
        try {
            if(user.getStatus().equalsIgnoreCase("on")) {
                user.setStatus(User.STATUS_VALID);
            } else {
                user.setStatus(User.STATUS_LOCK);
            }

            this.userService.addUser(user, roles);
            return ResponseBo.ok("新增用户成功");
        } catch (Exception e) {
            log.error("新增用户失败", e);
            return ResponseBo.error("新增用户失败，请联系管理员!");
        }
    }
}
