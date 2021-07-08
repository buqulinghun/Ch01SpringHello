package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/test")
@Controller
public class MyController {
    @RequestMapping(value = {"some.do", "first.do"})
    public ModelAndView dosome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "welcome");
        mv.addObject("fun", "do method");
        mv.setViewName("show");
        System.out.println("dosome method");
        return mv;
    }

    @RequestMapping(value={"other.do", "sencond.do"})
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", "error");
        mv.addObject("status", "404");
        mv.setViewName("other");
        return mv;
    }

    @RequestMapping(value="any.do")
    public ModelAndView doAny() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", "error");
        mv.addObject("status", "404");
        mv.setViewName("other");
        return mv;
    }
}
