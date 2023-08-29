package org.feichai.system.service;

import org.feichai.common.service.IService;
import org.feichai.system.domain.Dict;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;


@CacheConfig(cacheNames = "DictService")
public interface DictService extends IService<Dict> {
    List<Dict> findAllDicts(Dict dict);
}
