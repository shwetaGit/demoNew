package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.CDetachedQ;
import java.lang.Override;
import java.util.List;

@Component
public class CDetachedQBzServiceImpl implements CDetachedQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<CDetachedQ> executeQueryCDetachedQ() throws Exception {
        java.util.List<com.app.shared.appinsight.CDetachedQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.CDetachedQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "E02C1D6C-EE21-4C63-99A7-9393BF01C3C2");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.CDetachedQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
