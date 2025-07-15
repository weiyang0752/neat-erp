package com.neaterp.module.infra.api.logger;


import com.neaterp.framework.common.biz.infra.logger.ApiAccessLogCommonApi;
import com.neaterp.framework.common.biz.infra.logger.dto.ApiAccessLogCreateReqDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * API 访问日志的 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiAccessLogApiImpl implements ApiAccessLogCommonApi {


    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {

    }
}
