package com.scjohnson.objects;

public class SugarAccount {
  private String name = "name";
  private String industry = "industry";
  private String country = "billing_address_country";
  private String phone = "phone_office";
  // Need getters/setters...
  
  public void setName(String n) {
    name = n;
  }
  public void setIndustry(String i) {
    industry = i;
  }
  public void setCountry(String c) {
    country = c;
  }
  public void setPhone(String p) {
    phone = p;
  }
}
