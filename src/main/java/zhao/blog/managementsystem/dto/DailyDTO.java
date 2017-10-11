package zhao.blog.managementsystem.dto;


public class DailyDTO {
	private Integer dailyId;
	private Integer userId;
	private String userName;
	private String dailyContent;
	private String dailyTime;
	
	public DailyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DailyDTO(Integer dailyId, Integer userId, String userName, String dailyContent, String dailyTime) {
		super();
		this.dailyId = dailyId;
		this.userId = userId;
		this.userName = userName;
		this.dailyContent = dailyContent;
		this.dailyTime = dailyTime;
	}

	public Integer getDailyId() {
		return dailyId;
	}
	public void setDailyId(Integer dailyId) {
		this.dailyId = dailyId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDailyContent() {
		return dailyContent;
	}
	public void setDailyContent(String dailyContent) {
		this.dailyContent = dailyContent;
	}
	public String getDailyTime() {
		return dailyTime;
	}
	public void setDailyTime(String dailyTime) {
		this.dailyTime = dailyTime;
	}
	
}
