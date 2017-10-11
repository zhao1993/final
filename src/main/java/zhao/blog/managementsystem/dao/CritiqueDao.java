package zhao.blog.managementsystem.dao;



import java.util.List;

import zhao.blog.managementsystem.entity.BlogCritique;

public interface CritiqueDao extends BaseDao<BlogCritique> {

	/**
	 * 根据用户id查询其回复内容列表
	 * @param userId 用户的id
	 * @return 回复对象集合
	 */
	List<BlogCritique> selectCritiquesByUserId(int userId);
	
	/**
	 * 初始化列表的查询区别在于查询结果不属于任何楼中楼
	 * @param type 类型
	 * @param typeid 类型id
	 * @param pagenum 页码
	 * @param pagesize 显示数
	 * @return 查询结果集合
	 */
	List<BlogCritique> selectByPage4Init(byte type, int typeid, int pagenum, int pagesize);
	
	List<BlogCritique> selectCritiques4Deck(int replyId);

	
}
