package com.neaterp.module.system.api.logger;

import com.neaterp.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import com.neaterp.framework.common.pojo.PageResult;
import com.neaterp.framework.common.util.object.BeanUtils;
import com.neaterp.module.system.api.logger.dto.OperateLogPageReqDTO;
import com.neaterp.module.system.api.logger.dto.OperateLogRespDTO;
import com.neaterp.module.system.dal.dataobject.logger.OperateLogDO;
import com.neaterp.module.system.dal.mysql.logger.OperateLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 操作日志 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

    @Override
    public PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class);
    }

}
