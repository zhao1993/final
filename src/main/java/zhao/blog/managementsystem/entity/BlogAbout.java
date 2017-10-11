package zhao.blog.managementsystem.entity;
// Generated 2017-9-5 11:47:22 by Hibernate Tools 4.0.0.Final

/**
 * BlogAbout generated by hbm2java
 */
public class BlogAbout implements java.io.Serializable {

	private Integer blogId;
	private String blogKeyword;
	private String blogDescription;
	private String blogName;
	private String blogTitle;
	private String blogAuthor;

	public BlogAbout() {
	}

	public BlogAbout(Integer blogId, String blogKeyword, String blogDescription, String blogName, String blogTitle,
			String blogAuthor) {
		super();
		this.blogId = blogId;
		this.blogKeyword = blogKeyword;
		this.blogDescription = blogDescription;
		this.blogName = blogName;
		this.blogTitle = blogTitle;
		this.blogAuthor = blogAuthor;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogKeyword() {
		return blogKeyword;
	}

	public void setBlogKeyword(String blogKeyword) {
		this.blogKeyword = blogKeyword;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	
}
