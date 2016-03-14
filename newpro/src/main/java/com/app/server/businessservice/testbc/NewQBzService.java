package com.app.server.businessservice.testbc;
import com.app.shared.testbc.NewQ;
import java.util.List;

public interface NewQBzService {

    public List<NewQ> executeQueryNewQ(String eType1) throws Exception;
}
