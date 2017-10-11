package zhao.blog.managementsystem.dao;




import java.util.List;

import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.entity.BlogAlbum;

public interface AlbumDao extends BaseDao<BlogAlbum> {

	/**
	 * 归档查询
	 * @return
	 */
	List<PigeOnHoleDTO> select4PigeOnHole();
	
}
