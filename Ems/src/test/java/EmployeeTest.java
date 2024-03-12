import com.zdx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class EmployeeTest {
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
    public void testSelectAll(){
        Employee employee=sqlSession.selectOne("com.zdx.mapper.EmployeeMapper.findAll");
        System.out.println(employee);
    }
    @Test
    public void testDelete(){
        Employee employee=new Employee(1,"张三",20,"manager");
        sqlSession.delete("com.zdx.mapper.EmployeeMapper.delete",employee);
    }
    @Test
    public void testInsert(){
        Employee employee=new Employee(1,"张三",20,"manager");
        sqlSession.insert("com.zdx.mapper.EmployeeMapper.insert",employee);
    }
    @Test
    public void testUpdate(){
        Employee employee=new Employee(1,"张三",20,"manager");
        sqlSession.update("com.zdx.mapper.EmployeeMapper.update",employee);
        System.out.println(employee.getName().toString());
    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
}
