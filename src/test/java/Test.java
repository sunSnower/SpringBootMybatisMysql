import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void queryCountTest(){
        SqlSession sqlSession = null;

        try{
            InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
            sqlSession = sqlSessionFactory.openSession();
            int n = sqlSession.selectOne("dao.TuserMapper.queryCount");
            System.out.println(n);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args){
        queryCountTest();
    }
}
