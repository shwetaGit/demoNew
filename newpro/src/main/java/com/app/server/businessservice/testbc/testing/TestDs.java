package com.app.server.businessservice.testbc.testing;
import com.app.server.businessservice.testbc.NewQBzService;
import com.app.server.repository.testbc.testing.TestEntityRepository;
import com.app.shared.testbc.testing.TestEntity;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class TestDs {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TestEntityRepository<TestEntity> testEntityRepository;

    @Autowired
    private NewQBzService newQBzService;

    public void proTestDs(TestEntity entity) throws SpartanPersistenceException, SpartanConstraintViolationException, Exception {
        java.util.List<com.app.shared.testbc.NewQ> newQList1 = newQBzService.executeQueryNewQ(entity.geteType());
        for (com.app.shared.testbc.NewQ newQList1Element : newQList1) {
            entity.setCardNo(newQList1Element.getCardNo());
            entity.seteTime(newQList1Element.geteTime());
            entity.seteType(newQList1Element.geteType());
            entity.settDate(newQList1Element.gettDate());
        }
        testEntityRepository.update(entity);
    }
}
