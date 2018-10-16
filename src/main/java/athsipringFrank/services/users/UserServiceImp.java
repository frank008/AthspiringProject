package athsipringFrank.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServie {

	@Autowired
	
	private JdbcTemplate JdbcTemplate;
	@Override
	public void add(String username, String password) {
		
		String sql="insert into user(username,password) values("+username+","+password+")";
		int result = JdbcTemplate.update(sql);
		if (result>0) {
			System.out.println("用户插入成功");
		}
	}

	@Override
	public void deleteByName(String username) {
		String sql="delete user where  username='"+username+"'";
		int result = JdbcTemplate.update(sql);
		if (result>0) {
			System.out.println("删除用户成功");
			
		}

	}

	@Override
	public Integer getUserCount() {
		
		String sql="selcet count(1) from user ";
		return 	JdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void queryUser(String name, String password) {
	String sql="select  username from user where  username='"+name+"' and  password='"+password+"";
	int result = JdbcTemplate.update(sql);
	if (result>0) {
		System.out.println("查询成功");
	}
	}

	@Override
	public void queryEmail(String email) {
		String sql="select  username from user where email='"+email+"' ";
		int result = JdbcTemplate.update(sql);
		if (result>0) {
			System.out.println("查询email成功");
		}

	}

	@Override
	public void queryPhone(String phone) {
		String sql="select  username from user where phone='"+phone+"' ";
		int result = JdbcTemplate.update(sql);
		if (result>0) {
			System.out.println("查询email成功");
		}
	

	}

}
