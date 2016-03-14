package com.app.shared.testbc;
import com.athena.server.bizService.DTOMapperInterface;

public class NTestQ implements DTOMapperInterface {

    private String cardNo;

    public NTestQ(Object obj) {
        if (obj != null) {
            cardNo = (java.lang.String) obj;
        } else {
            cardNo = null;
        }
    }

    public String getCardNo() {
        return cardNo;
    }
}
