package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.dao.UserDao;
import zhao.blog.managementsystem.entity.BlogUser;
import zhao.blog.managementsystem.service.UserService;
import zhao.blog.managementsystem.util.DateUtil;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<BlogUser> implements UserService {
	@Resource private UserDao userDaoImpl;
	
	public List<BlogUser> selectAll(){
		return userDaoImpl.selectAll();
	}

	@Override
	public boolean registUser(BlogUser user) {
		if (null == user || null == user.getUserAcc() || "".equals(user.getUserAcc()) || null == user.getUserName()
				|| "".equals(user.getUserName()) || null == user.getUserPwd() || "".contains(user.getUserPwd())
				|| null == user.getUserEmail() || "".equals(user.getUserEmail())) {
			return false;
		}
		if(null == user.getUserAddress() || "".equals(user.getUserAddress())){
			user.setUserAddress("未知");
		}
		if(null == user.getUserDescription() || "".equals(user.getUserDescription())){
			user.setUserDescription("暂无");
		}
		if(null == user.getUserBirthday() || "".equals(user.getUserBirthday())){
			user.setUserBirthday(DateUtil.getTime());
		}
		user.setUserRegisterTime(DateUtil.getTime());
		userDaoImpl.save(user);
		return true;
	}

	@Override
	public BlogUser login(BlogUser user) {
		List<BlogUser> accordUsers = userDaoImpl.selectByColumn("userAcc",user.getUserAcc());
		for (BlogUser blogUser : accordUsers) {
			if(blogUser.getUserPwd().equals(user.getUserPwd())){
				return blogUser;
			}
		}
		List<BlogUser> accordUsers2 = userDaoImpl.selectByColumn("userEmail",user.getUserEmail());
		for (BlogUser blogUser : accordUsers2) {
			if(blogUser.getUserPwd().equals(user.getUserPwd())){
				return blogUser;
			}
		}
		return null;
	}

	@Override
	public boolean nameIsExist(String userName) {
		List<BlogUser> users = userDaoImpl.selectByColumn("userName",userName);
		return users.size()>0;
	}

	@Override
	public boolean accIsExist(String userAcc) {
		List<BlogUser> users = userDaoImpl.selectByColumn("userAcc",userAcc);
		return users.size()>0;
	}

	@Override
	public boolean emailIsExist(String userEmail) {
		List<BlogUser> users = userDaoImpl.selectByColumn("userEmail",userEmail);
		return users.size()>0;
	}

	@Override
	public boolean chagePssword(String email, String newPwd) {
		List<BlogUser> users = select4PageByColumn(1,1,"userEmail", email);
		if(null!=users){
			BlogUser blogUser = users.get(0);
			blogUser.setUserPwd(newPwd);
			userDaoImpl.update(blogUser);
			return true;
		}
		return false;	
	}
}
