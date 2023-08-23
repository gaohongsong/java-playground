package org.feichai.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.controller.BaseController;
import org.feichai.common.domain.QueryRequest;
import org.feichai.common.domain.ResponseBo;
import org.feichai.common.domain.Tree;
import org.feichai.system.domain.Dept;
import org.feichai.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("dept")
    public String index() {
        return "system/dept/dept";
    }

    @RequestMapping("dept/tree")
    @ResponseBody
    public ResponseBo getDeptTree() {
        try {
            Tree<Dept> tree = this.deptService.getDeptTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            log.error("获取部门树失败", e);
            return ResponseBo.error("获取部门树失败!");
        }
    }


    @RequestMapping("dept/list")
    @ResponseBody
    public List<Dept> deptList(Dept dept) {
        return this.deptService.findAllDepts(dept);
    }
}
