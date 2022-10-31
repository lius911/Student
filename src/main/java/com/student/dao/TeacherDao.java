package com.student.dao;



import com.student.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherDao {
    Teacher jsdlu(@Param("sid")String sid , @Param("spassword")String spassword);
}
