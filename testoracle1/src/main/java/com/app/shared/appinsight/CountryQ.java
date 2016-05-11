package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class CountryQ implements DTOMapperInterface {

    private String countryName;

    private String countryCode1;

    private String countryCode2;

    public CountryQ(Object[] aryObject) {
        if (aryObject != null) {
            countryName = (java.lang.String) aryObject[0];
            countryCode1 = (java.lang.String) aryObject[1];
            countryCode2 = (java.lang.String) aryObject[2];
        } else {
            countryName = null;
            countryCode1 = null;
            countryCode2 = null;
        }
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode1() {
        return countryCode1;
    }

    public String getCountryCode2() {
        return countryCode2;
    }
}
