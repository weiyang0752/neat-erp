package com.neaterp.module.system.service.permission;

import com.neaterp.module.system.controller.admin.permission.vo.role.RoleSaveReqVO;
import jakarta.validation.Valid;

/**
 * 角色 Service 接口
 *
 * @author 芋道源码
 */
public interface RoleService {

    /**
     * 创建角色
     *
     * @param createReqVO 创建角色信息
     * @param type 角色类型
     * @return 角色编号
     */
    Long createRole(@Valid RoleSaveReqVO createReqVO, Integer type);


}
