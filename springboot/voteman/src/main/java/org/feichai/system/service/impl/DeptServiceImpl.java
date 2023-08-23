package org.feichai.system.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.feichai.common.domain.Tree;
import org.feichai.common.service.impl.BaseService;
import org.feichai.common.util.TreeUtils;
import org.feichai.system.domain.Dept;
import org.feichai.system.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("deptService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends BaseService<Dept> implements DeptService {
    @Override
    public Tree<Dept> getDeptTree() {
        List<Tree<Dept>> trees = new ArrayList<>();
        List<Dept> depts = this.findAllDepts(new Dept());

        depts.forEach(dept -> {
            Tree<Dept> tree = new Tree<>();
            tree.setId(dept.getDeptId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getDeptName());
            trees.add(tree);
        });

        return TreeUtils.build(trees);
    }

    public List<Dept> findAllDepts(Dept dept) {
        try {
            Example example = new Example(Dept.class);
            if (StringUtils.isNotBlank(dept.getDeptName())) {
                example.createCriteria().andCondition("dept_name=", dept.getDeptName());
            }

            example.setOrderByClause("dept_id");
            return this.selectByExample(example);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
