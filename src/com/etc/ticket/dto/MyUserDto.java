package com.etc.ticket.dto;

import org.springframework.web.multipart.MultipartFile;

public class MyUserDto {
    private Integer userid;
    private String username;
    private String userpwd;
    private String sex;
    private String useremail;
    private MultipartFile userlogo;  //要上传的头像对象

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public MultipartFile getUserlogo() {
        return userlogo;
    }

    public void setUserlogo(MultipartFile userlogo) {
        this.userlogo = userlogo;
    }
}
