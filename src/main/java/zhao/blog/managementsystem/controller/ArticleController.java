package zhao.blog.managementsystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.service.ArticleService;
import zhao.blog.managementsystem.service.SortArticleService;


@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private ArticleService articleServiceImpl;
	@Resource
	private SortArticleService sortArticleServiceImpl;
	
	/*@RequestMapping("/bui/article")
	public ModelAndView query4bui(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize
			){
		ModelAndView modelAndView = new ModelAnd	View("redirect:/article/bui/encrypt/article");
		modelAndView.addObject("type", type);
		modelAndView.addObject("pagenum", pagenum);
		modelAndView.addObject("pagesize", pagesize);
		return modelAndView;
	}*/
	@RequestMapping("/bui/article")
	public ModelAndView query4bui(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize,
			HttpSession session
			) throws Exception{
			session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
			ModelAndView modelAndView = new ModelAndView("bui/article");
			if(null!=type && !"".equals(type)){
				modelAndView.addObject("articles", articleServiceImpl.select4ByType(type,pagenum,pagesize));
				modelAndView.addObject("maxPage", articleServiceImpl.allPageByType(type,pagesize));
				modelAndView.addObject("articleType", type);
			}else{
				modelAndView.addObject("articles", articleServiceImpl.select4Page(pagenum, pagesize));
				modelAndView.addObject("maxPage", articleServiceImpl.allPage(pagesize));
			}
			hotAndSupport(modelAndView);
			return modelAndView;
		}
	/*@RequestMapping("/bui/index")
	public ModelAndView query4indexbefore(
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize){
			ModelAndView modelAndView = new ModelAndView("redirect:/article/bui/encrypt/index");
			modelAndView.addObject("pagenum", pagenum);
			modelAndView.addObject("pagesize", pagesize);
			return modelAndView;
	}*/
	
	@RequestMapping("/bui/index")
	public ModelAndView query4index(
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize,
			HttpSession session
			) throws Exception{
		session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
		ModelAndView modelAndView = new ModelAndView("bui/index");
		modelAndView.addObject("articles", articleServiceImpl.select4Page(pagenum, pagesize));
		modelAndView.addObject("maxPage", articleServiceImpl.allPage(pagesize));
		hotAndSupport(modelAndView);
		return modelAndView;
	}
	
	
	/*@RequestMapping("/bui/articleDetail")
	public ModelAndView query4indexbefore(
			@RequestParam(required = true) short articleId
			){
		ModelAndView modelAndView = new ModelAndView("redirect:/article/bui/encrypt/articleDetail");
		modelAndView.addObject("articleId", articleId);
		return modelAndView;
	}*/
			
	@RequestMapping("/bui/articleDetail")
	public ModelAndView query4index(
			@RequestParam(required = true) short articleId
			) throws Exception{
		ModelAndView modelAndView = new ModelAndView("bui/article-detail");
		modelAndView.addObject("article", articleServiceImpl.selectById(articleId));
		modelAndView.addObject("apre", articleServiceImpl.articlePre(articleId));
		modelAndView.addObject("anext", articleServiceImpl.articleNext(articleId));
		hotAndSupport(modelAndView);
		return modelAndView;
	}	
	
	private void hotAndSupport(ModelAndView modelAndView) {
		modelAndView.addObject("hotlists", articleServiceImpl.hotLists());
		modelAndView.addObject("supportlists", articleServiceImpl.supportLists());
	}
	
	@RequestMapping("/bui/search")
	public ModelAndView query4index(
		@RequestParam(required = false) String search,
		@RequestParam(required = false) Integer pagenum,
		@RequestParam(required = false) Integer pagesize,
		HttpSession session
		) throws Exception{
		session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
		ModelAndView modelAndView = new ModelAndView("bui/article");
		if(null!=search && !"".equals(search)){
			modelAndView.addObject("articles", articleServiceImpl.select4BySearch(search,pagenum,pagesize));
			modelAndView.addObject("maxPage", articleServiceImpl.allPageBySearch(search,pagesize));
			modelAndView.addObject("search", search);
		}else{
			modelAndView.addObject("articles", articleServiceImpl.select4Page(pagenum, pagesize));
			modelAndView.addObject("maxPage", articleServiceImpl.allPage(pagesize));
		}
		hotAndSupport(modelAndView);
		return modelAndView;
	}	
	
	
	
	
	
	/*@RequestMapping("/bms/toadd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView("bms/article-manage-add-edit");
		modelAndView.addObject("types", sortArticleServiceImpl.selectAll());
		return modelAndView;
	}

	@RequestMapping("/bms/add")
	public ModelAndView add(BlogArticle article, @RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		if (null != file.getFileItem().getString() && !"".equals(file.getFileItem().getString()))
		{
			article.setArticePic(FileUtil.UpLoad(request, file, FolderAndFile.ARTICLE_FOLDER));
		}
		else{
			//这里准备用默认文章配图路径
			article.setArticePic(articleServiceImpl.selectById(article.getArticleId()).getArticePic());
		}
		article.setArticleTime(DateUtil.getTime());
		articleServiceImpl.save(article);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/bms/delete")
	public ModelAndView delete(String ids, HttpSession session) throws Exception {
		articleServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/bms/toupdate")
	public ModelAndView query4Update(int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("bms/article-manage-add-edit");
		modelAndView.addObject("types", articleServiceImpl.queryType());
		modelAndView.addObject("article", articleServiceImpl.selectById(id));
		return modelAndView;
	}

	@RequestMapping("/bms/update")
	public ModelAndView update(@ModelAttribute("form") BlogArticle article, @RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		if (null != file.getFileItem().getString() && !"".equals(file.getFileItem().getString())){
			article.setArticePic(FileUtil.UpLoad(request, file, FolderAndFile.ARTICLE_FOLDER));
		}
		else{
			article.setArticePic(articleServiceImpl.selectById(article.getArticleId()).getArticePic());
		}
		//article.setArticleTime(articleServiceImpl.selectById(article.getArticleId()).getArticleTime());
		articleServiceImpl.update(article);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/bms/query")
	public ModelAndView query(@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize, HttpSession session) throws Exception {
		session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/article-manage");
		modelAndView.addObject("articles", articleServiceImpl.select4Page(pagenum, pagesize));
		modelAndView.addObject("maxPage", articleServiceImpl.allPage(pagesize));
		return modelAndView;
	}

	@RequestMapping("/bms/queryimage")
	public void queryImage(String image, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("content-Disposition", "filename=" + FileUtil.opDownloadFileName(image, request));
		String realPath = FileUtil.getRealPath(FolderAndFile.ARTICLE_FOLDER, request);
		OutputStream outputStream = response.getOutputStream();
		FileUtils.copyFile(new File(realPath, image), outputStream);
		outputStream.close();
	}
	
	@ResponseBody
	@RequestMapping("bui/addreply")
	public boolean add(HttpServletRequest request, Integer cid,Integer aid,String val){
		return articleServiceImpl.addCritique(cid,aid,2,val,CritiqueType.ARTICLE);
	}
	
	//前端回复
	前端请求用
	@ResponseBody
	@RequestMapping("/bui/initreply")
	public List<Map<String,Object>> init(Object data,
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize){
		List<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		List<Critique> list = critiqueServiceImpl.selectByPage4Init(pagenum, pagesize);
		for (Critique critique : list) {
			User user = critique.getUser();
			Map<String, Object> bean2Map = BeanUtil.bean2Map(critique, "user","critiques","critique");
			bean2Map.put("userid",user.getId());
			bean2Map.put("username",user.getName());
			bean2Map.put("userimg",user.getHeadpic());
			arrayList.add(bean2Map);
		}
		return arrayList;
	}
	@ResponseBody
	@RequestMapping("bui/deckreply")
	public List<Map<String,Object>> deck(Integer id){
		List<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		List<BlogCritique> list = critiqueServiceImpl.selectCritiquesByDeck(id);
		for (BlogCritique critique : list) {
			BlogUser user = critique.getUser();
			Map<String, Object> bean2Map = BeanUtil.bean2Map(critique, "user","critiques","critique");
			bean2Map.put("userid",user.getId());
			bean2Map.put("username",user.getName());
			bean2Map.put("userimg",user.getHeadpic());
			arrayList.add(bean2Map);
		}
		return arrayList;
	}
	
	public List<Map<String,Object>> replys(){
		return null;}
	*/
}
