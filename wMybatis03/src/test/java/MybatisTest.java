import cn.ipc.dao.userdao;
import cn.ipc.domain.User;
import cn.ipc.tool.MybatisUitl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void findallby() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapconfig.xml");
        SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = Builder.build(in);
        SqlSession sqlSession = factory.openSession();
        userdao dao = sqlSession.getMapper(userdao.class);
        User user = new User();
        user.setUsername("迪卡大");
        user.setSex("女");
        user.setId(45);
        dao.findall(user);
        sqlSession.commit();

        sqlSession.close();








    }


    /**
     * 注解查询带2级缓存
      * @throws Exception
     */
    @Test
    public void finducount() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapconfig.xml");
        SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = Builder.build(in);
        SqlSession sqlSession = factory.openSession();
        userdao dao = sqlSession.getMapper(userdao.class);
        List<User> users = dao.findbyusers();
        System.out.println(users);
        sqlSession.close();
        System.out.println("-------------------------------------------------");

        SqlSession sqlSession2 = factory.openSession();
        userdao dao2 = sqlSession2.getMapper(userdao.class);
        List<User> fus = dao2.findbyusers();
        System.out.println(fus);
        sqlSession2.close();
        in.close();
    }









}
