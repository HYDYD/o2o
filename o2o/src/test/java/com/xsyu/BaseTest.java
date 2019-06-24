package com.xsyu;

/**
 * Created by HYDYD.
 * 2019/6/24 9:36
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit启动时加载ioc容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseTest { }
