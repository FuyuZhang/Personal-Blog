package com.gdufs.finalexam.service.impl;

import com.gdufs.finalexam.dao.BlogCategoryDao;
import com.gdufs.finalexam.dao.BlogDao;
import com.gdufs.finalexam.entity.BlogCategory;
import com.gdufs.finalexam.service.CategoryService;
import com.gdufs.finalexam.utils.PageQueryUtil;
import com.gdufs.finalexam.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private BlogCategoryDao blogCategoryDao;
    @Resource
    private BlogDao blogDao;

    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageUtil) {
        List<BlogCategory> categoryList = blogCategoryDao.findCategoryList(pageUtil);
        int total = blogCategoryDao.getTotalCategories(pageUtil);
        return new PageResult(categoryList, total, pageUtil.getLimit(), pageUtil.getPage());
    }

    @Override
    public int getTotalCategories() {
        return blogCategoryDao.getTotalCategories(null);
    }

    @Override
    public Boolean saveCategory(String categoryName, String categoryIcon) {
        BlogCategory temp = blogCategoryDao.selectByCategoryName(categoryName);
        if (temp == null) {
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setCategoryName(categoryName);
            blogCategory.setCategoryIcon(categoryIcon);
            return blogCategoryDao.insertSelective(blogCategory) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        BlogCategory blogCategory = blogCategoryDao.selectByPrimaryKey(categoryId);
        if (blogCategory != null) {
            blogCategory.setCategoryIcon(categoryIcon);
            blogCategory.setCategoryName(categoryName);
            // 修改分类实体
            blogDao.updateBlogCategorys(categoryName, blogCategory.getCategoryId(), new Integer[]{categoryId});
            return blogCategoryDao.updateByPrimaryKeySelective(blogCategory) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        // 修改tb_blog表
        blogDao.updateBlogCategorys("默认分类", 0, ids);
        // 删除分类数据
        return blogCategoryDao.deleteBatch(ids) > 0;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryDao.findCategoryList(null);
    }

}
