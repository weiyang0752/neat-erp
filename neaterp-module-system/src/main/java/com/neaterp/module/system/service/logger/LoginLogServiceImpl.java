package com.neaterp.module.system.service.logger;


import com.neaterp.framework.common.pojo.PageResult;
import com.neaterp.framework.common.util.object.BeanUtils;
import com.neaterp.module.system.api.logger.dto.LoginLogCreateReqDTO;
import com.neaterp.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.neaterp.module.system.dal.dataobject.logger.LoginLogDO;
import com.neaterp.module.system.dal.mysql.logger.LoginLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 登录日志 Service 实现
 */
@Service
@Validated
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO pageReqVO) {
        return loginLogMapper.selectPage(pageReqVO);
    }

    @Override
    public void createLoginLog(LoginLogCreateReqDTO reqDTO) {
        LoginLogDO loginLog = BeanUtils.toBean(reqDTO, LoginLogDO.class);
        loginLogMapper.insert(loginLog);
    }

}
