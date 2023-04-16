package org.feichai.system.dao;

import org.feichai.common.config.MyMapper;
import org.feichai.system.domain.Menu;

import java.util.List;

public interface MenuMapper extends MyMapper<Menu> {
    List<Menu> findUserPermissions(String userName);
}