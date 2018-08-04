package org.com.as.user.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "userloginhistory")
@Table(name = "USERLOGINHISTORY")
@XmlRootElement(name = "userloginhistory")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserLogInHistory {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "SERVERLOGINDATE")
	private Date serverLoginDate;
	@Column(name = "USERLOGINLOCATION")
	private String userLogInLocation;
	@ManyToOne()
	@JoinColumn(name = "USERID")
	private User user;

	@Column(name = "USERLOGINDATENTIMEZONE")
	private String userLoginDatenTimezone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getServerLoginDate() {
		return serverLoginDate;
	}

	public void setServerLoginDate(Date serverLoginDate) {
		this.serverLoginDate = serverLoginDate;
	}

	public String getUserLogInLocation() {
		return userLogInLocation;
	}

	public void setUserLogInLocation(String userLogInLocation) {
		this.userLogInLocation = userLogInLocation;
	}

	public String getUserLoginDatenTimezone() {
		return userLoginDatenTimezone;
	}

	public void setUserLoginDatenTimezone(String userLoginDatenTimezone) {
		this.userLoginDatenTimezone = userLoginDatenTimezone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserLogInHistory [id=" + id + ", serverLoginDate="
				+ serverLoginDate + ", userLogInLocation=" + userLogInLocation
				+ ", user=" + user + ", userLoginDatenTimezone="
				+ userLoginDatenTimezone + "]";
	}
}
