package org.feichai.system.service;

import org.feichai.common.domain.Tree;
import org.feichai.common.service.IService;
import org.feichai.system.domain.Menu;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "MenuService")
public interface MenuService extends IService<Menu> {
    List<Menu> findUserPermissions(String userName);
    List<Menu> findUserMenus(String userName);
    List<Menu> findAllMenu(Menu menu);
    Tree<Menu> getUserMenu(String userName);
}
