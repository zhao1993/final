package zhao.blog.managementsystem.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.DailyDao;
import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.entity.BlogDaily;

@Repository
public class DailyDaoImpl extends BaseDaoImpl<BlogDaily> implements DailyDao {

	@Override
	public List<PigeOnHoleDTO> select4PigeOnHole() {
		String hql = "select dailyId,dailyTime,dailyContent from BlogDaily";
		List<Object[]> selectCriteria4Object = selectCriteria4Object(hql);
		ArrayList<PigeOnHoleDTO> piges = new ArrayList<PigeOnHoleDTO>();
		for (Object[] object : selectCriteria4Object) {
				PigeOnHoleDTO pdto = new PigeOnHoleDTO();
				pdto.setdId((int)object[0]);
				pdto.setCreateTime(new Date(Long.parseLong((String) object[1])));
				pdto.setpTitle((String) object[2]);
				pdto.setDtype((byte)1);
				piges.add(pdto);
		}
		return piges;
	}

}
