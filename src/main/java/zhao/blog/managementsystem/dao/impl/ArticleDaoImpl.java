package zhao.blog.managementsystem.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.ArticleDao;
import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.entity.BlogArticle;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<BlogArticle> implements ArticleDao {

	@Override
	public List<Object[]> queryGroup(String groupStr) {
		String hql = new StringBuffer("select ")
				.append(groupStr)
				.append(" from BlogArticle where ")
				.append(groupStr).append(" is not null ")
				.append("group by ")
				.append(groupStr).toString();
		return super.selectCriteria4Object(hql);
	}

	@Override
	public List<BlogArticle> hotLists() {
		String hql = "from BlogArticle order by articleClick desc";
		return super.select4PageByCriteria(1,8, hql);
	}

	@Override
	public List<BlogArticle> supportLists() {
		String hql = "from BlogArticle where articleSupport = 1";
		return super.select4PageByCriteria(1,8, hql);
	}

	@Override
	public BlogArticle articlePre(int articleId) {
		String hql = "from BlogArticle where articleId < ? order by articleId desc";
		return (BlogArticle) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, articleId).setMaxResults(1).uniqueResult();
	}

	@Override
	public BlogArticle articleNext(int articleId) {
		String hql = "from BlogArticle where articleId > ? order by articleId asc";
		return (BlogArticle) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, articleId).setMaxResults(1).uniqueResult();
	}

	@Override
	public List<PigeOnHoleDTO> select4PigeOnHole() {
		String hql = "select articleId,articleTime,articleTitle from BlogArticle";
		List<Object[]> selectCriteria4Object = selectCriteria4Object(hql);
		ArrayList<PigeOnHoleDTO> piges = new ArrayList<PigeOnHoleDTO>();
		for (Object[] object : selectCriteria4Object) {
				PigeOnHoleDTO pdto = new PigeOnHoleDTO();
				pdto.setdId((int)object[0]);
				pdto.setCreateTime(new Date(Long.parseLong((String) object[1])));
				pdto.setpTitle((String) object[2]);
				pdto.setDtype((byte)0);
				piges.add(pdto);
		}
		return piges;
	}

	@Override
	public int dataCountBySearch(String search) {
		String hql = "from BlogArticle where articleTitle like ? or articleContent like ?";
		return selectCriteria4Entity(hql, "%"+search+"%","%"+search+"%").size();
	}

	@Override
	public List<BlogArticle> select4PageBySearch(int pagenum, int pagesize, String search) {
		String hql = "from BlogArticle where articleTitle like ? or articleContent like ?";
		return select4PageByCriteria(pagenum, pagesize, hql,"%"+search+"%","%"+search+"%");
	}
	
	
/*
	@Override
	public List<BlogArticle> select4PageByType(String type, int firstresult, int maxresult) {
		String hql = "from BlogArticle where blogSortArticle.sortArticleName = ?";
		return select4PageByCriteria(firstresult, maxresult, hql, type);
	}

	@Override
	public int dataCountByType(String type) {
		String hql = "select count(articleId) from BlogArticle where blogSortArticle.sortArticleName = ?";
		return (int)(long) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,type).setMaxResults(1).uniqueResult();
	}
	*/
	
}
