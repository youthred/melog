package net.add1s.service;

import com.github.pagehelper.PageInfo;
import net.add1s.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author pj.w@qq.com
 */
public interface ArticleService {

    /**
     * 查询所有文章数据
     *
     * @return List<Article>
     */
    List<Article> find();

    /**
     * 查询指定用户的所有文章数据
     *
     * @param email 用户唯一标识
     * @return List<Article>
     */
    List<Article> find(@Param("email") String email);

    /**
     * 分页查询所有文章
     *
     * @param pageIndex 当前页号
     * @param pageSize 每页条数
     * @param sortStr 排序字段及规则，“id ASC”、“id DESC, age ASC”
     * @return PageInfo<Article>
     */
    PageInfo<Article> findByPage(Integer pageIndex, Integer pageSize, String sortStr);

    /**
     * 分页查询指定用户的所有文章
     *
     * @param pageIndex 当前页号
     * @param pageSize 每页条数
     * @param sortStr 排序字段及规则，“id ASC”、“id DESC, age ASC”
     * @param email 用户唯一标识
     * @return PageInfo<Article>
     */
    PageInfo<Article> findByPage(Integer pageIndex, Integer pageSize, String sortStr, String email);

    /**
     * 通过ID查询一条文章数据
     *
     * @param id id
     * @return net.add1s.entity.Article
     */
    Article find(@Param("id") Long id) throws IOException;

    /**
     * 插入一条数据
     *
     * @param article net.add1s.entity.Article
     */
    void save(Article article);

    /**
     * 更新一条数据
     *
     * @param article net.add1s.entity.Article
     */
    void update(Article article);

    /**
     * 删除一条数据（数据库与文件）
     *
     * @param id id
     * @throws IOException e1
     * @throws URISyntaxException e2
     */
    void delete(Long id) throws IOException, URISyntaxException;

    /**
     * 点赞/喜欢 +1
     *
     * @param id id
     */
    void like(@Param("id") Long id);

    /**
     * 浏览量 +1
     *
     * @param id id
     */
    void viewsPlus(@Param("id") Long id);
}
