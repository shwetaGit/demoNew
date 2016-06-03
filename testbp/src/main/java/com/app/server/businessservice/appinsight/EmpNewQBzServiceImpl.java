package com.app.server.businessservice.appinsight;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.appinsight.EmpNewQ;
import java.lang.Override;
import java.util.List;

@Component
public class EmpNewQBzServiceImpl implements EmpNewQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<EmpNewQ> executeQueryEmpNewQ() throws Exception {
        java.util.List<com.app.shared.appinsight.EmpNewQ> listDtoInterface = new java.util.ArrayList<com.app.shared.appinsight.EmpNewQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "58616B9A-1A3C-44E7-AD11-EB2ADF4C2474");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.appinsight.EmpNewQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
