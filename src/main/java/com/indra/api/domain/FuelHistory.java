package com.indra.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuelHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public FuelHistory() {
		super();
	}	

	public FuelHistory(long id, String region, String state, String municipality, String resale, String cnpj,
			String product, Date collectionData, Float saleValue, Float purchaseValue, String unitMeasure,
			String flag) {
		super();
		this.id = id;
		this.region = region;
		this.state = state;
		this.municipality = municipality;
		this.resale = resale;
		this.cnpj = cnpj;
		this.product = product;
		this.collectionData = collectionData;
		this.saleValue = saleValue;
		this.purchaseValue = purchaseValue;
		this.unitMeasure = unitMeasure;
		this.flag = flag;
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