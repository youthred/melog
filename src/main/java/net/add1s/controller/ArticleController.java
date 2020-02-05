package net.add1s.controller;

import com.github.pagehelper.PageInfo;
import net.add1s.entity.Article;
import net.add1s.entity.common.AjaxResult;
import net.add1s.entity.common.Sort;
import net.add1s.service.ArticleService;
import net.add1s.util.ArticleFileUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author pj.w@qq.com
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleFileUtil articleFileUtil;

    public ArticleController(ArticleService articleService, ArticleFileUtil articleFileUtil) {
        this.articleService = articleService;
        this.articleFileUtil = articleFileUtil;
    }

    @GetMapping("/findAll")
    public AjaxResult findAll() {
        return AjaxResult.me().setResultObj(articleService.find());
    }

    @GetMapping("/findByPage")
    public AjaxResult findByPage(@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize, @RequestParam("isSignIn") boolean isSignIn) {
        PageInfo<Article> articlePageInfo = isSignIn ?
                articleService.findByPage(pageIndex, pageSize, "id " + Sort.DESC.getSort(), getUser().getUsername())
                : articleService.findByPage(pageIndex, pageSize, "id " + Sort.DESC.getSort());
        return AjaxResult.me().setResultObj(new HashMap<String, Object>(3) {{
            put("total", articlePageInfo.getTotal());
            put("list", articlePageInfo.getList());
            put("pages", articlePageInfo.getPages());
        }});
    }

    @PostMapping("/save")
    public AjaxResult articleSave(Article article) throws IOException, URISyntaxException {
        long id = System.currentTimeMillis();
        // 保存文件
        String articlePath = articleFileUtil.save(id, article.getContent());
        // 入库
        articleService.save(new Article() {{
            setId(id);
            setTitle(article.getTitle());
            setContentPath(articlePath);
            setCreateTime(new Date());
            setAuthor(getUser().getUsername());
        }});

        return AjaxResult.me();
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable("id") Long id) throws IOException, URISyntaxException {
        Article article = articleService.find(id);
        article.setContent(articleFileUtil.get(article.getId()));
        return new ModelAndView("admin/new", new HashMap<String, Object>(1) {{
            put("articleForUpdate", article);
        }});
    }

    @PostMapping("/update")
    public AjaxResult doUpdate(Article article) throws URISyntaxException, IOException {
        // 保存文件
        articleFileUtil.update(article.getId(), article.getContent());
        // 修改数据库数据
        article.setUpdateTime(new Date());
        articleService.update(article);

        return AjaxResult.me();
    }

    @GetMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) throws IOException, URISyntaxException {
        articleService.delete(id);
        return AjaxResult.me();
    }

    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable("id") Long id) throws IOException, URISyntaxException {
        // 浏览量 +1
        articleService.viewsPlus(id);
        return new ModelAndView("article/show", new HashMap<String, Object>(1) {{
            put("article", articleService.find(id));
        }});
    }

    @GetMapping("/like/{id}")
    public AjaxResult like(@PathVariable("id") Long id) {
        articleService.like(id);
        return AjaxResult.me();
    }

    private User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
