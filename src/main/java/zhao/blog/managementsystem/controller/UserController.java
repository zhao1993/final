package zhao.blog.managementsystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.entity.BlogUser;
import zhao.blog.managementsystem.service.UserService;
import zhao.blog.managementsystem.util.EmailUtil;
import zhao.blog.managementsystem.util.UserUtil;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userServiceImpl;

	
	@RequestMapping("/bui/toregist")
	public String toRegist(){
		return "bui/regist";
	}
	@RequestMapping("/bui/forget")
	public ModelAndView toRegist(HttpSession session){
		String step = String.valueOf(session.getAttribute("step"));
		if(step == null){
			 session.setAttribute("step","1");
		}
		if("4".equals(step)){
			session.removeAttribute("step");
			return new ModelAndView("bui/forget-pwd","step",4);
		}
		else if(session.getAttribute("yzEmail")==null && !"1".equals(step)){
			session.setAttribute("step","1");
		}
		return new ModelAndView("bui/forget-pwd");
	}
	
	@RequestMapping("/bui/forget4step")
	public ModelAndView toForget(HttpSession session,String userEmail,String yzCode,String newPwd){
		String step = String.valueOf(session.getAttribute("step"));
		if("1".equals(step) && userEmail!=null){
				//发邮件...................
				String gyzCode = EmailUtil.yzCode();
				session.setAttribute("yzCode",gyzCode);
				session.setAttribute("yzEmail", userEmail);
				EmailUtil.sendEmail("", userEmail, "测试密码找回", "你的验证码如下", gyzCode);
				session.setAttribute("step", 2);
				return new ModelAndView("redirect:/user/bui/forget");
		}
		else if("2".equals(step)){
			if(yzCode!=null && yzCode.equals(session.getAttribute("yzCode"))){
				session.setAttribute("step", 3);
				return new ModelAndView("redirect:/user/bui/forget");
			}else{
				session.setAttribute("step", 2);
				return new ModelAndView("bui/forget-pwd","msg", "验证码错误!");
			}
		}
		else if("3".equals(step)){
			if(newPwd!=null){
				//修改密码
				String email = (String) session.getAttribute("yzEmail");
				userServiceImpl.chagePssword(email,newPwd);
				session.removeAttribute("yzCode");
				session.removeAttribute("yzEmail");
				session.setAttribute("step", 4);
				return new ModelAndView("redirect:/user/bui/forget");
			}
		}
		return new ModelAndView("redirect:/user/bui/forget");
	}
	@RequestMapping("/bui/forgetstep2")
	public String toForget(String validatEmail){
		
		return "bui/forget-pwd";
	}
	@ResponseBody
	@RequestMapping("/bui/login")
	public boolean login(HttpSession session,
			BlogUser user){
			BlogUser loginUser  = userServiceImpl.login(user);
			if(null!=loginUser){
				UserUtil.saveLoginUser(session, loginUser);
				return true;
		}
		return false;
	}
	@RequestMapping("/bui/register")
	public String regist(@ModelAttribute BlogUser user){
			if(userServiceImpl.registUser(user)){
				return "bui/regist-success";
			}else{
				return "bui/regist-failed";
			}
		//注册成功完成自动登录?
	}
	/*Ajax验证区*/
	@ResponseBody
	@RequestMapping("/bui/nexist")
	public boolean validateNameIsExist(String userName){
		if(userServiceImpl.nameIsExist(userName)){
			return false;
		}
		return true;
	}
	@ResponseBody
	@RequestMapping("/bui/aexist")
	public boolean validateAccIsExist(String userAcc){
		if(userServiceImpl.accIsExist(userAcc)){
			return false;
		}
		return true;
	}
	@ResponseBody
	@RequestMapping("/bui/eexist")
	public boolean validateEmailIsExist(String userEmail){
		if(userServiceImpl.emailIsExist(userEmail)){
			return false;
		}
		return true;
	}
	@ResponseBody
	@RequestMapping("/bui/yeexist")
	public boolean validateHasEmail(String userEmail){
		if(userServiceImpl.emailIsExist(userEmail)){
			return true;
		}
		return false;
	}
	
	@ResponseBody
	@RequestMapping("/bui/hasuser")
	public boolean hasUserLogin(HttpSession session, String userEmail){
		if(UserUtil.getLoginUser(session)!=null){
			return true;
		}
		return false;
	}
	
	public static String getIp2(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(null!=ip && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(null!=ip && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }	
	
	/*@RequestMapping("/bms/all")
	public ModelAndView selectAll(){
		return new ModelAndView("bms/user-manage","userslist", userServiceImpl.selectAll());
	}
	
	@RequestMapping("/bms/delete")
	public ModelAndView delete(String ids,HttpSession session){
		userServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum",session.getAttribute("nowPage"));
		return modelAndView;
	}
	
	@RequestMapping("/bms/toupdate")
	public ModelAndView query4Update(short id){
		return new ModelAndView("bms/user-manage-edit","user",userServiceImpl.selectById(id));
	}
	
	@RequestMapping("/bms/update")
	public ModelAndView update(@ModelAttribute("form") BlogUser user,HttpSession session){
		userServiceImpl.update(user);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}
	
	@RequestMapping("/bms/query")
	public ModelAndView query(
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize,
			HttpSession session){
		session.setAttribute("nowPage",null==pagenum||pagenum<1?Common.DEFAULT_PAGE_NOW:pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/user-manage");
		modelAndView.addObject("userslist",userServiceImpl.select4Page(pagenum, pagesize));
		modelAndView.addObject("maxPage",userServiceImpl.allPage(pagesize));
		return modelAndView;
	}*/
}
