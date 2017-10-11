package zhao.blog.managementsystem.service;

import java.util.List;
import java.util.Map;

import zhao.blog.managementsystem.dto.PigeOnHoleDTO;

/**
 * 
 */



public interface BlogService {

	/**
	 * 初始化归档模块[日志,文章,相册]
	 * @return 
	 */
	Map<String,List<PigeOnHoleDTO>> initPigeOnHole();
	
}
