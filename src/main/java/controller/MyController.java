package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = {"/test/some.do", "/test/first.do"})
    public ModelAndView dosome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "welcome");
        mv.addObject("fun", "do method");
        mv.setViewName("show");
        System.out.println("dosome method");
        return mv;
    }

    @RequestMapping(value={"/test/other.do", "/test/sencond.do"})
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", "error");
        mv.addObject("status", "404");
        mv.setViewName("other");
        return mv;
    }
}
