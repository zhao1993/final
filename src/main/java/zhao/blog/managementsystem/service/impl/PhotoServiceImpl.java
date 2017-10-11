package zhao.blog.managementsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.dao.AlbumDao;
import zhao.blog.managementsystem.dao.PhotoDao;
import zhao.blog.managementsystem.entity.BlogAlbum;
import zhao.blog.managementsystem.entity.BlogPhoto;
import zhao.blog.managementsystem.service.PhotoService;


@Service
@Transactional
public class PhotoServiceImpl extends BaseServiceImpl<BlogPhoto> implements PhotoService {
	@Resource private PhotoDao photoDaoImpl;
	@Resource private AlbumDao albumDaoImpl;

	@Override
	public List<BlogPhoto> selectPhotosByAlbumId(int albumId) {
		return photoDaoImpl.selectPhotosByAlbumId(albumId);
	}

	@Override
	public BlogAlbum selectAlbumByPhotoId(int photoId) {
		return photoDaoImpl.selectById(photoId).getBlogAlbum();
	}
	
}
