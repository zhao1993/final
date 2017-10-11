package zhao.blog.managementsystem.util;

import javax.servlet.http.HttpSession;

import zhao.blog.managementsystem.entity.BlogUser;


public class UserUtil {
	public static void saveLoginUser(HttpSession session,BlogUser user){
		session.setAttribute("loginUser", user);
	}
	public static BlogUser getLoginUser(HttpSession session){
		if(session.getAttribute("loginUser")!=null){
			return (BlogUser) session.getAttribute("loginUser");
		}
		return null;
	}
}
