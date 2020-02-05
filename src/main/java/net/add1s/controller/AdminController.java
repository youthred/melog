package net.add1s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pj.w@qq.com
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/articles")
    public ModelAndView articles() {
        return new ModelAndView("admin/articles");
    }

    @GetMapping("/new")
    public ModelAndView newArticles() {
        return new ModelAndView("admin/new");
    }

    @GetMapping("/statistics")
    public ModelAndView statistics() {
        return new ModelAndView("admin/statistics");
    }
}
