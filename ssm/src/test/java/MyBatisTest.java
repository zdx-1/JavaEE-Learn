import com.example.pojo.Customer;
import com.example.pojo.Student;
import com.example.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisTest {
   private SqlSessionFactory sqlSessionFactory;
   private SqlSession sqlSession;
   @Before
    public void init(){
       String resources ="mybatis-config.xml";
       Reader reader=null;
       try {
           reader= Resources.getResourceAsReader(resources);
           SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
           sqlSession=sqlMapper.openSession();

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    @Test
    public void findAllStudentTest(){
        List<Student> list=sqlSession.selectList("com.example.mapper.StudentMapper.findAllStudent");
        for (Student student:list){
            System.out.println(student);
        }
    }
    @Test
    public void addStudent(){
        sqlSession.insert("com.example.mapper.StudentMapper.addStudent");
        System.out.println("ok");
    }
    @Test
    public void addStudent1(){
        Student student=new Student();
        student.setName("local");
        student.setAge(10);
        int a = sqlSession.insert("com.example.mapper" + ".StudentMapper.addStudent", student);
        if (a!=0){
            System.out.println("true");
        }
    }
    @Test
    public void findCustomerByNameAndJobsTest(){
       SqlSession session = MyBatisUtils.getSession();
       Customer customer =new Customer();
       customer.setUsername("joy");
       customer.setJobs("teacher");
       List<Customer> customers=session.selectList("com.example.mapper"+".CustomerMapper.findCustomerByNameAndJobs",customer);
       for (Customer customer1:customers){
           System.out.println(customer1);
       }
    }
    @After
    public void destory(){
       sqlSession.commit();
       sqlSession.close();
    }
}
