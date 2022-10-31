package com.student.dao;


import com.student.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    Student dlu(@Param("sid")String sid , @Param("spassword")String spassword);
    Student once(String sid);
    Student upstu(Student student);
    public List<Student>cxsy();
    public List<Student>cxsy2(int page, int limit);
    Student add(Student student);
}
