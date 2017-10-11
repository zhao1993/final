package zhao.blog.managementsystem.entity;
// Generated 2017-9-5 11:47:22 by Hibernate Tools 4.0.0.Final

/**
 * BlogFriendlyLink generated by hbm2java
 */
public class BlogFriendlyLink implements java.io.Serializable {

	private Integer linkId;
	private String linkName;
	private String linkUrl;
	private String linkLogo;
	private String linkDescript;

	public BlogFriendlyLink() {
	}

	public BlogFriendlyLink(Integer linkId, String linkName, String linkUrl, String linkLogo, String linkDescript) {
		super();
		this.linkId = linkId;
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.linkLogo = linkLogo;
		this.linkDescript = linkDescript;
	}

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkLogo() {
		return linkLogo;
	}

	public void setLinkLogo(String linkLogo) {
		this.linkLogo = linkLogo;
	}

	public String getLinkDescript() {
		return linkDescript;
	}

	public void setLinkDescript(String linkDescript) {
		this.linkDescript = linkDescript;
	}

	
}