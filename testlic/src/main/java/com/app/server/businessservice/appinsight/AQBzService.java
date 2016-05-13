package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.AQ;
import java.util.List;

public interface AQBzService {

    public List<AQ> executeQueryAQ() throws Exception;
}
