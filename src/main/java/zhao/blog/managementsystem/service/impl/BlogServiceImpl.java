package zhao.blog.managementsystem.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhao.blog.managementsystem.dao.AlbumDao;
import zhao.blog.managementsystem.dao.ArticleDao;
import zhao.blog.managementsystem.dao.DailyDao;
import zhao.blog.managementsystem.dto.PigeOnHoleDTO;
import zhao.blog.managementsystem.service.BlogService;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Resource
	private ArticleDao articleDaoImpl;//0
	@Resource
	private DailyDao DailyDaoImpl;//1
	@Resource
	private AlbumDao albumDaoImpl;//2
	
	@Override
	public Map<String, List<PigeOnHoleDTO>> initPigeOnHole() {
		List<PigeOnHoleDTO> articles = articleDaoImpl.select4PigeOnHole();
		List<PigeOnHoleDTO> dailys = DailyDaoImpl.select4PigeOnHole();
		List<PigeOnHoleDTO> albums = albumDaoImpl.select4PigeOnHole();
		List<PigeOnHoleDTO> piges = new ArrayList<PigeOnHoleDTO>();
		//合并集合
		piges.addAll(articles);
		piges.addAll(dailys);
		piges.addAll(albums);
		//处理DTO
		TreeMap<String, List<PigeOnHoleDTO>> treeMap = new TreeMap<String, List<PigeOnHoleDTO>>();
		for (PigeOnHoleDTO pdto : piges) {
			String year = new SimpleDateFormat("YYYY").format(pdto.getCreateTime());
			if(treeMap.containsKey(year)){
				treeMap.get(year).add(pdto);
			}else{
				ArrayList<PigeOnHoleDTO> plist = new ArrayList<PigeOnHoleDTO>();
				plist.add(pdto);
				treeMap.put(year,plist);
			}
		}
		/*Collections.sort(piges, new Comparator<PigeOnHoleDTO>() {
			@Override
			public int compare(PigeOnHoleDTO p1, PigeOnHoleDTO p2) {
				return p1.getCreateTime().compareTo(p2.getCreateTime());
			}	
		});*/
		NavigableMap<String, List<PigeOnHoleDTO>> descendingMap = treeMap.descendingMap();
		return descendingMap;
	}
	
	
	
	
	
	
	
}
