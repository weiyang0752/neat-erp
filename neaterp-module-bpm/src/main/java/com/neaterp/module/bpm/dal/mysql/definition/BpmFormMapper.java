package com.neaterp.module.bpm.dal.mysql.definition;


import com.neaterp.framework.common.pojo.PageResult;
import com.neaterp.framework.mybatis.core.mapper.BaseMapperX;
import com.neaterp.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.neaterp.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import com.neaterp.module.bpm.dal.dataobject.definition.BpmFormDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 *
 * @author 风里雾里
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmFormDO>()
                .likeIfPresent(BpmFormDO::getName, reqVO.getName())
                .orderByDesc(BpmFormDO::getId));
    }

}
