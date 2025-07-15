package com.neaterp.module.infra.api.logger;


import com.neaterp.framework.common.biz.infra.logger.ApiErrorLogCommonApi;
import com.neaterp.framework.common.biz.infra.logger.dto.ApiErrorLogCreateReqDTO;
import org.springframework.stereotype.Service;

@Service
public class ApiErrorLogApiImpl implements ApiErrorLogCommonApi {


    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {

    }
}
