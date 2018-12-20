package com.spaceagencydatahub.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(unique = true, name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	private ImageryType imageryType;
	
	@Column(name = "start_date")
	private OffsetDateTime startDate;
	
	@Column(name = "finish_date")
	private OffsetDateTime finishDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageryType getImageryType() {
		return imageryType;
	}

	public void setImageryType(ImageryType imageryType) {
		this.imageryType = imageryType;
	}

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(OffsetDateTime finishDate) {
		this.finishDate = finishDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
