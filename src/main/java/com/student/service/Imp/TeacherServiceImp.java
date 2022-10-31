package com.student.service.Imp;



import com.student.dao.TeacherDao;
import com.student.pojo.Teacher;
import com.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherDao tdao;
    @Override
    public Teacher jsdlu(String sid, String spassword) {
        return tdao.jsdlu(sid,spassword);
    }
}
