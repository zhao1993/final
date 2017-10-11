package zhao.blog.managementsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.PhotoDao;
import zhao.blog.managementsystem.entity.BlogPhoto;

@Repository
public class PhotoDaoImpl extends BaseDaoImpl<BlogPhoto> implements PhotoDao {

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.PhotoDao#selectPhotosByAlbumId(int)
	 */
	@Override
	public List<BlogPhoto> selectPhotosByAlbumId(int albumId) {
		return selectCriteria4Entity("from BlogPhoto p where p.blogAlbum.albumId = ?", albumId);
	}

}
