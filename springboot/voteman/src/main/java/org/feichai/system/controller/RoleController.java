package org.feichai.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.controller.BaseController;
import org.feichai.common.domain.QueryRequest;
import org.feichai.system.domain.Role;
import org.feichai.system.domain.User;
import org.feichai.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("role")
    public String index(Model model) {
        // User user = super.getCurrentUser();
        // model.addAttribute("user", user);
        return "system/role/role";
    }

    // @PostMapping("role/list")
    @RequestMapping("role/list")
    @ResponseBody
    public Map<String, Object> roleList(QueryRequest request, Role role) {
        return super.selectByPageNumSize(request, () -> this.roleService.findAllRole(role));
    }
}
