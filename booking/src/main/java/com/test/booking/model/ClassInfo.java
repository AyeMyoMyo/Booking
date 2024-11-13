package com.test.booking.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name = "class_info")
@EntityListeners(AuditingEntityListener.class)
public class ClassInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "country_id", nullable = false)
	private Long countryId;

	@Column(name = "class_name", nullable = false)
	private String name;

	@Column(name = "require_credit", nullable = false)
	private Integer requireCredit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", nullable = false)
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", nullable = false)
	private Date endTime;

	@Column(name = "number_on_slots", nullable = false)
	private Integer numberOfSlots;

	@Column(name = "remained_slots")
	private Integer remainedSlots;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdAt;

	@Column(name = "created_by")
	@CreatedBy
	private Long createdBy;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedAt;

	@Column(name = "updated_by")
	@LastModifiedBy
	private Long updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRequireCredit() {
		return requireCredit;
	}

	public void setRequireCredit(Integer requireCredit) {
		this.requireCredit = requireCredit;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getNumberOfSlots() {
		return numberOfSlots;
	}

	public void setNumberOfSlots(Integer numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}

	public Integer getRemainedSlots() {
		return remainedSlots;
	}

	public void setRemainedSlots(Integer remainedSlots) {
		this.remainedSlots = remainedSlots;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "ClassInfo [id=" + id + ", countryId=" + countryId + ", name=" + name + ", requireCredit="
				+ requireCredit + ", startTime=" + startTime + ", endTime=" + endTime + ", numberOfSlots="
				+ numberOfSlots + ", remainedSlots=" + remainedSlots + ", createdAt=" + createdAt + ", createdBy="
				+ createdBy + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + "]";
	}

}
