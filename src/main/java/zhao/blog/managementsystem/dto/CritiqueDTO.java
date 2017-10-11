package zhao.blog.managementsystem.dto;


public class CritiqueDTO implements java.io.Serializable {
	private int replyId;
	private int userId;
	private String userName;
	private String replyContent;
	private String userImg;
	private int replyTypeId;
	private byte replyType;
	private String replyTime;
	
	public CritiqueDTO() {
	}
	public CritiqueDTO(int replyId, int userId, String userName, String replyContent, String userImg, int replyTypeId,
			byte replyType, String replyTime) {
		super();
		this.replyId = replyId;
		this.userId = userId;
		this.userName = userName;
		this.replyContent = replyContent;
		this.userImg = userImg;
		this.replyTypeId = replyTypeId;
		this.replyType = replyType;
		this.replyTime = replyTime;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public int getReplyTypeId() {
		return replyTypeId;
	}
	public void setReplyTypeId(int replyTypeId) {
		this.replyTypeId = replyTypeId;
	}
	public byte getReplyType() {
		return replyType;
	}
	public void setReplyType(byte replyType) {
		this.replyType = replyType;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	
}
