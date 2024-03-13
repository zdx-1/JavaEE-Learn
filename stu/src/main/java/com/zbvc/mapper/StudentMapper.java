package com.zbvc.mapper;

import com.zbvc.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //ctrl+shift+t
    public Student findById(Integer id);
    public List<Student> findAll();
    public void addStudent(Student student);
    public int updateStudent(Student student);
    public void deleteStudent(Integer id);
}
