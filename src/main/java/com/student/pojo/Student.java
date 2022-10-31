package com.student.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  private String sid;
  private String sname;
  private String spassword;
  private String ssex;
  private Date sbirthday;
  private String sidentitycode;
  private String semail;
  private String smobile;
  private String saddress;
  private String simgurl;
  private String sclass;

}
