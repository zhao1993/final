package zhao.blog.managementsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.dao.CritiqueDao;
import zhao.blog.managementsystem.dto.CritiqueDTO;
import zhao.blog.managementsystem.entity.BlogCritique;
import zhao.blog.managementsystem.service.CritiqueService;
import zhao.blog.managementsystem.service.UserService;
import zhao.blog.managementsystem.util.DateUtil;

@Service
@Transactional
public class CritiqueServiceImpl extends BaseServiceImpl<BlogCritique> implements CritiqueService {
	@Resource
	private CritiqueDao critiqueDaoImpl;
	@Resource
	private UserService userServiceImpl;

	@Override
	public List<CritiqueDTO> selectByPage4Init(BlogCritique critique, Integer pagenum, Integer pagesize) {
		byte type = critique.getReplyType();
		int typeid = critique.getReplyTypeId();
		if (null == pagesize || pagesize < 1) {
			pagesize = Common.DEFAULT_PAGE_SIZE;
		}
		int all_page = this.allPage(pagesize);
		if (null == pagenum || pagenum < 1) {
			pagenum = Common.DEFAULT_PAGE_NOW;
		}
		if (all_page < pagenum) {
			pagenum = all_page;
		}
		if (all_page == 0)
			return null;
		List<BlogCritique> critiques = critiqueDaoImpl.selectByPage4Init(type,typeid,(pagenum - 1) * pagesize, pagesize);
		return cToCDTO(critiques);
	}

	@Override
	public List<CritiqueDTO> selectByPage4Deck(BlogCritique critique) {
		if (null==critique || critique.getReplyId()==null)
			return new ArrayList<CritiqueDTO>();
		List<BlogCritique> critiques = critiqueDaoImpl.selectCritiques4Deck(critique.getReplyId());
		return cToCDTO(critiques);
	}
	
	private List<CritiqueDTO> cToCDTO(List<BlogCritique> critiques){
		List<CritiqueDTO> dtos = new ArrayList<CritiqueDTO>();
		for (BlogCritique blogCritique : critiques) {
			CritiqueDTO cdto = new CritiqueDTO(
					blogCritique.getReplyId(), 
					blogCritique.getBlogUser().getUserId(), 
					blogCritique.getBlogUser().getUserName(), 
					blogCritique.getReplyContent(), 
					blogCritique.getBlogUser().getUserImageUrl(), 
					blogCritique.getReplyTypeId(), 
					blogCritique.getReplyType(), 
					blogCritique.getReplyTime());
			dtos.add(cdto);
		}
		return dtos;
	}

	@Override
	public boolean addCritique(BlogCritique critique) {
		if(null==critique || null == critique.getReplyContent() ||
				"".equals(critique.getReplyContent().trim()) || critique.getReplyTypeId()==0
				|| null == critique.getBlogUser()
				){
			return false;
		}
		critique.setReplyTime(DateUtil.getTime());
		critiqueDaoImpl.save(critique);
		return true;
	}
	
	
	/*@Override
	public List<BlogCritique> selectCritiquesByDeck(Integer id) {
		if (id == null)
			return new ArrayList<BlogCritique>();
		return critiqueDaoImpl.selectCritiquesByDeck(id);
	}*/
	

}
