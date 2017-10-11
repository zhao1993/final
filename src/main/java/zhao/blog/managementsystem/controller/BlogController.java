package zhao.blog.managementsystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zhao.blog.managementsystem.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource BlogService blogServiceImpl;
	@RequestMapping("/bms/queryset4bms")
	public ModelAndView querySet4bms() throws Exception{
		return new ModelAndView("bms/system-setting");
	}
	
	@RequestMapping("/bui/queryset4bui")
	public ModelAndView querySet4bui() throws Exception{
		return new ModelAndView("bms");
	}
	@RequestMapping("/bui/index")
	public ModelAndView index() throws Exception{
		return new ModelAndView("bui/index");
	}
	@RequestMapping("/bui/test")
	public ModelAndView test(String url){
		return new ModelAndView(url);
	}
	
	//正式
	@RequestMapping("/bui/pigeonhole")
	public ModelAndView pigeonhole(){
		return new ModelAndView("bui/pigeonhole","piges",blogServiceImpl.initPigeOnHole());
	}
	//留言
	@RequestMapping("/bui/lams")
	public ModelAndView blog4Lams(){
		return new ModelAndView("bui/lam");
	}
	@RequestMapping("/bui/about")
	public ModelAndView blog4About(){
		return new ModelAndView("bui/about");
	}
}
