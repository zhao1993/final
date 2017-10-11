package zhao.blog.managementsystem.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.AlbumDao;
import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.entity.BlogAlbum;

@Repository
public class AblumDaoImpl extends BaseDaoImpl<BlogAlbum> implements AlbumDao {

	@Override
	public List<PigeOnHoleDTO> select4PigeOnHole() {
		String hql = "select albumId,albumTime,albumName from BlogAlbum";
		List<Object[]> selectCriteria4Object = selectCriteria4Object(hql);
		ArrayList<PigeOnHoleDTO> piges = new ArrayList<PigeOnHoleDTO>();
		for (Object[] object : selectCriteria4Object) {
				PigeOnHoleDTO pdto = new PigeOnHoleDTO();
				pdto.setdId((int)object[0]);
				pdto.setCreateTime(new Date(Long.parseLong((String) object[1])));
				pdto.setpTitle((String) object[2]);
				pdto.setDtype((byte)2);
				piges.add(pdto);
		}
		return piges;
	}
	
}
