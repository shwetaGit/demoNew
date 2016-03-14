package com.app.server.businessservice.testbc;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.testbc.NewQ;
import java.lang.Override;
import java.util.List;

@Component
public class NewQBzServiceImpl implements NewQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<NewQ> executeQueryNewQ(String eType1) throws Exception {
        java.util.List<com.app.shared.testbc.NewQ> listDtoInterface = new java.util.ArrayList<com.app.shared.testbc.NewQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "3E96F990-7A7C-413D-8144-79CD143B11B0");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectEType1 = new atg.taglib.json.util.JSONObject();
            jsonObjectEType1.put("name", "eType");
            jsonObjectEType1.put("value", eType1);
            jsonObjectEType1.put("datatype", "VARCHAR");
            jsonObjectEType1.put("index", 1);
            jsonArray.add(jsonObjectEType1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.testbc.NewQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
