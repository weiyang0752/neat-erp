package com.neaterp.module.system.service.dept;

import cn.hutool.core.collection.CollUtil;
import com.neaterp.framework.common.enums.CommonStatusEnum;
import com.neaterp.module.system.dal.dataobject.dept.PostDO;
import com.neaterp.module.system.dal.mysql.dept.PostMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.neaterp.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.neaterp.framework.common.util.collection.CollectionUtils.convertMap;
import static com.neaterp.module.system.enums.ErrorCodeConstants.POST_NOT_ENABLE;
import static com.neaterp.module.system.enums.ErrorCodeConstants.POST_NOT_FOUND;

/**
 * 岗位 Service 接口
 *
 * @author 芋道源码
 */
@Service
@Validated
public class PostServiceImpl implements PostService {

    @Resource
    private PostMapper postMapper;


    @Override
    public PostDO getPost(Long id) {
        return postMapper.selectById(id);
    }

    @Override
    public void validatePostList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return;
        }
        // 获得岗位信息
        List<PostDO> posts = postMapper.selectByIds(ids);
        Map<Long, PostDO> postMap = convertMap(posts, PostDO::getId);
        // 校验
        ids.forEach(id -> {
            PostDO post = postMap.get(id);
            if (post == null) {
                throw exception(POST_NOT_FOUND);
            }
            if (!CommonStatusEnum.ENABLE.getStatus().equals(post.getStatus())) {
                throw exception(POST_NOT_ENABLE, post.getName());
            }
        });
    }
}
