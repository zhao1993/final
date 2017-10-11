package zhao.blog.managementsystem.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.dao.ArticleDao;
import zhao.blog.managementsystem.dao.SortArticleDao;
import zhao.blog.managementsystem.entity.BlogArticle;
import zhao.blog.managementsystem.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<BlogArticle> implements ArticleService {
	@Resource
	private ArticleDao articleDaoImpl;
	@Resource
	private SortArticleDao sortArticleDaoImpl;
	public List<BlogArticle> selectAll(){
		return  articleDaoImpl.selectAll();
	}

	@Override
	public List<Object[]> queryType() {
		return articleDaoImpl.queryGroup("type");
	}


	@Override
	public List<BlogArticle> hotLists() {
		
		return articleDaoImpl.hotLists();
	}

	@Override
	public List<BlogArticle> supportLists() {
		
		return articleDaoImpl.supportLists();
	}

	@Override
	public BlogArticle articlePre(int articleId) {
		return articleDaoImpl.articlePre(articleId);
	}

	@Override
	public BlogArticle articleNext(int articleId) {
		return articleDaoImpl.articleNext(articleId);
	}

	@Override
	public int allPageByType(String type, Integer pagesize) {
		if(sortArticleDaoImpl.dataCountByCriteria("sortArticleName", type)>0){
			return allPageByCriteria("blogSortArticle.sortArticleName", type, pagesize);
		}
		return allPage(pagesize);
	}
	private ArrayList<BlogArticle> o2nArticleList(List<BlogArticle> oldArticles) {
		ArrayList<BlogArticle> arrayList = new ArrayList<BlogArticle>();
		for (BlogArticle blogArticle : oldArticles) {
			int length = blogArticle.getArticleContent().length();
			BlogArticle ba = blogArticle;
			ba.setArticleContent(blogArticle.getArticleContent().substring(0,length>200?200:length));
			arrayList.add(ba);
		}
		return arrayList;
	}
	@Override
	public List<BlogArticle> select4Page(Integer pagenum, Integer pagesize) {
		List<BlogArticle> oldArticles = super.select4Page(pagenum, pagesize);
		ArrayList<BlogArticle> arrayList = o2nArticleList(oldArticles);
		return arrayList;
	}

	@Override
	public List<BlogArticle> select4ByType(String type, Integer pagenum, Integer pagesize) {
		if(sortArticleDaoImpl.dataCountByCriteria("sortArticleName", type)>0){
			List<BlogArticle> oldArticles = select4PageByColumn(pagenum, pagesize, "blogSortArticle.sortArticleName", type);
			ArrayList<BlogArticle> arrayList = o2nArticleList(oldArticles);
			return arrayList;
		}
		return this.select4Page(pagenum, pagesize);
	}

	@Override
	public List<BlogArticle> select4BySearch(String search, Integer pagenum, Integer pagesize) {
		if(null==pagesize || pagesize<1){
			pagesize = Common.DEFAULT_PAGE_SIZE;
		}
		int all_page = this.allPageBySearch(search,pagesize);
		if(null==pagenum || pagenum<1){
			pagenum = Common.DEFAULT_PAGE_NOW;
		}
		if(all_page < pagenum){
			pagenum = all_page;
		}
		if(all_page==0)
		return null;
		List<BlogArticle> oldArticles = articleDaoImpl.select4PageBySearch((pagenum-1)*pagesize,pagesize, search);
		ArrayList<BlogArticle> arrayList = o2nArticleList(oldArticles);
		return arrayList;
	}

	@Override
	public int allPageBySearch(String search, Integer pagesize) {
		int count = articleDaoImpl.dataCountBySearch(search);
		if(null==pagesize || pagesize<1){
			pagesize= Common.DEFAULT_PAGE_SIZE;	
		}
		return count%pagesize==0?count/pagesize:count/pagesize+1;
	}	
	
}
