package java.com.hky.onlineshop.entity;

import java.util.Date;
/**
 * 头条实体类
 * @author zbq
 *
 */
public class HeadLine {
	private Long lineId;
	//名称
	private String lineName;
	//链接
	private String lineLink;
	//图片
	private String lineImg;
	//权重
	private Integer lineWeight;
	//状态  0：禁用  1：启用
	private Integer enableStatus;
	private Date createTime;
	private Date lastEditTime;
	
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getLineLink() {
		return lineLink;
	}
	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}
	public String getLineImg() {
		return lineImg;
	}
	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}
	public Integer getLineWeight() {
		return lineWeight;
	}
	public void setLineWeight(Integer lineWeight) {
		this.lineWeight = lineWeight;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
