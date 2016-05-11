package com.app.shared.testbc;
import com.athena.server.bizService.DTOMapperInterface;

public class NewQ implements DTOMapperInterface {

    private String testId;

    private String tDate;

    private String eType;

    private String cardNo;

    private String eTime;

    public NewQ(Object[] aryObject) {
        if (aryObject != null) {
            testId = (java.lang.String) aryObject[0];
            tDate = (java.lang.String) aryObject[1];
            eType = (java.lang.String) aryObject[2];
            cardNo = (java.lang.String) aryObject[3];
            eTime = (java.lang.String) aryObject[4];
        } else {
            testId = null;
            tDate = null;
            eType = null;
            cardNo = null;
            eTime = null;
        }
    }

    public String getTestId() {
        return testId;
    }

    public String gettDate() {
        return tDate;
    }

    public String geteType() {
        return eType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String geteTime() {
        return eTime;
    }
}
