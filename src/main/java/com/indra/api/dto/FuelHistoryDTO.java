package com.indra.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.indra.api.domain.FuelHistory;

public class FuelHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String region;
	private String state;
	private String municipality;
	private String resale;
	private String cnpj;
	private String product;
	private Date collectionData;
	private Float saleValue;
	private Float purchaseValue;
	private String unitMeasure;
	private String flag;

	public FuelHistoryDTO() {
	}

	public FuelHistoryDTO(FuelHistory obj) {
		id = obj.getId();
		region = obj.getRegion();
		state = obj.getState();
		municipality = obj.getMunicipality();
		resale = obj.getResale();
		cnpj = obj.getCnpj();
		product = obj.getProduct();
		collectionData = obj.getCollectionData();
		saleValue = obj.getSaleValue();
		purchaseValue = obj.getPurchaseValue();
		unitMeasure = obj.getUnitMeasure();
		flag = obj.getFlag();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getResale() {
		return resale;
	}

	public void setResale(String resale) {
		this.resale = resale;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getCollectionData() {
		return collectionData;
	}

	public void setCollectionData(Date collectionData) {
		this.collectionData = collectionData;
	}

	public Float getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(Float saleValue) {
		this.saleValue = saleValue;
	}

	public Float getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(Float purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public String getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
