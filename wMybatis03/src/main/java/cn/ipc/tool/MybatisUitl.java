package cn.ipc.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUitl {

        private static SqlSessionFactory build;
        //读取mybatis配置文件
    static {
            try {
                InputStream config = Resources.getResourceAsStream("sqlMapconfig.xml");
                // 创建session会话工厂
                 build = new SqlSessionFactoryBuilder().build(config);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * 创建SqlSession对象
     * @return
     */
    public static SqlSession createSqlSession(){
     return build.openSession(false);
    }

    /**
     * 关闭Session对象
     * @param session
     */
    public static void closeSqlSession(SqlSession session) {
        if (null != session) {
            session.close();
        }


    }

}
