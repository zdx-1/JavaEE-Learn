package com.zdx.service;

import com.zdx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class test {
    static SqlSession sqlSession=null;

    public static void main(String[] args) {
//        读取配置文件，创建SqlSession，初始化SqlSession
        String resources ="mybatis-config.xml";
        Reader reader=null;
        try {
            reader= Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlMapper.openSession();
            System.out.println("---欢迎使用本系统！---");
            while (true){
                System.out.println("1.查询员工信息");
                System.out.println("2.添加员工信息");
                System.out.println("3.修改员工信息");
                System.out.println("4.删除员工信息");
                System.out.println("5.退出系统");
                System.out.print("请输入您的选项：");
                Scanner scanner=new Scanner(System.in);
                int i=scanner.nextInt();
                switch (i){
                    case 1:
                        System.out.println("查询所有员工信息还是根据id查询员工信息？");
                        System.out.println("请输入您的选项：");
                        System.out.println("1.查询员工信息");
                        System.out.println("2.查询所有员工信息");
                        int j=scanner.nextInt();
                        if (j==1){
                            System.out.print("请输入员工id：");
                            int id=scanner.nextInt();
                            Employee employee=sqlSession.selectOne("com.zdx.mapper.EmployeeMapper.findById",id);
                            System.out.println(employee);
                        }else {
                            List<Employee> list=sqlSession.selectList("com.zdx.mapper.EmployeeMapper.findAll");
                            for (Employee employee:list){
                                System.out.println(employee);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("添加员工信息");
                        System.out.print("请输入员工姓名：");
                        String name=scanner.next();
                        System.out.print("请输入员工年龄：");
                        int age=scanner.nextInt();
                        System.out.print("请输入员工职位：");
                        String position=scanner.next();
                        Employee employee = new Employee(1, name, age, position);
                        sqlSession.insert("com.zdx.mapper.EmployeeMapper.insert",employee);
                        sqlSession.commit();
                        System.out.println("添加成功");
                        break;
                    case 3:
                        System.out.println("修改员工信息");
                        System.out.print("请输入员工编号：");
                        int id=scanner.nextInt();
                        System.out.print("请输入员工姓名：");
                        String name1=scanner.next();
                        System.out.print("请输入员工年龄：");
                        int age1=scanner.nextInt();
                        System.out.print("请输入员工职位：");
                        String position1=scanner.next();
                        Employee employee1 = new Employee(id, name1, age1, position1);
                        sqlSession.update("com.zdx.mapper.EmployeeMapper.updateById",employee1);
                        sqlSession.commit();
                        System.out.println("修改成功");
                        break;
                    case 4:
                        System.out.println("删除员工信息");
                        System.out.print("请输入员工编号：");
                        int id1=scanner.nextInt();
                        sqlSession.delete("com.zdx.mapper.EmployeeMapper.deleteById",id1);
                        sqlSession.commit();
                        System.out.println("删除成功");
                        break;
                    case 5:
                        System.out.println("退出系统");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入有误，请重新输入！");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }











    }
}
