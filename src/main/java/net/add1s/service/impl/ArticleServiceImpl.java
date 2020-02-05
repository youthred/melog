package net.add1s.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.add1s.entity.Article;
import net.add1s.mapper.ArticleMapper;
import net.add1s.mapper.UserMapper;
import net.add1s.service.ArticleService;
import net.add1s.util.ArticleFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author pj.w@qq.com
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;
    private final UserMapper userMapper;
    private final ArticleFileUtil articleFileUtil;

    public ArticleServiceImpl(ArticleMapper articleMapper, UserMapper userMapper, ArticleFileUtil articleFileUtil) {
        this.articleMapper = articleMapper;
        this.userMapper = userMapper;
        this.articleFileUtil = articleFileUtil;
    }

    @Override
    public List<Article> find() {
        return articleMapper.findAll();
    }

    @Override
    public List<Article> find(String email) {
        return articleMapper.findAllByUser(email);
    }

    @Override
    public PageInfo<Article> findByPage(Integer pageIndex, Integer pageSize, String sortStr) {
        PageHelper.startPage(pageIndex, pageSize, sortStr);
        return new PageInfo<>(articleMapper.findAll());
    }

    @Override
    public PageInfo<Article> findByPage(Integer pageIndex, Integer pageSize, String sortStr, String email) {
        PageHelper.startPage(pageIndex, pageSize, sortStr);
        return new PageInfo<>(articleMapper.findAllByUser(email));
    }

    @Override
    public Article find(Long id) throws IOException {
        Article article = articleMapper.findOneById(id);
        article.setContent(articleFileUtil.get(id));
        return article;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Article article) {
        articleMapper.saveOne(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Article article) {
        articleMapper.updateOne(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws IOException {
        articleFileUtil.delete(id);
        articleMapper.deleteOne(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void like(Long id) {
        articleMapper.like(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void viewsPlus(Long id) {
        articleMapper.viewsPlus(id);
    }
}
