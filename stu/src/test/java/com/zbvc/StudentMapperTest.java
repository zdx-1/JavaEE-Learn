package com.zbvc;

import com.zbvc.mapper.MStudentMapper;
import com.zbvc.mapper.StudentMapper;
import com.zbvc.pojo.MStudent;
import com.zbvc.pojo.Student;
import com.zbvc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class StudentMapperTest {
    static SqlSession sqlSession=null;
    static StudentMapper studentMapper=null;
    static MStudentMapper mstudentMapper=null;
    static{
        sqlSession= MybatisUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        mstudentMapper=sqlSession.getMapper(MStudentMapper.class);
    }
    @Test
    public void findByIdTest(){
        Student student=studentMapper.findById(1);
        System.out.println(student);
    }
    @Test
    public void findByIdTest2(){
        MStudent mstudent=mstudentMapper.findById(1);
        System.out.println(mstudent);
    }

    @Test
    public void findAllTest(){
        List<Student> students=studentMapper.findAll();
        for(Student student:students){
            System.out.println(student);
        }
    }

    @Test
    public void addStudentTest(){
        Student stu=new Student();
        stu.setUsername("zbvc2");
        stu.setJobs("java");
        studentMapper.addStudent(stu);
        sqlSession.commit();
    }

    @Test
    public void updateStudentTest(){
        Student stu=new Student();
        stu.setId(3);
        stu.setUsername("zhangsan");
        stu.setPhone("12345622");
        int n=studentMapper.updateStudent(stu);
        if(n>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
        sqlSession.commit();
    }
    @Test
    public void deleteStudentTest(){
        studentMapper.deleteStudent(1);
        sqlSession.commit();
    }
    @AfterAll
    public static void close(){
        sqlSession.close();
    }
}