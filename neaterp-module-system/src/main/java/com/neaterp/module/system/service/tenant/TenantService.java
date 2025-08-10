package com.neaterp.module.system.service.tenant;

import com.neaterp.framework.tenant.core.context.TenantContextHolder;
import com.neaterp.module.system.dal.dataobject.tenant.TenantDO;
import com.neaterp.module.system.service.tenant.handler.TenantInfoHandler;

import java.util.List;

/**
 * 租户 Service 接口
 *
 * @author 芋道源码
 */
public interface TenantService {

    /**
     * 获得租户
     *
     * @param id 编号
     * @return 租户
     */
    TenantDO getTenant(Long id);

    /**
     * 获得名字对应的租户
     *
     * @param name 租户名
     * @return 租户
     */
    TenantDO getTenantByName(String name);

    /**
     * 获得指定状态的租户列表
     *
     * @param status 状态
     * @return 租户列表
     */
    List<TenantDO> getTenantListByStatus(Integer status);

    /**
     * 进行租户的信息处理逻辑
     * 其中，租户编号从 {@link TenantContextHolder} 上下文中获取
     *
     * @param handler 处理器
     */
    void handleTenantInfo(TenantInfoHandler handler);


}
