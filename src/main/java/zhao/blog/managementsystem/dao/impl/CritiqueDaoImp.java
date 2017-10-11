package zhao.blog.managementsystem.dao.impl;


import java.util.List;
import org.springframework.stereotype.Repository;
import zhao.blog.managementsystem.dao.CritiqueDao;
import zhao.blog.managementsystem.entity.BlogCritique;

@Repository
public class CritiqueDaoImp extends BaseDaoImpl<BlogCritique> implements CritiqueDao {

	@Override
	public List<BlogCritique> selectCritiquesByUserId(int userId) {
		String hql="from BlogCritique where blogUser.userId = ?";
		return selectCriteria4Entity(hql, userId);
	}
	
	@Override
	public List<BlogCritique> selectCritiques4Deck(int replyId) {
		String hql= "from BlogCritique where blogCritique.replyId = ?";
		return selectCriteria4Entity(hql, replyId);
	}

	@Override
	public List<BlogCritique> selectByPage4Init(byte type, int typeid, int pagenum, int pagesize) {
		String hql ="from BlogCritique where blogCritique=null and replyType = ? and replyTypeId = ? order by replyId desc";
		return select4PageByCriteria(pagenum,pagesize,hql,type,typeid);
	}
}
