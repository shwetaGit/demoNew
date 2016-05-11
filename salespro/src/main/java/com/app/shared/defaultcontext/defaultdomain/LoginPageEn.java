package com.app.shared.defaultcontext.defaultdomain;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_LoginPageEn_M")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "sagarjdhv968@gmail.com", updatedBy = "", versionNumber = "1", comments = "LoginPageEn", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "LoginPageEn.findById", query = "select e from LoginPageEn e where e.systemInfo.activeStatus=1 and e.loginUuid =:loginUuid") })
public class LoginPageEn implements Serializable, CommonEntityInterface, Comparator<LoginPageEn> {

    @Column(name = "firstName")
    @JsonProperty("firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    @JsonProperty("lastName")
    @NotNull
    @Size(min = 1, max = 256)
    private String lastName;

    @Column(name = "companyName")
    @JsonProperty("companyName")
    @NotNull
    @Size(min = 1, max = 256)
    private String companyName;

    @Column(name = "localAddress")
    @JsonProperty("localAddress")
    @NotNull
    private String localAddress;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "loginUuid")
    @JsonProperty("loginUuid")
    @GeneratedValue(generator = "UUIDGenerator")
    private String loginUuid;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String _firstName) {
        if (_firstName != null) {
            this.firstName = _firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        if (_lastName != null) {
            this.lastName = _lastName;
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String _companyName) {
        if (_companyName != null) {
            this.companyName = _companyName;
        }
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String _localAddress) {
        if (_localAddress != null) {
            this.localAddress = _localAddress;
        }
    }

    public String getPrimaryKey() {
        return loginUuid;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return loginUuid;
    }

    public String getLoginUuid() {
        return loginUuid;
    }

    public void setLoginUuid(String _loginUuid) {
        this.loginUuid = _loginUuid;
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
            this.systemInfo.setEntityValidated(true);
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
    public int compare(LoginPageEn object1, LoginPageEn object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (loginUuid == null) {
            return super.hashCode();
        } else {
            return loginUuid.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.defaultcontext.defaultdomain.LoginPageEn other = (com.app.shared.defaultcontext.defaultdomain.LoginPageEn) obj;
            if (loginUuid == null) {
                return false;
            } else if (!loginUuid.equals(other.loginUuid)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }
}
