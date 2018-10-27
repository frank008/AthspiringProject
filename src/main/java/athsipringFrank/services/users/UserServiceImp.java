package athsipringFrank.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import athsipringFrank.dao.User;

@Service
public class UserServiceImp implements UserServie   {


	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	/* (non-Javadoc)   添加用户
	 * 
	 */
	@Override
	public int add(User user) {
		String sql="insert into user(username,password,email,phone,companyName) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getPhone()+"','"+user.getCompany()+"')";
		System.out.println(sql);
		int result = JdbcTemplate.update(sql);
		
		return result;
		
	}

	/* (non-Javadoc)
	 *  根据用户名删除用户
	 */
	@Override
	public int deleteByName(String username) {
		String sql="delete from  user where  username='"+username+"'";
		int result = JdbcTemplate.update(sql);
		return result;
	}

	/* (non-Javadoc)
	 * 获取总记录数
	 */   
	@Override
	public Integer getUserCount() {
		
		String sql="selcet count(1) from user ";
		return 	JdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/** 登录查询
	 * @param username
	 * @param password
	 * @return
	 */
	public   User   queryUser( String username,String password) {
		String  sql="select  *from user where username='"+username+"' and  password='"+password+"' ";
		User user = null;
		try {
			UserRowMapper userRowMapper = new UserRowMapper();
			user = (User) JdbcTemplate.queryForObject(sql, userRowMapper);
			
		}catch (Exception e) {
		}
		return user;
	}

	}




