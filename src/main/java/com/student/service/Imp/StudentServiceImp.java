package com.student.service.Imp;


import com.student.dao.StudentDao;
import com.student.pojo.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentDao sdao;
    @Override
    public Student dlu(String sid, String spassword) {
        return sdao.dlu(sid, spassword);
    }

    @Override
    public Student once(String sid) {
        return sdao.once(sid);
    }

    @Override
    public Student upstu(Student student) {
        return sdao.upstu(student);
    }

    @Override
    public List<Student> cxsy() {
        return sdao.cxsy();
    }

    @Override
    public List<Student> cxsy2(int page, int limit) {
        List<Student> list = new ArrayList<>();
        int start = (page - 1) * limit;
        for (int i = start; i < start + limit && i < sdao.cxsy().size(); i++) {
            list.add(sdao.cxsy().get(i));
        }
        return list;
    }

    @Override
    public Student add(Student student) {
        return sdao.add(student);
    }
}

