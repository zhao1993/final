package zhao.blog.managementsystem.service;

import java.util.List;

import zhao.blog.managementsystem.entity.BlogArticle;

public interface ArticleService extends BaseService<BlogArticle> {
	/**
	 * 查询文章的分类信息
	 * @return 返回文章分类集合
	 */
	public List<Object[]> queryType();

	public List<BlogArticle> hotLists();

	public List<BlogArticle> supportLists();

	public BlogArticle articlePre(int articleId);

	public BlogArticle articleNext(int articleId);

	public int allPageByType(String type, Integer pagesize);

	public List<BlogArticle> select4ByType(String type, Integer pagenum, Integer pagesize);

	public List<BlogArticle> select4BySearch(String search, Integer pagenum, Integer pagesize);

	public int allPageBySearch(String search, Integer pagesize);

}
