package com.suhang.springmvc.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suhang.springmvc.po.User;

/**
 * @author hang.su
 * @since 2017-09-28 10:06
 */
public class UserMapperTest {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext= new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

    @Test
    public void findUserByIdTest() throws Exception {
        UserMapper usermapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = usermapper.findUserById(1);
        System.out.println(user.getUsername());
    }
}
