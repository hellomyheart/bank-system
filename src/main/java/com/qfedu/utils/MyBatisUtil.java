package com.qfedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @description
 * @className: MyBatisUtil
 * @package: com.qfedu.utils
 * @author: Stephen Shen
 * @date: 2020/9/3 上午11:40
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory = null;

    static {

        try {
            //1.读取配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //2.创建sqlsessionFactory的对象
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return factory.openSession();
    }
}
