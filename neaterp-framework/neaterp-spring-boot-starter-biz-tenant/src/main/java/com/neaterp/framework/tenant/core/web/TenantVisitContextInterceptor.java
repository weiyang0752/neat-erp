package com.neaterp.framework.tenant.core.web;

import cn.hutool.core.util.ObjUtil;
import com.neaterp.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.neaterp.framework.security.core.LoginUser;
import com.neaterp.framework.security.core.service.SecurityFrameworkService;
import com.neaterp.framework.security.core.util.SecurityFrameworkUtils;
import com.neaterp.framework.tenant.config.TenantProperties;
import com.neaterp.framework.tenant.core.context.TenantContextHolder;
import com.neaterp.framework.web.core.util.WebFrameworkUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.neaterp.framework.common.exception.util.ServiceExceptionUtil.exception0;


@RequiredArgsConstructor
@Slf4j
public class TenantVisitContextInterceptor implements HandlerInterceptor {

    private static final String PERMISSION = "system:tenant:visit";

    private final TenantProperties tenantProperties;

    private final SecurityFrameworkService securityFrameworkService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果和当前租户编号一致，则直接跳过
        Long visitTenantId = WebFrameworkUtils.getVisitTenantId(request);
        if (visitTenantId == null) {
            return true;
        }
        if (ObjUtil.equal(visitTenantId, TenantContextHolder.getTenantId())) {
            return true;
        }
        // 必须是登录用户
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        if (loginUser == null) {
            return true;
        }

        // 校验用户是否可切换租户
        if (!securityFrameworkService.hasAnyPermissions(PERMISSION)) {
            throw exception0(GlobalErrorCodeConstants.FORBIDDEN.getCode(), "您无权切换租户");
        }

        // 【重点】切换租户编号
        loginUser.setVisitTenantId(visitTenantId);
        TenantContextHolder.setTenantId(visitTenantId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 【重点】清理切换，换回原租户编号
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        if (loginUser != null && loginUser.getTenantId() != null) {
            TenantContextHolder.setTenantId(loginUser.getTenantId());
        }
    }

}
