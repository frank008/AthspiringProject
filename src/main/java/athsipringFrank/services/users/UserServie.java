package athsipringFrank.services.users;

import athsipringFrank.dao.User;

public interface UserServie {

	/* (non-Javadoc)   添加用户
	 * @see athsipringFrank.services.users.UserServie#add(java.lang.String, java.lang.String)
	 */
	int add(User user);

	int deleteByName(String username);

	Integer getUserCount();
	
	User   queryUser( String username,String password);
}