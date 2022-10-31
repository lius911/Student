package com.student.service;


import com.student.pojo.Student;

import java.util.List;

public interface StudentService {
    Student dlu(String sid , String spassword);
Student once(String sid);
    Student upstu(Student student);
    public List<Student> cxsy();
    public List<Student> cxsy2(int page, int limit);
    Student add(Student student);

}
