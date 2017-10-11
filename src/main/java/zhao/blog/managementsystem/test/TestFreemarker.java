package zhao.blog.managementsystem.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.entity.BlogUser;
@Controller
@RequestMapping("/test")
public class TestFreemarker {
	    @RequestMapping("/fmarker")
	    public ModelAndView Add(HttpServletRequest request,HttpServletResponse response){
	    	//控制器写法与普通写法一样
	        BlogUser user = new BlogUser();
	        user.setUserName("sg");
	        user.setUserPwd("1234");
	        List<BlogUser> users  = new ArrayList<BlogUser>();
	        users.add(user);
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("testFreemarker");
	        mv.addObject("users",users);
	        return mv;
	    }
}
