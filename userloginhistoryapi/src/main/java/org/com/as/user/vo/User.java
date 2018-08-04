package org.com.as.user.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "user")
@Table(name = "USER")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@Id
	@GeneratedValue
	@Column(name = "USERID")
	private int userId;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ENTRYDATE")
	private Date entryDate;

	@Column(name = "CELLNO")
	private String cellNo;

	@Column(name = "ALTERNATIVECELLNO")
	private String alternativeCellNo;

	@Column(name = "OFFICENO")
	private String officeNo;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SMSCAPABLE")
	private Boolean smsCapable;

	@Column(name = "TYPE")
	private int type;

	@Column(name = "ISACTIVE")
	private boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENTUSERID")
	@XmlElement(name = "parentuser")
	private User parentUser;

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getSmsCapable() {
		return smsCapable;
	}

	public void setSmsCapable(Boolean smsCapable) {
		this.smsCapable = smsCapable;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public User getParentUser() {
		return parentUser;
	}

	public void setParentUser(User parentUser) {
		this.parentUser = parentUser;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAlternativeCellNo() {
		return alternativeCellNo;
	}

	public void setAlternativeCellNo(String alternativeCellNo) {
		this.alternativeCellNo = alternativeCellNo;
	}

}
