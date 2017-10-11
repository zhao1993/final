/**
 * 
 */
package zhao.blog.managementsystem.service;

import zhao.blog.managementsystem.entity.BlogUser;

public interface UserService extends BaseService<BlogUser> {

	/**用户 注册业务
	 * @param user 保存用户数据的载体
	 * @return 是否注册成功
	 */
	boolean registUser(BlogUser user);

	/**尝试登录
	 * @param user [至少包含账号密码或者邮箱密码]
	 * @return bloguser则表示登录成功  null 则失败
	 */
	BlogUser login(BlogUser user);

	/**
	 * 根据名称判断是否存在用户名
	 * @param userName 需要进行判断的用户名
	 * @return 存在返回true 
	 */
	boolean nameIsExist(String userName);

	/**
	 * 根据账号判断是否存在账号
	 * @param userAcc 需要判断的账号
	 * @return 存在账号则返回true
	 */
	boolean accIsExist(String userAcc);

	/**判断邮箱是否已经被使用
	 * @param userEmail 需要判断的邮箱
	 * @return 存在邮箱则返回true
	 */
	boolean emailIsExist(String userEmail);

	/**
	 * 用户密码找回
	 * @param email 验证邮箱
	 * @param newPwd 新的密码
	 * @return 修改成功返回true
	 */
	boolean chagePssword(String email, String newPwd);
	
}
