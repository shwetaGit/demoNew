package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.DNewQ;
import java.lang.Override;
import java.util.List;

@Component
public class DNewQBzServiceImpl implements DNewQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<DNewQ> executeQueryDNewQ(Integer tNo1) throws Exception {
        java.util.List<com.app.shared.appinsight.DNewQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.DNewQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "48C227DB-8C65-4676-BFAD-D794B47FBE5E");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectTNo1 = new atg.taglib.json.util.JSONObject();
            jsonObjectTNo1.put("name", "tNo");
            jsonObjectTNo1.put("value", tNo1);
            jsonObjectTNo1.put("datatype", "NUMBER");
            jsonObjectTNo1.put("index", 1);
            jsonArray.add(jsonObjectTNo1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.DNewQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
