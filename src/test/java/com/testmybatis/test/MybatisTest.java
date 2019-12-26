package com.testmybatis.test;

import com.test.dao.IUserDao;
import com.test.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.util.Resources;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * zl
 * 2019/12/25
 **/
public class MybatisTest {

    private  InputStream in;
    private  SqlSession sqlSession;
    private  IUserDao userDao;


    @Before//测试方法之前执行
    public void init()throws Exception {
        //1.读取配置文化
        in = Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂创建SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }


    @After//测试方法之后执行
    public void destroy()throws Exception{
        //6.释放资源
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("lili");
        user.setAddress("beijing");
        user.setSex("男");
        user.setBirthday(new Date());

        //5.使用代理对象执行方法
        userDao.saveUser(user);

        //提交事务
        sqlSession.commit();
    }

//    public static void main(String[] args)throws Exception {
//        //1.读取配置文化
//        InputStream in = Resources.class.getResourceAsStream("/SqlMapConfig.xml");
//        //2.创建SqlSessionFactory
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂创建SqlSession对象
//        SqlSession session = factory.openSession();
//        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao userDao = session.getMapper(IUserDao.class);
//        //5.使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for (User user : users){
//            System.out.println(user);
//        }
//        //6.释放资源
//        session.close();
//        in.close();
//    }
}
