package com.app.shared.testbc.testing;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestDTO {

    private String eType;

    public String geteType() {
        return eType;
    }

    public void seteType(String _eType) {
        this.eType = _eType;
    }
}
