package com.test.booking.model;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.test.booking.enumation.UserPackageStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user_package")
@EntityListeners(AuditingEntityListener.class)
public class UserPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(name = "package_id", nullable = false)
	private Long packageId;

	@Column(name = "purchased_credit", nullable = false)
	private Integer purchasedCredit;

	@Column(name = "remained_credit")
	private Integer remainedCredit;

	@Column(name = "user_package_status", nullable = false)
	private UserPackageStatus userPackageStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expire_date")
	private Date expireDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "purchased_date")
	private Date purchasedDate;

	@Column(name = "country_id", nullable = false)
	private Long countryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public UserPackageStatus getUserPackageStatus() {
		return userPackageStatus;
	}

	public void setUserPackageStatus(UserPackageStatus userPackageStatus) {
		this.userPackageStatus = userPackageStatus;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getPurchasedCredit() {
		return purchasedCredit;
	}

	public void setPurchasedCredit(Integer purchasedCredit) {
		this.purchasedCredit = purchasedCredit;
	}

	public Integer getRemainedCredit() {
		return remainedCredit;
	}

	public void setRemainedCredit(Integer remainedCredit) {
		this.remainedCredit = remainedCredit;
	}

	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "UserPackage [id=" + id + ", userId=" + userId + ", packageId=" + packageId + ", purchasedCredit="
				+ purchasedCredit + ", remainedCredit=" + remainedCredit + ", userPackageStatus=" + userPackageStatus
				+ ", expireDate=" + expireDate + ", purchasedDate=" + purchasedDate + ", countryId=" + countryId + "]";
	}

}
