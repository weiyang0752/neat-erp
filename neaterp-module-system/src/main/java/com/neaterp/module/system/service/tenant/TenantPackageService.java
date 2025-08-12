package com.neaterp.module.system.service.tenant;

import com.neaterp.module.system.dal.dataobject.tenant.TenantPackageDO;

/**
 * 租户套餐 Service 接口
 *
 * @author 芋道源码
 */
public interface TenantPackageService {


    /**
     * 校验租户套餐
     *
     * @param id 编号
     * @return 租户套餐
     */
    TenantPackageDO validTenantPackage(Long id);


}
