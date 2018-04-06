package org.sharpsw.sakura;

public class BinDBResponse {
    private String bin;
    private String brand;
    private String bank;
    private String cardType;
    private String level;
    private String isoCountry;
    private String countryCode;

    public String getBin() {
        return bin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBin(String val) {
        bin = val;
    }

    public void setBrand(String val) {
        brand = val;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String value) {
        bank = value;
    }

    public void setCardType(String type) {
        cardType = type;
    }

    public String getCardType() {
        return cardType;
    }

    public void setLevel(String value) {
        level = value;
    }

    public String getLevel() {
        return level;
    }

    public void setIsoCountry(String code) {
        isoCountry = code;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setCountryCode(String code) {
        countryCode = code;
    }

    public String getCountryCode() {
        return countryCode;
    }
}