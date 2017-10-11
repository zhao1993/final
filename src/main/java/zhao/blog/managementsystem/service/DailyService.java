package zhao.blog.managementsystem.service;


import java.util.List;

import zhao.blog.managementsystem.dto.DailyDTO;
import zhao.blog.managementsystem.entity.BlogDaily;
public interface DailyService extends BaseService<BlogDaily> {

	List<DailyDTO> select4Dto(Integer pagenum, Integer pagesize);
	
}
