package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView dosome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "welcome");
        mv.addObject("fun", "do method");
        mv.setViewName("WEB-INF/view/show.jsp");
        System.out.println("dosome method");
        return mv;
    }
}
