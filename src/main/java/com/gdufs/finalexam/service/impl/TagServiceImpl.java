package com.gdufs.finalexam.service.impl;

import com.gdufs.finalexam.dao.BlogTagDao;
import com.gdufs.finalexam.dao.BlogTagRelationDao;
import com.gdufs.finalexam.entity.BlogTag;
import com.gdufs.finalexam.entity.BlogTagCount;
import com.gdufs.finalexam.service.TagService;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private BlogTagDao blogTagDao;
    @Resource
    private BlogTagRelationDao blogTagRelationDao;

    @Override
    public PageResult getBlogTagPage(PageQueryUtil pageUtil) {
        List<BlogTag> tags = blogTagDao.findTagList(pageUtil);
        int total = blogTagDao.getTotalTags(pageUtil);
        return new PageResult(tags, total, pageUtil.getLimit(), pageUtil.getPage());
    }

    @Override
    public int getTotalTags() {
        return blogTagDao.getTotalTags(null);
    }

    @Override
    public Boolean saveTag(String tagName) {
        BlogTag temp = blogTagDao.selectByTagName(tagName);
        if (temp == null) {
            BlogTag blogTag = new BlogTag();
            blogTag.setTagName(tagName);
            return blogTagDao.insertSelective(blogTag) > 0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        // 已存在关联关系不删除
        List<Long> relations = blogTagRelationDao.selectDistinctTagIds(ids);
        if (!CollectionUtils.isEmpty(relations)) {
            return false;
        }
        // 删除tag
        return blogTagDao.deleteBatch(ids) > 0;
    }

    @Override
    public List<BlogTagCount> getBlogTagCountForIndex() {
        return blogTagDao.getTagCount();
    }
}
