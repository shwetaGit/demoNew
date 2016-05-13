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
            queryParams.put("queryId", "07C3E212-A58F-4442-BB9B-1619F4015E28");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.AQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
