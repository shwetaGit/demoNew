package com.app.shared.attendance;
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

@Table(name = "ast_AttendenceSummary_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "AttendenceSummary", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "AttendenceSummary.DefaultFinders", query = "select e from AttendenceSummary e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId"), @javax.persistence.NamedQuery(name = "AttendenceSummary.findByEmpId", query = "select e from AttendenceSummary e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "AttendenceSummary.findById", query = "select e from AttendenceSummary e where e.systemInfo.activeStatus=1 and e.attendenceSummaryId =:attendenceSummaryId") })
public class AttendenceSummary implements Serializable, CommonEntityInterface, Comparator<AttendenceSummary> {

    @Column(name = "present")
    @JsonProperty("present")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer present;

    @Column(name = "absent")
    @JsonProperty("absent")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer absent;

    @Column(name = "privilege")
    @JsonProperty("privilege")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer privilege;

    @Column(name = "casualLeave")
    @JsonProperty("casualLeave")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer casualLeave;

    @Column(name = "sickLeave")
    @JsonProperty("sickLeave")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer sickLeave;

    @Column(name = "maternityLeave")
    @JsonProperty("maternityLeave")
    @NotNull
    @Min(0)
    @Max(10)
    private Integer maternityLeave;

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

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "attendenceSummaryId")
    @JsonProperty("attendenceSummaryId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String attendenceSummaryId;

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

    public Integer getPresent() {
        return present;
    }

    public void setPresent(Integer _present) {
        if (_present != null) {
            this.present = _present;
        }
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer _absent) {
        if (_absent != null) {
            this.absent = _absent;
        }
    }

    public Integer getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer _privilege) {
        if (_privilege != null) {
            this.privilege = _privilege;
        }
    }

    public Integer getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(Integer _casualLeave) {
        if (_casualLeave != null) {
            this.casualLeave = _casualLeave;
        }
    }

    public Integer getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(Integer _sickLeave) {
        if (_sickLeave != null) {
            this.sickLeave = _sickLeave;
        }
    }

    public Integer getMaternityLeave() {
        return maternityLeave;
    }

    public void setMaternityLeave(Integer _maternityLeave) {
        if (_maternityLeave != null) {
            this.maternityLeave = _maternityLeave;
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

    public String getPrimaryKey() {
        return attendenceSummaryId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return attendenceSummaryId;
    }

    public String getAttendenceSummaryId() {
        return attendenceSummaryId;
    }

    public void setAttendenceSummaryId(String _attendenceSummaryId) {
        this.attendenceSummaryId = _attendenceSummaryId;
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
    public int compare(AttendenceSummary object1, AttendenceSummary object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((empId.toString() == null ? " " : empId.toString()));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (attendenceSummaryId == null) {
            return super.hashCode();
        } else {
            return attendenceSummaryId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.attendance.AttendenceSummary other = (com.app.shared.attendance.AttendenceSummary) obj;
            if (attendenceSummaryId == null) {
                return false;
            } else if (!attendenceSummaryId.equals(other.attendenceSummaryId)) {
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
