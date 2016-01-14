package testprj.app.server.businessservice.defaultcontext.defaultdomain;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.ruleengine.server.bzservice.RuleEngineInterface;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testprj.app.server.repository.PersonalInfoRepository;
import testprj.app.shared.defaultdomain.PersonalInfo;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class UpdateDateService {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private RuleEngineInterface ruleEngineInterface;

    @Autowired
    private PersonalInfoRepository<PersonalInfo> personalInfoRepository;

    public void updateDateMethod(PersonalInfo entity) throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
            if (entity.getPk() == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            testprj.app.shared.defaultdomain.PersonalInfo personalinfo_0 = personalInfoRepository.findById(entity.getPk());
            ruleEngineInterface.initialize("cd29c549-8847-49aa-8166-f30f5d114606");
            ruleEngineInterface.add(personalinfo_0);
            ruleEngineInterface.add(runtimeLogInfoHelper);
            ruleEngineInterface.add(entity);
            ruleEngineInterface.executeRule();
            personalInfoRepository.update((testprj.app.shared.defaultdomain.PersonalInfo) ruleEngineInterface.getResult("personalinfo_0"));
        } catch (com.athena.framework.server.exception.biz.RuleInitException | com.athena.framework.server.exception.biz.RuleExecuteException | com.athena.framework.server.exception.biz.RuleWorkingMemoryException | com.athena.framework.server.exception.biz.RuleDataException e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3005");
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
