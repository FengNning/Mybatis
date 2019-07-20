package cn.smbms.pojo;


import java.util.List;

public class SmbmsBill {

  private int id;
  private String billCode;
  private String productName;
  private String productDesc;
  private String productUnit;
  private double productCount;
  private double totalPrice;
  private int isPayment;
  private int createdBy;
  private java.sql.Timestamp creationDate;
  private int modifyBy;
  private java.sql.Timestamp modifyDate;
  private int providerId;

  private  String providerName;

private SmbmsProvider smbmsProvider;

private List<SmbmsProvider> smbmsProviderList;

  public List<SmbmsProvider> getSmbmsProviderList() {
    return smbmsProviderList;
  }

  public void setSmbmsProviderList(List<SmbmsProvider> smbmsProviderList) {
    this.smbmsProviderList = smbmsProviderList;
  }

  public SmbmsProvider getSmbmsProvider() {
    return smbmsProvider;
  }

  public void setSmbmsProvider(SmbmsProvider smbmsProvider) {
    this.smbmsProvider = smbmsProvider;
  }
  public String getProviderName() {
    return providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getBillCode() {
    return billCode;
  }

  public void setBillCode(String billCode) {
    this.billCode = billCode;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }


  public String getProductUnit() {
    return productUnit;
  }

  public void setProductUnit(String productUnit) {
    this.productUnit = productUnit;
  }


  public double getProductCount() {
    return productCount;
  }

  public void setProductCount(double productCount) {
    this.productCount = productCount;
  }


  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }


  public int getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(int isPayment) {
    this.isPayment = isPayment;
  }


  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public int getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(int modifyBy) {
    this.modifyBy = modifyBy;
  }


  public java.sql.Timestamp getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(java.sql.Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }


  public int getProviderId() {
    return providerId;
  }

  public void setProviderId(int providerId) {
    this.providerId = providerId;
  }



}
