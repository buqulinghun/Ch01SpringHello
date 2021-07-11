package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vo.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value="parmters.do")
    public ModelAndView doParamters(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        System.out.println("name:"+name+" age:"+age);
        mv.setViewName("parameterreceive");
        return mv;
    }


    @RequestMapping(value="mispatchparmters.do")
    public ModelAndView doMispatchParamters(@RequestParam(value="rname",required = false) String name,
                                            @RequestParam(value="rage",required = false) Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        System.out.println("rname:"+name+" rage:"+age);
        mv.setViewName("parameterreceive");
        return mv;
    }

    @RequestMapping(value="receiveobject.do")
    public ModelAndView receviceOjb(Student st) {
        System.out.println("receviceOjb st:"+st);

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", st.getName());
        mv.addObject("age", st.getAge());
        mv.addObject("student", st);

        mv.setViewName("showobj");
        return mv;

    }
}
