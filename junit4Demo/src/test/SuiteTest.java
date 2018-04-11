package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)//套件入口类
@Suite.SuiteClasses({TTest1.class,TTest2.class,TTest3.class})

public class SuiteTest {//必须是空类
/**
 * 组织测试类一起运行
 */
	
}
