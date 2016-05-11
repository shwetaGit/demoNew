package com.app.server.businessservice.appinsight.health;
import com.app.server.businessservice.appinsight.DNewQBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.appinsight.DNewQ;
import com.app.shared.appinsight.health.Adto;
import com.spartan.pluggable.exception.layers.ds.BusinessRuleUnableToProceedException;

@Component
public class DnewQDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private DNewQBzService dNewQBzService;

    public DNewQ proDnewQDs(Adto ss) throws BusinessRuleUnableToProceedException, Exception {
        java.util.List<com.app.shared.appinsight.DNewQ> dNewQList2 = dNewQBzService.executeQueryDNewQ(ss.getAno());
        for (com.app.shared.appinsight.DNewQ dNewQList2Element : dNewQList2) {
            return dNewQList2Element;
        }
        throw new com.spartan.pluggable.exception.layers.ds.BusinessRuleUnableToProceedException();
    }
}
