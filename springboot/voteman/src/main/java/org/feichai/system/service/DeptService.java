package org.feichai.system.service;

import org.feichai.common.domain.Tree;
import org.feichai.common.service.IService;
import org.feichai.system.domain.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {
    Tree<Dept> getDeptTree();
    List<Dept> findAllDepts(Dept dept);
}
