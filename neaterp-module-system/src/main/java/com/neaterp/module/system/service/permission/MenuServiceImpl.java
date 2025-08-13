package com.neaterp.module.system.service.permission;

import com.neaterp.module.system.dal.dataobject.permission.MenuDO;
import com.neaterp.module.system.dal.mysql.permission.MenuMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 菜单 Service 实现
 *
 * @author 芋道源码
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuDO> getMenuList() {
        return menuMapper.selectList();
    }

}
