package org.feichai.system.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.feichai.common.domain.QueryRequest;
import org.feichai.common.domain.Tree;
import org.feichai.common.service.impl.BaseService;
import org.feichai.common.util.TreeUtils;
import org.feichai.system.dao.DictMapper;
import org.feichai.system.domain.Dict;
import org.feichai.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("dictService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl extends BaseService<Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<Dict> findAllDicts(Dict dict) {
        try {
            Example example = new Example(Dict.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(dict.getKeyy())) {
                criteria.andCondition("keyy=", Long.valueOf(dict.getKeyy()));
            }
            if (StringUtils.isNotBlank(dict.getValuee())) {
                criteria.andCondition("valuee=", dict.getValuee());
            }
            if (StringUtils.isNotBlank(dict.getTableName())) {
                criteria.andCondition("table_name=", dict.getTableName());
            }
            if (StringUtils.isNotBlank(dict.getFieldName())) {
                criteria.andCondition("field_name=", dict.getFieldName());
            }
            example.setOrderByClause("dict_id");
            return this.selectByExample(example);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
