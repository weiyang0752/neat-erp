package com.neaterp.module.system.service.permission;

import com.neaterp.module.system.controller.admin.permission.vo.role.RoleSaveReqVO;
import com.neaterp.module.system.dal.dataobject.permission.RoleDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

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


    /**
     * 获得所有角色列表
     *
     * @return 角色列表
     */
    List<RoleDO> getRoleList();

    /**
     * 判断角色编号数组中，是否有管理员
     *
     * @param ids 角色编号数组
     * @return 是否有管理员
     */
    boolean hasAnySuperAdmin(Collection<Long> ids);

    /**
     * 获得角色，从缓存中
     *
     * @param id 角色编号
     * @return 角色
     */
    RoleDO getRoleFromCache(Long id);

}
