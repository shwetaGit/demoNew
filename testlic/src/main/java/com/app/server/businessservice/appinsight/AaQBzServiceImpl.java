package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.AaQ;
import java.lang.Override;
import java.util.List;

@Component
public class AaQBzServiceImpl implements AaQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<AaQ> executeQueryAaQ() throws Exception {
        java.util.List<com.app.shared.appinsight.AaQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.AaQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "87DBDE61-54E3-46D9-8720-821C7B30EE07");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.AaQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
