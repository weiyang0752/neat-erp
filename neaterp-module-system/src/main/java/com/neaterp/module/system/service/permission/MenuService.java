package com.neaterp.module.system.service.permission;

import com.neaterp.module.system.dal.dataobject.permission.MenuDO;

import java.util.List;

/**
 * 菜单 Service 接口
 *
 * @author 芋道源码
 */
public interface MenuService {


    /**
     * 获得所有菜单列表
     *
     * @return 菜单列表
     */
    List<MenuDO> getMenuList();

}
