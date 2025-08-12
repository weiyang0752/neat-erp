package com.neaterp.module.system.service.tenant;

import com.neaterp.framework.common.enums.CommonStatusEnum;
import com.neaterp.module.system.dal.dataobject.tenant.TenantPackageDO;
import com.neaterp.module.system.dal.mysql.tenant.TenantPackageMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.neaterp.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.neaterp.module.system.enums.ErrorCodeConstants.TENANT_PACKAGE_DISABLE;
import static com.neaterp.module.system.enums.ErrorCodeConstants.TENANT_PACKAGE_NOT_EXISTS;

/**
 * 租户套餐 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TenantPackageServiceImpl implements TenantPackageService {

    @Resource
    private TenantPackageMapper tenantPackageMapper;


    @Override
    public TenantPackageDO validTenantPackage(Long id) {
        TenantPackageDO tenantPackage = tenantPackageMapper.selectById(id);
        if (tenantPackage == null) {
            throw exception(TENANT_PACKAGE_NOT_EXISTS);
        }
        if (tenantPackage.getStatus().equals(CommonStatusEnum.DISABLE.getStatus())) {
            throw exception(TENANT_PACKAGE_DISABLE, tenantPackage.getName());
        }
        return tenantPackage;
    }
}
