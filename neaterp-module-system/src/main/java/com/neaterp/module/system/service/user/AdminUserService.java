package com.neaterp.module.system.service.user;

import com.neaterp.framework.common.pojo.PageResult;
import com.neaterp.module.system.controller.admin.user.vo.user.UserImportExcelVO;
import com.neaterp.module.system.controller.admin.user.vo.user.UserImportRespVO;
import com.neaterp.module.system.controller.admin.user.vo.user.UserPageReqVO;
import com.neaterp.module.system.controller.admin.user.vo.user.UserSaveReqVO;
import com.neaterp.module.system.dal.dataobject.user.AdminUserDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * 后台用户 Service 接口
 *
 * @author 芋道源码
 */
public interface AdminUserService {

    /**
     * 创建用户
     *
     * @param createReqVO 用户信息
     * @return 用户编号
     */
    Long createUser(@Valid UserSaveReqVO createReqVO);


    /**
     * 修改用户
     *
     * @param updateReqVO 用户信息
     */
    void updateUser(@Valid UserSaveReqVO updateReqVO);

    /**
     * 删除用户
     *
     * @param id 用户编号
     */
    void deleteUser(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 用户编号数组
     */
    void deleteUserList(List<Long> ids);

    /**
     * 修改密码
     *
     * @param id       用户编号
     * @param password 密码
     */
    void updateUserPassword(Long id, String password);

    /**
     * 修改状态
     *
     * @param id     用户编号
     * @param status 状态
     */
    void updateUserStatus(Long id, Integer status);

    /**
     * 获得用户分页列表
     *
     * @param reqVO 分页条件
     * @return 分页列表
     */
    PageResult<AdminUserDO> getUserPage(UserPageReqVO reqVO);

    /**
     * 获得指定状态的用户们
     *
     * @param status 状态
     * @return 用户们
     */
    List<AdminUserDO> getUserListByStatus(Integer status);

    /**
     * 通过用户 ID 查询用户
     *
     * @param id 用户ID
     * @return 用户对象信息
     */
    AdminUserDO getUser(Long id);

    /**
     * 批量导入用户
     *
     * @param importUsers     导入用户列表
     * @param isUpdateSupport 是否支持更新
     * @return 导入结果
     */
    UserImportRespVO importUserList(List<UserImportExcelVO> importUsers, boolean isUpdateSupport);

}
