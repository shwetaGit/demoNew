package com.app.server.businessservice.testbc;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.testbc.NTestQ;
import java.lang.Override;
import java.util.List;

@Component
public class NTestQBzServiceImpl implements NTestQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<NTestQ> executeQueryNTestQ(String alias11) throws Exception {
        java.util.List<com.app.shared.testbc.NTestQ> listDtoInterface = new java.util.ArrayList<com.app.shared.testbc.NTestQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "577F936E-0FC8-46BE-9B36-00EEF4BB4D64");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectAlias11 = new atg.taglib.json.util.JSONObject();
            jsonObjectAlias11.put("name", "alias1");
            jsonObjectAlias11.put("value", alias11);
            jsonObjectAlias11.put("datatype", "VARCHAR");
            jsonObjectAlias11.put("index", 1);
            jsonArray.add(jsonObjectAlias11);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.testbc.NTestQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
