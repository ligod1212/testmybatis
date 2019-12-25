package com.test.domain;

import com.test.dao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.security.util.Resources;

import java.io.InputStream;
import java.util.List;

/**
 * zl
 * 2019/12/25
 **/
public class MybatisTest {
    public static void main(String[] args)throws Exception {
        //1.读取配置文化
        InputStream in = Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
