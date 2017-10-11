package zhao.blog.managementsystem.test;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.entity.BlogUser;
import zhao.blog.managementsystem.service.UserService;

@Controller
public class C1708 {
	@Resource
	private UserService userServiceImpl;
	@RequestMapping("/1708")
	public ModelAndView to1708(){
		return new ModelAndView("1708","users",userServiceImpl.selectAll());
	}
	@RequestMapping("/save1708")
	public String	 save1708(Users users){
			for (BlogUser user : users.getUser()) {
				System.out.println(".......");
				BlogUser user1 = new BlogUser(100, "座位表信息", "0", "0", "1", "男", "1", "1", "1", "1", "1", "1", "1");
				user1.setUserAcc(user.getUserAcc());
				user1.setUserPwd(user.getUserPwd());
				userServiceImpl.save(user1);
			}
		return "redirect:1708";
	}
}
