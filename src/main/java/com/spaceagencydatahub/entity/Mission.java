package com.spaceagencydatahub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(unique = true, name = "name")
	private String name;

	// @Enumerated(EnumType.STRING)
	// private ImageryType imageryType;
	//
	// @Column(name = "start_date")
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date startDate;
	//
	// @Column(name = "finish_date")
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date finishDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public ImageryType getImageryType() {
	// return imageryType;
	// }
	//
	// public void setImageryType(ImageryType imageryType) {
	// this.imageryType = imageryType;
	// }
	//
	// public Date getStartDate() {
	// return startDate;
	// }
	//
	// public void setStartDate(Date startDate) {
	// this.startDate = startDate;
	// }
	//
	// public Date getFinishDate() {
	// return finishDate;
	// }
	//
	// public void setFinishDate(Date finishDate) {
	// this.finishDate = finishDate;
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
