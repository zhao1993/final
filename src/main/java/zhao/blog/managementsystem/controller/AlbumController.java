package zhao.blog.managementsystem.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.service.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {
	@Resource
	private AlbumService albumServiceImpl;
	@RequestMapping("/bui/albums")
	public ModelAndView query4bui() throws Exception{
		return new ModelAndView("bui/album","albums",albumServiceImpl.selectAll());
	}
	
}
