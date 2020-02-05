package net.add1s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @author mahoshojo
 */
@RestController
public class CommonController {

    /**
     * 跳转到首页
     *
     * @return
     */
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index/index");
    }

    @GetMapping("/search")
    public ModelAndView search(String keyword) {
        return new ModelAndView("search/index", "data", new HashMap<String, Object>(1) {{
            put("a", keyword);
        }});
    }
}
