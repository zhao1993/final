package zhao.blog.managementsystem.entity;
// Generated 2017-9-5 11:47:22 by Hibernate Tools 4.0.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * BlogAlbum generated by hbm2java
 */
public class BlogAlbum implements java.io.Serializable {

	private Integer albumId;
	private BlogUser blogUser;
	private String albumName;
	private String albumSrc;
	private String albumTime;
	private String albumFinalTime;
	private Set blogPhotos = new HashSet(0);
	public BlogAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogAlbum(Integer albumId, BlogUser blogUser, String albumName, String albumSrc, String albumTime,
			String albumFinalTime) {
		super();
		this.albumId = albumId;
		this.blogUser = blogUser;
		this.albumName = albumName;
		this.albumSrc = albumSrc;
		this.albumTime = albumTime;
		this.albumFinalTime = albumFinalTime;
	}
	public BlogAlbum(Integer albumId, BlogUser blogUser, String albumName, String albumSrc, String albumTime,
			String albumFinalTime, Set blogPhotos) {
		super();
		this.albumId = albumId;
		this.blogUser = blogUser;
		this.albumName = albumName;
		this.albumSrc = albumSrc;
		this.albumTime = albumTime;
		this.albumFinalTime = albumFinalTime;
		this.blogPhotos = blogPhotos;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public BlogUser getBlogUser() {
		return blogUser;
	}
	public void setBlogUser(BlogUser blogUser) {
		this.blogUser = blogUser;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getAlbumSrc() {
		return albumSrc;
	}
	public void setAlbumSrc(String albumSrc) {
		this.albumSrc = albumSrc;
	}
	public String getAlbumTime() {
		return albumTime;
	}
	public void setAlbumTime(String albumTime) {
		this.albumTime = albumTime;
	}
	public String getAlbumFinalTime() {
		return albumFinalTime;
	}
	public void setAlbumFinalTime(String albumFinalTime) {
		this.albumFinalTime = albumFinalTime;
	}
	public Set getBlogPhotos() {
		return blogPhotos;
	}
	public void setBlogPhotos(Set blogPhotos) {
		this.blogPhotos = blogPhotos;
	}

}
