package zhao.blog.managementsystem.dao;

import java.util.List;

import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.entity.BlogArticle;

public interface ArticleDao extends BaseDao<BlogArticle> {

	/**
	 * 根据指定的字段（类属性）查询 出一个分组集合
	 * 
	 * @param groupStr
	 *            指定的属性
	 * @return 返回数据中的指定属性所有结果集合
	 */
	List<Object[]> queryGroup(String groupStr);

	/**
	 * @return 返回点击最高的文章且最多8条数据
	 */
	List<BlogArticle> hotLists();

	/**
	 * @return 返回推荐文章最高8条数据
	 */
	List<BlogArticle> supportLists();
	
	/**
	 * 根据id获取上一篇文章 信息
	 * @param articleId  文章的id
	 * @return 上一篇文章的信息
	 */
	BlogArticle articlePre(int articleId);

	/**
	  * 根据id获取下一篇文章 信息
	 * @param articleId  文章的id
	 * @return 下一篇文章的信息
	 */
	BlogArticle articleNext(int articleId);

	/**
	 * 归档查询
	 * @return
	 */
	List<PigeOnHoleDTO> select4PigeOnHole();

	/**根据搜索内容获取搜索到的条数
	 * @param search 搜索内容
	 * @return 条数
	 */
	int dataCountBySearch(String search);

	/**
	 * 搜索内容
	 * @param pagenum 当前页码
	 * @param pagesize 每页显示数量
	 * @param search 搜索内容
	 * @return 
	 */
	List<BlogArticle> select4PageBySearch(int pagenum, int pagesize, String search);

}
