package athsipringFrank.services.users;

public interface UserServie {
	

/**新增一个用户
 * @param username
 * @param password
 */
void  add(String username,String password);

/**根据用户名删除用户
 * @param username
 */
void deleteByName(String username);

/** 获取用户总数
 * @return
 */
Integer getUserCount();

/** 查询用户信息
 * @param name
 * @param password
 */
void queryUser(String name,String password);


/** 查询用户邮箱
 * @param email
 */
void queryEmail(String email);


/**查询用户电话
 * @param phone
 */
void queryPhone(String  phone);
}
