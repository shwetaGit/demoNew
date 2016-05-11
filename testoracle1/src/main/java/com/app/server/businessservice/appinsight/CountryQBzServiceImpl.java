package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.CountryQ;
import java.lang.Override;
import java.util.List;

@Component
public class CountryQBzServiceImpl implements CountryQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<CountryQ> executeQueryCountryQ(String countryName1) throws Exception {
        java.util.List<com.app.shared.appinsight.CountryQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.CountryQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "97D067C9-F9E0-4282-AFA8-93A4707C739E");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectCountryName1 = new atg.taglib.json.util.JSONObject();
            jsonObjectCountryName1.put("name", "countryName");
            jsonObjectCountryName1.put("value", countryName1);
            jsonObjectCountryName1.put("datatype", "VARCHAR2");
            jsonObjectCountryName1.put("index", 1);
            jsonArray.add(jsonObjectCountryName1);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.CountryQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
