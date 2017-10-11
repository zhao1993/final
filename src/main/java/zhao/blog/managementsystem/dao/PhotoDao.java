package zhao.blog.managementsystem.dao;

import java.util.List;

import zhao.blog.managementsystem.entity.BlogPhoto;

public interface PhotoDao extends BaseDao<BlogPhoto> {

	/**
	 * 根据albumid查询 photos
	 * @param albumId
	 * @return List<Photo>
	 */
	List<BlogPhoto> selectPhotosByAlbumId(int albumId);
	
}
