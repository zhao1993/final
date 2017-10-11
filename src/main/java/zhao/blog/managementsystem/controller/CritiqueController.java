package zhao.blog.managementsystem.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhao.blog.managementsystem.dto.CritiqueDTO;
import zhao.blog.managementsystem.entity.BlogCritique;
import zhao.blog.managementsystem.service.CritiqueService;
import zhao.blog.managementsystem.util.UserUtil;

@Controller
@RequestMapping("/critique")
public class CritiqueController {
	@Resource
	private CritiqueService critiqueServiceImpl;
	
	@ResponseBody
	@RequestMapping("/bui/initreply")
	public List<CritiqueDTO> critique4Init(
			BlogCritique critique,
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize
			) throws Exception{
		return critiqueServiceImpl.selectByPage4Init(critique,pagenum,pagesize);
	}
	
	@ResponseBody
	@RequestMapping("/bui/deckreply")
	public List<CritiqueDTO> critique4Deck(
			BlogCritique critique
			) throws Exception{
		return critiqueServiceImpl.selectByPage4Deck(critique);
	}
	
	@ResponseBody
	@RequestMapping("/bui/addreply")
	public boolean critique4Add(
			BlogCritique critique,
			HttpSession session
			) throws Exception{
		critique.setBlogUser(UserUtil.getLoginUser(session));
		return critiqueServiceImpl.addCritique(critique);
	}
	
	
	@RequestMapping("/bui/index")
	public ModelAndView index() throws Exception{
		return new ModelAndView("bui/index");
	}
	@RequestMapping("/bui/test")
	public ModelAndView test(String url){
		return new ModelAndView(url);
	}
}
