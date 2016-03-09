package com.app.shared.payroll;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.config.CacheIsolationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
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

@Table(name = "ast_EmployeeDeclartion_M")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "EmployeeDeclartion", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "EmployeeDeclartion.DefaultFinders", query = "select e from EmployeeDeclartion e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId"), @javax.persistence.NamedQuery(name = "EmployeeDeclartion.findByEmpId", query = "select e from EmployeeDeclartion e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "EmployeeDeclartion.findById", query = "select e from EmployeeDeclartion e where e.systemInfo.activeStatus=1 and e.empDecId =:empDecId") })
public class EmployeeDeclartion implements Serializable, CommonEntityInterface, Comparator<EmployeeDeclartion> {

    @Column(name = "HRA")
    @JsonProperty("hRA")
    @NotNull
    @Min(0)
    private Double hRA;

    @Column(name = "eightyC")
    @JsonProperty("eightyC")
    @NotNull
    @Min(0)
    private Double eightyC;

    @Column(name = "eightyD")
    @JsonProperty("eightyD")
    @NotNull
    @Min(0)
    private Double eightyD;

    @Column(name = "eightyG")
    @JsonProperty("eightyG")
    @NotNull
    @Min(0)
    private Double eightyG;

    @Column(name = "eightyE")
    @JsonProperty("eightyE")
    @NotNull
    @Min(0)
    private Double eightyE;

    @Column(name = "year")
    @JsonProperty("year")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer year;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "empDecId")
    @JsonProperty("empDecId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String empDecId;

    @Column(name = "empId")
    @JsonProperty("empId")
    private String empId;

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

    public Double gethRA() {
        return hRA;
    }

    public void sethRA(Double _hRA) {
        if (_hRA != null) {
            this.hRA = _hRA;
        }
    }

    public Double getEightyC() {
        return eightyC;
    }

    public void setEightyC(Double _eightyC) {
        if (_eightyC != null) {
            this.eightyC = _eightyC;
        }
    }

    public Double getEightyD() {
        return eightyD;
    }

    public void setEightyD(Double _eightyD) {
        if (_eightyD != null) {
            this.eightyD = _eightyD;
        }
    }

    public Double getEightyG() {
        return eightyG;
    }

    public void setEightyG(Double _eightyG) {
        if (_eightyG != null) {
            this.eightyG = _eightyG;
        }
    }

    public Double getEightyE() {
        return eightyE;
    }

    public void setEightyE(Double _eightyE) {
        if (_eightyE != null) {
            this.eightyE = _eightyE;
        }
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer _year) {
        if (_year != null) {
            this.year = _year;
        }
    }

    public String getPrimaryKey() {
        return empDecId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return empDecId;
    }

    public String getEmpDecId() {
        return empDecId;
    }

    public void setEmpDecId(String _empDecId) {
        this.empDecId = _empDecId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String _empId) {
        this.empId = _empId;
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
    public int compare(EmployeeDeclartion object1, EmployeeDeclartion object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((empId.toString() == null ? " " : empId.toString()) + ",");
        sb.append((year == null ? " " : year));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (empDecId == null) {
            return super.hashCode();
        } else {
            return empDecId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.payroll.EmployeeDeclartion other = (com.app.shared.payroll.EmployeeDeclartion) obj;
            if (empDecId == null) {
                return false;
            } else if (!empDecId.equals(other.empDecId)) {
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
