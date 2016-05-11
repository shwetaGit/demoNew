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

@Table(name = "ast_PaySlip_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "PaySlip", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "PaySlip.DefaultFinders", query = "select e from PaySlip e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId"), @javax.persistence.NamedQuery(name = "PaySlip.findByEmpId", query = "select e from PaySlip e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "PaySlip.findById", query = "select e from PaySlip e where e.systemInfo.activeStatus=1 and e.salaryId =:salaryId") })
public class PaySlip implements Serializable, CommonEntityInterface, Comparator<PaySlip> {

    @Column(name = "basic")
    @JsonProperty("basic")
    @NotNull
    @Min(0)
    private Double basic;

    @Column(name = "hra")
    @JsonProperty("hra")
    @NotNull
    @Min(0)
    private Double hra;

    @Column(name = "convenceAllowance")
    @JsonProperty("convenceAllowance")
    @NotNull
    @Min(0)
    private Double convenceAllowance;

    @Column(name = "medicalAllowance")
    @JsonProperty("medicalAllowance")
    @NotNull
    @Min(0)
    private Double medicalAllowance;

    @Column(name = "educationalAllowance")
    @JsonProperty("educationalAllowance")
    @NotNull
    @Min(0)
    private Double educationalAllowance;

    @Column(name = "specailAllowance")
    @JsonProperty("specailAllowance")
    @NotNull
    @Min(0)
    private Double specailAllowance;

    @Column(name = "tax")
    @JsonProperty("tax")
    @NotNull
    @Min(0)
    private Double tax;

    @Column(name = "takeHome")
    @JsonProperty("takeHome")
    @NotNull
    @Min(0)
    private Double takeHome;

    @Column(name = "year")
    @JsonProperty("year")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer year;

    @Column(name = "month")
    @JsonProperty("month")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer month;

    @Column(name = "lop")
    @JsonProperty("lop")
    @NotNull
    @Min(0)
    private Double lop;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "salaryId")
    @JsonProperty("salaryId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String salaryId;

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

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double _basic) {
        if (_basic != null) {
            this.basic = _basic;
        }
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double _hra) {
        if (_hra != null) {
            this.hra = _hra;
        }
    }

    public Double getConvenceAllowance() {
        return convenceAllowance;
    }

    public void setConvenceAllowance(Double _convenceAllowance) {
        if (_convenceAllowance != null) {
            this.convenceAllowance = _convenceAllowance;
        }
    }

    public Double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(Double _medicalAllowance) {
        if (_medicalAllowance != null) {
            this.medicalAllowance = _medicalAllowance;
        }
    }

    public Double getEducationalAllowance() {
        return educationalAllowance;
    }

    public void setEducationalAllowance(Double _educationalAllowance) {
        if (_educationalAllowance != null) {
            this.educationalAllowance = _educationalAllowance;
        }
    }

    public Double getSpecailAllowance() {
        return specailAllowance;
    }

    public void setSpecailAllowance(Double _specailAllowance) {
        if (_specailAllowance != null) {
            this.specailAllowance = _specailAllowance;
        }
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double _tax) {
        if (_tax != null) {
            this.tax = _tax;
        }
    }

    public Double getTakeHome() {
        return takeHome;
    }

    public void setTakeHome(Double _takeHome) {
        if (_takeHome != null) {
            this.takeHome = _takeHome;
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer _month) {
        if (_month != null) {
            this.month = _month;
        }
    }

    public Double getLop() {
        return lop;
    }

    public void setLop(Double _lop) {
        if (_lop != null) {
            this.lop = _lop;
        }
    }

    public String getPrimaryKey() {
        return salaryId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return salaryId;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String _salaryId) {
        this.salaryId = _salaryId;
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
    public int compare(PaySlip object1, PaySlip object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((year == null ? " " : year) + ",");
        sb.append((month == null ? " " : month));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (salaryId == null) {
            return super.hashCode();
        } else {
            return salaryId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.payroll.PaySlip other = (com.app.shared.payroll.PaySlip) obj;
            if (salaryId == null) {
                return false;
            } else if (!salaryId.equals(other.salaryId)) {
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
