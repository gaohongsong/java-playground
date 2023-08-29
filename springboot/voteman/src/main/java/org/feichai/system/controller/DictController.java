package org.feichai.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.controller.BaseController;
import org.feichai.common.domain.QueryRequest;
import org.feichai.common.domain.ResponseBo;
import org.feichai.common.domain.Tree;
import org.feichai.system.domain.Dict;
import org.feichai.system.domain.Menu;
import org.feichai.system.service.DictService;
import org.feichai.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    @RequestMapping("dict")
    public String index() {
        return "system/dict/dict";
    }

    @RequestMapping("dict/list")
    @ResponseBody
    public Map<String, Object> menuList(QueryRequest request, Dict dict) {
        return this.selectByPageNumSize(request, () -> this.dictService.findAllDicts(dict));
    }

}
