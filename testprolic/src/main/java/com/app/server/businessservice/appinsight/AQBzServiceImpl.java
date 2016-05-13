package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.AQ;
import java.lang.Override;
import java.util.List;

@Component
public class AQBzServiceImpl implements AQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<AQ> executeQueryAQ() throws Exception {
        java.util.List<com.app.shared.appinsight.AQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.AQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "D0E9B994-5947-4429-8C1A-1698E213D3A4");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.AQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
