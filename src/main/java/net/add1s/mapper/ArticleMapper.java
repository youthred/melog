package net.add1s.mapper;

import net.add1s.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pj.w@qq.com
 */
@Mapper
@Repository
public interface ArticleMapper {

    /**
     * 查询所有文章数据
     *
     * @return List<Article>
     */
    List<Article> findAll();

    /**
     * 查询指定用户的所有文章数据
     *
     * @param email 用户唯一标识
     * @return List<Article>
     */
    List<Article> findAllByUser(@Param("email") String email);

    /**
     * 通过ID查询一条文章数据
     *
     * @param id id
     * @return net.add1s.entity.Article
     */
    Article findOneById(@Param("id") Long id);

    /**
     * 插入一条数据
     *
     * @param article net.add1s.entity.Article
     */
    void saveOne(Article article);

    /**
     * 更新一条数据
     *
     * @param article net.add1s.entity.Article
     */
    void updateOne(Article article);

    /**
     * 删除一条数据（数据库与文件）
     * @param id id
     */
    void deleteOne(@Param("id") Long id);

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
