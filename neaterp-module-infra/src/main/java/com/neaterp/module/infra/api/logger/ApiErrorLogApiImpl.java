package com.neaterp.module.infra.api.logger;


import com.neaterp.framework.common.biz.infra.logger.ApiErrorLogCommonApi;
import com.neaterp.framework.common.biz.infra.logger.dto.ApiErrorLogCreateReqDTO;
import com.neaterp.module.infra.service.logger.ApiErrorLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ApiErrorLogApiImpl implements ApiErrorLogCommonApi {

    @Resource
    private ApiErrorLogService apiErrorLogService;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        apiErrorLogService.createApiErrorLog(createDTO);
    }
}
