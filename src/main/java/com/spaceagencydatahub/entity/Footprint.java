package com.spaceagencydatahub.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Footprint {

	private double pointW;
	private double pointX;
	private double pointY;
	private double pointZ;

	public double getPointW() {
		return pointW;
	}

	public void setPointW(double pointW) {
		this.pointW = pointW;
	}

	public double getPointX() {
		return pointX;
	}

	public void setPointX(double pointX) {
		this.pointX = pointX;
	}

	public double getPointY() {
		return pointY;
	}

	public void setPointY(double pointY) {
		this.pointY = pointY;
	}

	public double getPointZ() {
		return pointZ;
	}

	public void setPointZ(double pointZ) {
		this.pointZ = pointZ;
	}

}
