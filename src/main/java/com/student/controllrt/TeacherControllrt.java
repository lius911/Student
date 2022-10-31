package com.student.controllrt;

import com.student.pojo.Student;
import com.student.service.Imp.StudentServiceImp;
import com.student.service.Imp.TeacherServiceImp;
import com.student.utility.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@CrossOrigin
public class TeacherControllrt {
    @Autowired
    private StudentServiceImp stuService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private TeacherServiceImp tsi;

    @RequestMapping("/syxs")
    public String syxs(){
        return  "teacher/xsxx";
    }
    @RequestMapping("/cxsy")
    @ResponseBody
    public ResultBean cxsy(@RequestParam(defaultValue = "1")Integer page,
                           @RequestParam(defaultValue = "10") Integer limit){
        List<Student>s=stuService.cxsy2(page,limit);
        int count=stuService.cxsy().size();
        ResultBean result = new ResultBean(0,"查询成功",count,s);
        System.out.println(result);
        return  result;
    }
     @RequestMapping("/add")
     @ResponseBody
    public ResultBean save(Student student){
        stuService.add(student);

        return new ResultBean(200,"保存成功",0,"");
    }
}
