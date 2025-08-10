package com.neaterp.module.infra.service.config;

import com.neaterp.module.infra.dal.dataobject.config.ConfigDO;
import com.neaterp.module.infra.dal.mysql.config.ConfigMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 参数配置 Service 实现类
 */
@Service
@Slf4j
@Validated
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;


    @Override
    public ConfigDO getConfigByKey(String key) {
        return configMapper.selectByKey(key);
    }
}
