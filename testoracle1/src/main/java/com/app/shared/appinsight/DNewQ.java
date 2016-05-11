package com.app.shared.appinsight;
import com.athena.server.dataengine.bizService.DTOMapperInterface;

public class DNewQ implements DTOMapperInterface {

    private Integer tNo;

    private String tNm;

    public DNewQ(Object[] aryObject) {
        if (aryObject != null) {
            tNo = (java.lang.Integer) aryObject[0];
            tNm = (java.lang.String) aryObject[1];
        } else {
            tNo = null;
            tNm = null;
        }
    }

    public Integer gettNo() {
        return tNo;
    }

    public String gettNm() {
        return tNm;
    }
}
