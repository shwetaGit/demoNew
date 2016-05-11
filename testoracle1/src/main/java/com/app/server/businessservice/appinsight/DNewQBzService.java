package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.DNewQ;
import java.util.List;

public interface DNewQBzService {

    public List<DNewQ> executeQueryDNewQ(Integer tNo1) throws Exception;
}
