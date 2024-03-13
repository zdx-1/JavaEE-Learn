package com.zbvc.mapper;

import com.zbvc.pojo.MStudent;

import java.util.List;

public interface MStudentMapper {
    public MStudent findById(Integer id);
    public List<MStudent> findByAny(MStudent student);
    public List<MStudent> findAll();
    public void addMStudent(MStudent student);
    public int updateMStudent(MStudent student);
    public void deleteMStudent(Integer id);
}
