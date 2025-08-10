package com.neaterp.module.infra.service.config;

import com.neaterp.module.infra.dal.dataobject.config.ConfigDO;

/**
 * 参数配置 Service 接口
 *
 * @author 芋道源码
 */
public interface ConfigService {

    /**
     * 根据参数键，获得参数配置
     *
     * @param key 配置键
     * @return 参数配置
     */
    ConfigDO getConfigByKey(String key);


}
