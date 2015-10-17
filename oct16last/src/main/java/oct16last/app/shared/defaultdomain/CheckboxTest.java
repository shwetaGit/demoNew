package oct16last.app.shared.defaultdomain;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import javax.persistence.Embedded;
import oct16last.app.shared.EntityAudit;
import oct16last.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_CheckboxTest_M")
@Entity
@NamedQueries({ @javax.persistence.NamedQuery(name = "CheckboxTest.DefaultFinders", query = "select e from CheckboxTest e where e.systemInfo.activeStatus=1 and e.a1 = :a1"), @javax.persistence.NamedQuery(name = "CheckboxTest.findById", query = "select e from CheckboxTest e where e.systemInfo.activeStatus=1 and e.pk =:pk") })
public class CheckboxTest implements Serializable, CommonEntityInterface, Comparator<CheckboxTest> {

    @Column(name = "a1")
    @JsonProperty("a1")
    @NotNull
    private Boolean a1;

    @Column(name = "a2")
    @JsonProperty("a2")
    @NotNull
    private Boolean a2;

    @Column(name = "a3")
    @JsonProperty("a3")
    private Boolean a3;

    @Column(name = "a4")
    @JsonProperty("a4")
    private Boolean a4;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "pk")
    @JsonProperty("pk")
    @GeneratedValue(generator = "UUIDGenerator")
    private String pk;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public Boolean getA1() {
        return a1;
    }

    public void setA1(Boolean _a1) {
        if (_a1 != null) {
            this.a1 = _a1;
        }
    }

    public Boolean getA2() {
        return a2;
    }

    public void setA2(Boolean _a2) {
        if (_a2 != null) {
            this.a2 = _a2;
        }
    }

    public Boolean getA3() {
        return a3;
    }

    public void setA3(Boolean _a3) {
        this.a3 = _a3;
    }

    public Boolean getA4() {
        return a4;
    }

    public void setA4(Boolean _a4) {
        this.a4 = _a4;
    }

    public String getPrimaryKey() {
        return pk;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return pk;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String _pk) {
        this.pk = _pk;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(CheckboxTest object1, CheckboxTest object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append((a1 == null ? " " : a1));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (pk == null) {
            return super.hashCode();
        } else {
            return pk.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            oct16last.app.shared.defaultdomain.CheckboxTest other = (oct16last.app.shared.defaultdomain.CheckboxTest) obj;
            if (pk == null) {
                return false;
            } else if (!pk.equals(other.pk)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
