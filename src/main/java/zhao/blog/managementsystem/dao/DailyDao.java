package zhao.blog.managementsystem.dao;

import java.util.List;

import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.entity.BlogDaily;

public interface DailyDao extends BaseDao<BlogDaily> {

	/**
	 * 归档查询
	 * @return
	 */
	List<PigeOnHoleDTO> select4PigeOnHole();
	
}
