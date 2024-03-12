import com.example.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import java.io.*;

public class UserTest {
    @Test
    public void userFindByIdTest(){
        String resources="mybatis-config.xml";
        Reader reader=null;
        try{
            reader=Resources.getResourceAsReader(resources);
        }catch (IOException e){
            e.printStackTrace();
        }
     SqlSessionFactory sqlMapper =new SqlSessionFactoryBuilder().build(reader);
     SqlSession session =sqlMapper.openSession();
     User user=session.selectOne("findById",1);
     System.out.println(user.getUname());
     User user1=session.selectOne("findById",2);
     System.out.println(user1.getUname());
     session.close();
    }
}
