package com.neaterp.framework.datapermission.config;

import com.neaterp.framework.common.biz.system.permission.PermissionCommonApi;
import com.neaterp.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
import com.neaterp.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
import com.neaterp.framework.security.core.LoginUser;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 基于部门的数据权限 AutoConfiguration
 *
 * @author 芋道源码
 */
@AutoConfiguration
@ConditionalOnClass(LoginUser.class)
@ConditionalOnBean(value = {PermissionCommonApi.class, DeptDataPermissionRuleCustomizer.class})
public class NeaterpDeptDataPermissionAutoConfiguration {

    @Bean
    public DeptDataPermissionRule deptDataPermissionRule(PermissionCommonApi permissionApi,
                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
        // 创建 DeptDataPermissionRule 对象
        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
        // 补全表配置
        customizers.forEach(customizer -> customizer.customize(rule));
        return rule;
    }

}
