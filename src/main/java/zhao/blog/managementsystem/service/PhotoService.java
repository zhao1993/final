package zhao.blog.managementsystem.service;

import java.util.List;

import zhao.blog.managementsystem.entity.BlogAlbum;
import zhao.blog.managementsystem.entity.BlogPhoto;

public interface PhotoService extends BaseService<BlogPhoto> {

	/**
	 * 根据Album的ID查询 包含的Photo
	 * @param albumId 
	 * @return List<Photo>
	 */
	List<BlogPhoto> selectPhotosByAlbumId(int albumId);

	/**
	 * 根据 photoId 查询所属的album
	 * @param photoId 
	 * @return Album
	 */
	BlogAlbum selectAlbumByPhotoId(int photoId);
}
