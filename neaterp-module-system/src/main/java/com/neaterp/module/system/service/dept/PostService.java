package com.neaterp.module.system.service.dept;

import com.neaterp.module.system.dal.dataobject.dept.PostDO;

import java.util.Collection;

/**
 * 岗位 Service 接口
 *
 * @author 芋道源码
 */
public interface PostService {

    /**
     * 获得岗位信息
     *
     * @param id 岗位编号
     * @return 岗位信息
     */
    PostDO getPost(Long id);



    /**
     * 校验岗位们是否有效。如下情况，视为无效：
     * 1. 岗位编号不存在
     * 2. 岗位被禁用
     *
     * @param ids 岗位编号数组
     */
    void validatePostList(Collection<Long> ids);

}
