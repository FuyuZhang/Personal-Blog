package com.gdufs.finalexam.service.impl;

import com.gdufs.finalexam.service.LinkService;
import com.gdufs.finalexam.dao.BlogLinkDao;
import com.gdufs.finalexam.entity.BlogLink;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private BlogLinkDao blogLinkDao;

    @Override
    public PageResult getBlogLinkPage(PageQueryUtil pageUtil) {
        List<BlogLink> links = blogLinkDao.findLinkList(pageUtil);
        int total = blogLinkDao.getTotalLinks(pageUtil);
        return new PageResult(links, total, pageUtil.getLimit(), pageUtil.getPage());
    }

    @Override
    public int getTotalLinks() {
        return blogLinkDao.getTotalLinks(null);
    }

    @Override
    public Boolean saveLink(BlogLink link) {
        return blogLinkDao.insertSelective(link) > 0;
    }

    @Override
    public BlogLink selectById(Integer id) {
        return blogLinkDao.selectByPrimaryKey(id);
    }

    @Override
    public Boolean updateLink(BlogLink tempLink) {
        return blogLinkDao.updateByPrimaryKeySelective(tempLink) > 0;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return blogLinkDao.deleteBatch(ids) > 0;
    }

    @Override
    public Map<Byte, List<BlogLink>> getLinksForLinkPage() {
        // 获取所有链接数据
        List<BlogLink> links = blogLinkDao.findLinkList(null);
        if (!CollectionUtils.isEmpty(links)) {
            // 根据type进行分组
            Map<Byte, List<BlogLink>> linksMap = links.stream().collect(Collectors.groupingBy(BlogLink::getLinkType));
            return linksMap;
        }
        return null;
    }
}
