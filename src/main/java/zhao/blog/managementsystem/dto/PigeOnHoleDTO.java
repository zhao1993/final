package zhao.blog.managementsystem.dto;

import java.util.Date;

public class PigeOnHoleDTO {
	private int pId;
	private int dId;
	private byte dtype;
	private String pTitle;
	private Date createTime;
	public PigeOnHoleDTO() {
		super();
	}
	public PigeOnHoleDTO(int pId, int dId, byte dtype, String pTitle, Date createtime) {
		super();
		this.pId = pId;
		this.dId = dId;
		this.dtype = dtype;
		this.pTitle = pTitle;
		this.createTime = createtime;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public byte getDtype() {
		return dtype;
	}
	public void setDtype(byte dtype) {
		this.dtype = dtype;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
