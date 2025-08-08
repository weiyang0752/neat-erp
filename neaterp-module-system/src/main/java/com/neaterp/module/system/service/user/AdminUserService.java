package com.neaterp.module.system.service.user;

import com.neaterp.module.system.controller.admin.user.vo.user.UserSaveReqVO;
import jakarta.validation.Valid;

/**
 * 后台用户 Service 接口
 *
 * @author 芋道源码
 */
public interface AdminUserService {

    /**
     * 创建用户
     *
     * @param createReqVO 用户信息
     * @return 用户编号
     */
    Long createUser(@Valid UserSaveReqVO createReqVO);


}
