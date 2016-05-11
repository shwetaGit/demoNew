package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class CDetachedQ implements DTOMapperInterface {

    private String countryName;

    private String countryCode1;

    private String countryFlag;

    private String countryCode2;

    public CDetachedQ(Object[] aryObject) {
        if (aryObject != null) {
            countryName = (java.lang.String) aryObject[0];
            countryCode1 = (java.lang.String) aryObject[1];
            countryFlag = (java.lang.String) aryObject[2];
            countryCode2 = (java.lang.String) aryObject[3];
        } else {
            countryName = null;
            countryCode1 = null;
            countryFlag = null;
            countryCode2 = null;
        }
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode1() {
        return countryCode1;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getCountryCode2() {
        return countryCode2;
    }
}
