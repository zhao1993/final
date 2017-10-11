package zhao.blog.managementsystem.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.dao.DailyDao;
import zhao.blog.managementsystem.dto.DailyDTO;
import zhao.blog.managementsystem.entity.BlogDaily;
import zhao.blog.managementsystem.service.DailyService;

@Service
@Transactional
public class DailyServiceImpl extends BaseServiceImpl<BlogDaily> implements DailyService {
	@Resource
	private DailyDao dailyDaoImpl;
	
	public List<BlogDaily> selectAll(){
		return  dailyDaoImpl.selectAll();
	}

	@Override
	public List<DailyDTO> select4Dto(Integer pagenum, Integer pagesize) {
		if (null == pagesize || pagesize < 1) {
			pagesize = Common.DEFAULT_PAGE_SIZE;
		}
		int all_page = this.allPage(pagesize);
		if (null == pagenum || pagenum < 1) {
			pagenum = Common.DEFAULT_PAGE_NOW;
		}
		if (all_page < pagenum) {
			//pagenum = all_page;
			return new ArrayList<DailyDTO>();
		}
		if (all_page == 0)
			return null;
		List<BlogDaily> bds = select4Page(pagenum, pagesize);
		ArrayList<DailyDTO> arrayList = new ArrayList<DailyDTO>();
		for (BlogDaily blogDaily : bds) {
			DailyDTO dailyDTO = new DailyDTO(
					blogDaily.getDailyId(),
					blogDaily.getBlogUser().getUserId(), 
					blogDaily.getBlogUser().getUserName(),
					blogDaily.getDailyContent(), 
					blogDaily.getDailyTime());
			arrayList.add(dailyDTO);
		}
		return arrayList;
	}
}
