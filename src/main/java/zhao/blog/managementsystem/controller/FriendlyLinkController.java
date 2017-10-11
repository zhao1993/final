package zhao.blog.managementsystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.entity.BlogFriendlyLink;
import zhao.blog.managementsystem.entity.BlogUser;
import zhao.blog.managementsystem.service.FriendlyLinkService;
import zhao.blog.managementsystem.util.UserUtil;

@Controller
@RequestMapping("/link")
public class FriendlyLinkController {
	@Resource
	private FriendlyLinkService friendlyLinkServiceImpl;
	
	@ResponseBody
	@RequestMapping("/bui/all")
	public List<BlogFriendlyLink> query4bui() throws Exception{
		return friendlyLinkServiceImpl.selectAll();
	}
	//申请
	@RequestMapping("/bui/apply")
	public ModelAndView query2apply(HttpSession session ,BlogFriendlyLink link) throws Exception{
		BlogUser loginUser = UserUtil.getLoginUser(session);
		ModelAndView modelAndView = new ModelAndView("redirect:/link/bui/toapply");
		if(loginUser!=null){
			friendlyLinkServiceImpl.applyLink(loginUser,link);
			modelAndView.addObject("mg", "申请已经提交,将尽快处理!");
		}else{
			modelAndView.addObject("mg","请先登录!");
		}
		return modelAndView;
	}
	//去申请
	@RequestMapping("/bui/toapply")
	public ModelAndView query4apply(String mg) throws Exception{
		return new ModelAndView("bui/apply-link","msg",mg);
	}
	@ResponseBody
	@RequestMapping("/bui/existurl")
	public boolean existUrl(String linkUrl) throws Exception{
		if(friendlyLinkServiceImpl.isExistUrl(linkUrl)){
			return false;
		};
		return true;
	}
	
}
