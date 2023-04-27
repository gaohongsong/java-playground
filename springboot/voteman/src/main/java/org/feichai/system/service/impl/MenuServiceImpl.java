package org.feichai.system.service.impl;

import org.feichai.common.domain.Tree;
import org.feichai.common.service.impl.BaseService;
import org.feichai.common.util.TreeUtils;
import org.feichai.system.dao.MenuMapper;
import org.feichai.system.domain.Menu;
import org.feichai.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findUserPermissions(String userName) {
        return menuMapper.findUserPermissions(userName);
    }

    @Override
    public List<Menu> findUserMenus(String userName) {
        return this.menuMapper.findUserMenus(userName);
    }

    @Override
    public Tree<Menu> getUserMenu(String userName) {
        List<Tree<Menu>> trees = new ArrayList<>();
        List<Menu> menus = findUserMenus(userName);
        menus.forEach(menu -> {
            Tree<Menu> tree = new Tree<>();
            tree.setId(menu.getMenuId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getMenuName());
            tree.setIcon(menu.getIcon());
            tree.setUrl(menu.getUrl());
            trees.add(tree);
        });

        return TreeUtils.build(trees);
    }
}
