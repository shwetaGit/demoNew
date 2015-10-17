package oct16last.app.shared.defaultdomain;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.Size;
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

@Table(name = "ast_Testing_M")
@Entity
@NamedQueries({ @javax.persistence.NamedQuery(name = "Testing.findById", query = "select e from Testing e where e.systemInfo.activeStatus=1 and e.pk =:pk") })
public class Testing implements Serializable, CommonEntityInterface, Comparator<Testing> {

    @Column(name = "checktest")
    @JsonProperty("checktest")
    @Size(min = 0, max = 256)
    private String checktest;

    @Column(name = "stringvalue")
    @JsonProperty("stringvalue")
    private Boolean stringvalue;

    @Column(name = "male")
    @JsonProperty("male")
    private Boolean male;

    @Column(name = "female")
    @JsonProperty("female")
    private Boolean female;

    @Column(name = "student")
    @JsonProperty("student")
    private Boolean student;

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

    public String getChecktest() {
        return checktest;
    }

    public void setChecktest(String _checktest) {
        this.checktest = _checktest;
    }

    public Boolean getStringvalue() {
        return stringvalue;
    }

    public void setStringvalue(Boolean _stringvalue) {
        this.stringvalue = _stringvalue;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean _male) {
        this.male = _male;
    }

    public Boolean getFemale() {
        return female;
    }

    public void setFemale(Boolean _female) {
        this.female = _female;
    }

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean _student) {
        this.student = _student;
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
    public int compare(Testing object1, Testing object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append((checktest == null ? " " : checktest));
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
            oct16last.app.shared.defaultdomain.Testing other = (oct16last.app.shared.defaultdomain.Testing) obj;
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
