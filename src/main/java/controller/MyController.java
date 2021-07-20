package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vo.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value="returnstring.do")
    public String doReturnString(HttpServletRequest request, String name, Integer age) {
        System.out.println("doReturnString name:"+name+" age:"+age);
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        return "showReturnString";
    }

    @RequestMapping(value="returnvoid-ajax.do")
    public void doReturnVoidToString(HttpServletResponse response, String name, String age) {
        Student st = new Student();
        st.setName(name);
        st.setAge(age);


        response.setContentType("application/json;charset=utf-8");

        ObjectMapper om = new ObjectMapper();
        PrintWriter pw = null;
        try {
                String json = om.writeValueAsString(st);
                pw = response.getWriter();
                pw.write(json);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

   @RequestMapping(value = "returnobject-ajax.do")
   @ResponseBody
    public Student doReturnObjectAjax(Student st){
       System.out.println("doReturnObj st:"+st);
       return st;
    }

    @RequestMapping(value="returnobjarray.do")
    @ResponseBody
    public List<Student> doReturnObjArray(String name, String age) {
        List<Student> students = new ArrayList<>();
        Student st1 = new Student();
        st1.setName("zhangsan");
        st1.setAge("21");
        students.add(st1);

        Student st2 = new Student();
        st2.setName("lisi");
        st2.setAge("34");
        students.add(st2);

        return students;
    }

    @RequestMapping(value="returnstring.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doReturnString(String name, String age){
        return "返回文本字符串测试";
    }
}
