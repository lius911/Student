package com.student.controllrt;

import com.student.pojo.Student;
import com.student.pojo.Teacher;
import com.student.service.Imp.StudentServiceImp;
import com.student.service.Imp.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginControllrt {
    @Autowired
    private StudentServiceImp stuService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private TeacherServiceImp tsi;
    @RequestMapping("/login")
    public String tologin() {
        return "login";
    }
    @RequestMapping("/home")
    public String login(String sid,String spassword, HttpServletRequest request) {
        System.out.println(sid);
        System.out.println(spassword);
        HttpSession session = request.getSession();
        Student stu=stuService.dlu(sid,spassword);

       if ((stu != null)) {
            request.getSession().setAttribute("log", stu);
            session.setAttribute("sid",sid);
            return "student/home";
        } else {
            request.setAttribute("msg", "账号或验证码不正确");
            return "login";
        }

    }
    @RequestMapping("/hthome")

    public String login2(String sid,String spassword, HttpServletRequest request) {
        System.out.println(sid);
        System.out.println(spassword);
        HttpSession session = request.getSession();
        Teacher tea=tsi.jsdlu(sid,spassword);
        if ((tea != null&&tea.getGenre()==0)) {
            request.getSession().setAttribute("log", tea);
            session.setAttribute("sid",sid);
            return "teacher/hthome";
        } else {
            request.setAttribute("msg", "账号或验证码不正确");
            return "login";
        }

    }

}

