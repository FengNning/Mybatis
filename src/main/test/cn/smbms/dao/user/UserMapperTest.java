package cn.smbms.dao.user;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.smbms.pojo.Address;
import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class UserMapperTest {
	
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		int count = 0;
		SqlSession sqlSession = null;

			//1 获取mybatis-config.xml的输入流
			//2 创建SqlSessionFactory对象，完成对配置文件的读取
			//3 创建sqlSession
			sqlSession = MyBatisUtil.createSqlSeesion();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count---> " + count);

			MyBatisUtil.closeSqlSession(sqlSession);
	}
	@Test
	public void testGetUserList() {
		List<User>userList=null;
		SqlSession sqlSession=null;
		sqlSession=MyBatisUtil.createSqlSeesion();
		User user =new User();
		user.setUserName(null);
		user.setUserRole(3);
		userList=sqlSession.getMapper(UserMapper.class).getUserList(user);
		MyBatisUtil.closeSqlSession(sqlSession);
		for(User a:userList){
			logger.debug("名字是:"+a.getUserName()+" 职位:"+a.getUserRoleName()+" 年龄是:"+a.nl());
		}
	}

@Test
	public void testAdd(){

		SqlSession sqlSession=null;
		int  count=0;
		sqlSession=MyBatisUtil.createSqlSeesion();
		User user=new User();
		user.setUserCode("xiaofeng");
		user.setUserName("小峰");
		user.setUserPassword("1234567");
	Date birthday = null;
	try {
		birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
	} catch (ParseException e) {
		e.printStackTrace();
	}
	user.setBirthday(birthday);
		user.setCreationDate(new Date());
		user.setAddress("地址测试");
		user.setGender(1);
		user.setPhone("13688783697");
		user.setUserRole(1);
		user.setCreatedBy(1);
		user.setCreationDate(new Date());
		count=sqlSession.getMapper(UserMapper.class).add(user);
		sqlSession.commit();
		MyBatisUtil.closeSqlSession(sqlSession);
		logger.debug("结果"+count);
	}

	@Test
	public void update(){
		SqlSession sqlSession=null;
		int count=0;
		sqlSession=MyBatisUtil.createSqlSeesion();
		User user=new User();
		user.setId(26);
		user.setUserCode("testmodify");
		user.setUserName("测试用户修改");
		user.setUserPassword("0000000");
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1980-10-10");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setBirthday(birthday);
		user.setCreationDate(new Date());
		user.setAddress("地址测试修改");
		user.setGender(2);
		user.setPhone("13600002222");
		user.setUserRole(2);
		user.setModifyBy(1);
		user.setModifyDate(new Date());
		sqlSession = MyBatisUtil.createSqlSeesion();
		count = sqlSession.getMapper(UserMapper.class).update(user);
		sqlSession.commit();
		MyBatisUtil.closeSqlSession(sqlSession);
		logger.debug("结果"+count);
	}

	@Test
	public void delete(){
	    SqlSession sqlSession=null;
	    int count=0;
	    sqlSession=MyBatisUtil.createSqlSeesion();
	    count=sqlSession.getMapper(UserMapper.class).delete(33);
        sqlSession.commit();
	    MyBatisUtil.closeSqlSession(sqlSession);

	    logger.debug("结果"+count);
	}


	@Test
    public void getUserListByRoleId(){
	    SqlSession sqlSession=null;
	    List<User> userList = new ArrayList<>();
	    sqlSession=MyBatisUtil.createSqlSeesion();
	    userList=sqlSession.getMapper(UserMapper.class).getUserListByRoleId(3);
	    MyBatisUtil.closeSqlSession(sqlSession);
	    for(User u:userList){
	        logger.debug("名字:"+u.getUserName()+" 职位:"+u.getRole().getRoleName());
        }
    }

    @Test
    public void getAddressListByUserId(){
	    SqlSession sqlSession=null;
	    List<User>userList=new ArrayList<>();
	    sqlSession=MyBatisUtil.createSqlSeesion();
	    userList=sqlSession.getMapper(UserMapper.class).getAddressListByUserId(1);
	    MyBatisUtil.closeSqlSession(sqlSession);
	    for(User u:userList){
	        for(Address a:u.getAddressList()){
	            logger.debug("id:"+a.getId()+" contact:"+a.getContact());
            }
        }
    }

}

