package zhao.blog.managementsystem.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.dto.DailyDTO;
import zhao.blog.managementsystem.service.DailyService;

@Controller
@RequestMapping("/daily")
public class DailyController {
	@Resource
	private DailyService dailyServiceImpl;
	@RequestMapping("/bui/daily")
	public ModelAndView query4bui() throws Exception{
		return new ModelAndView("bui/daily");
	}
	@ResponseBody
	@RequestMapping("/bui/dailys")
	public List<DailyDTO> query4load(
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize) throws Exception{
		return  dailyServiceImpl.select4Dto(pagenum, pagesize);
	}
}
