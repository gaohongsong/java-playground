package org.feichai.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.controller.BaseController;
import org.feichai.common.domain.ResponseBo;
import org.feichai.common.domain.Tree;
import org.feichai.system.domain.Menu;
import org.feichai.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("menu/getUserMenu")
    @ResponseBody
    public ResponseBo getUserMenu(String userName) {
        try {
            Tree<Menu> tree = this.menuService.getUserMenu(userName);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            log.error("获取用户菜单失败", e);
            return ResponseBo.error("获取用户菜单失败!" );
        }
    }
}
