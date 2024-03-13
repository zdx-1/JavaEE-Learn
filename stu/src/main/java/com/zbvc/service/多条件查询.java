package com.zbvc.service;

import com.zbvc.mapper.MStudentMapper;
import com.zbvc.mapper.StudentMapper;
import com.zbvc.pojo.MStudent;
import com.zbvc.pojo.Student;
import com.zbvc.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class 多条件查询 {
    static SqlSession sqlSession=null;
    static MStudentMapper mstudentMapper=null;
    static{
        sqlSession= MybatisUtils.getSqlSession();
        mstudentMapper=sqlSession.getMapper(MStudentMapper.class);
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入查询条件：");
            System.out.println("1.多条件查询");
            System.out.println("2.单条件查询");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    String ce = scanner.nextLine();
                    System.out.println("请输入查询条件：");
                    System.out.println("1.姓名");
                    String j = scanner.nextLine();
                    System.out.println("2.专业");
                    String k = scanner.nextLine();
                    System.out.println("3.学号");
                    String l = scanner.nextLine();
                    MStudent mstudent = new MStudent();
                    mstudent.setName(j);
                    mstudent.setMajor(k);
                    mstudent.setSno(l);
                    if (mstudentMapper.findByAny(mstudent).size() == 0) {
                        System.out.println("没有该学生");
                    } else {
                        System.out.println("查询结果如下：");
                        List<MStudent> list = mstudentMapper.findByAny(mstudent);
                        for (MStudent mstudent1 : list) {
                            System.out.println(mstudent1);
                        }
                    }
                    break;
                case 2:
                    System.out.println("查询id小于5的信息：");
                    List<MStudent> list = mstudentMapper.findAll();
                    for (MStudent mstudent1 : list) {
                        if (mstudent1.getId() < 5) {
                            System.out.println(mstudent1);
                        }
                    }
                    break;
                default:
                    System.out.println("输入错误");
            }

        }
    }
}