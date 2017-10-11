package zhao.blog.managementsystem.service;


import java.util.List;

import zhao.blog.managementsystem.dto.CritiqueDTO;
import zhao.blog.managementsystem.entity.BlogCritique;


public interface CritiqueService extends BaseService<BlogCritique> {

	/**
	 * 评论的分页分类型查询[初始化评论]
	 * @param critique 
	 * @param pagenum 
	 * @param pagesize 
	 * @return
	 */
	List<CritiqueDTO> selectByPage4Init(BlogCritique critique, Integer pagenum, Integer pagesize);

	/**
	 * 加载楼中楼 
	 * @param critique 
	 * @return 
	 */
	List<CritiqueDTO> selectByPage4Deck(BlogCritique critique);

	/**添加一条评论
	 * @param critique [blogCritique.replyId,*replyTypeId,*replyContent]
	 * @return 成功返回true 反之false
	 */
	boolean addCritique(BlogCritique critique);
	
}
