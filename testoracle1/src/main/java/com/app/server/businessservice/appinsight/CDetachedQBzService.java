package com.app.server.businessservice.appinsight;
import com.app.shared.appinsight.CDetachedQ;
import java.util.List;

public interface CDetachedQBzService {

    public List<CDetachedQ> executeQueryCDetachedQ() throws Exception;
}
