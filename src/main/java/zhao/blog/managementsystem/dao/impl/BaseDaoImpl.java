package zhao.blog.managementsystem.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.BaseDao;
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	protected Class<T> clazz;
	protected String simpleName;
	@Autowired
	protected SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			this.clazz = (Class<T>) types[0];
			simpleName = this.clazz.getSimpleName();
		}
	}
	/**
	 * @return the clazz
	 */
	public Class<T> getClazz() {
		return clazz;
	}
	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
		flush();
	}

	@Override
	public void saveAll(List<T> ts) {
		for (T t : ts) this.save(t);
	}

	@Override
	public void deleteById(int id) {
		sessionFactory.getCurrentSession().delete(this.selectById(id));
		flush();
	}

	@Override
	public void deleteByIds(int... ids) {
		for (int id : ids) {
			this.deleteById(id);
		}
	}
	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().merge(t);
		flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T selectById(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+simpleName).list();
	}
	
	@Override
	public List<T> selectByColumn(String column, String value) {
		String hql = new StringBuffer("From ") .append(simpleName) .append(" where ") .append(column) .append("= ?").toString();
		return selectCriteria4Entity(hql,value); 
	}
	
	
	@Override
	public List<T> select4PageByColumn(int firstResult, int maxResult, String column, String value) {
		String hql = new StringBuffer("From ") .append(simpleName) .append(" where ") .append(column) .append("= ?").toString();
		return select4PageByCriteria(firstResult, maxResult, hql, value);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectCriteria4Entity(String queryString, Object... parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		for (int i = 0; i < parameters.length; i++) 
			query.setParameter(i, parameters[i]);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectCriteria4Object(String queryString, Object... parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		for (int i = 0; i < parameters.length; i++) 
			query.setParameter(i, parameters[i]);
		return query.list();
	}
	@Override
	public List<T> select4Page(int firstResult, int maxResult) {
		return select4PageByCriteria(firstResult, maxResult, "FROM "+simpleName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> select4PageByCriteria(int firstResult, int maxResult, String hql, Object... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}
	
	@Override
	public int dataCountByCriteria(String column, String value) {
		return selectByColumn(column,value).size();
	}
	@Override
	public int dataCount() {
		return  (int) selectAll().size();
	}
	
	protected void flush(){
		sessionFactory.getCurrentSession().flush();
	}
}
