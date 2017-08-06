package com.student.model;

public class Address {
    private String province;
    private String city;
    private String district;
    private String avenue;
    private String postCode;
    private String type;

    public Address() {
    }

    public Address(String province, String city, String district, String avenue, String postCode, String type) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.avenue = avenue;
        this.postCode = postCode;
        this.type = type;
    }
}
