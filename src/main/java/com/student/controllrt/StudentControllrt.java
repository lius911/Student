package com.student.controllrt;
;
import com.student.pojo.Student;
import com.student.service.Imp.StudentServiceImp;
import com.student.service.Imp.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
@Controller
public class StudentControllrt {
    @Autowired
    private StudentServiceImp stuService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private TeacherServiceImp tsi;
    @RequestMapping("/yh")
    public String finsid(HttpServletRequest request){
        String sid = (String)request.getSession().getAttribute("sid");
        System.out.println(sid);
        Student stu=stuService.once(sid);
        request.setAttribute("cs",stu);
        return "student/cnmd";
    }

    @RequestMapping("/updata")
    public String gx(HttpServletRequest request){
        String sid = (String)request.getSession().getAttribute("sid");
        System.out.println(sid);
        Student stu=stuService.once(sid);
        request.setAttribute("sc",stu);
        return  "student/xgmm";
    }
}
