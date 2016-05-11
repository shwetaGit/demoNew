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
import java.sql.Date;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.athena.config.jsonHandler.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomJsonTimestampSerializer;
import com.athena.config.jsonHandler.CustomJsonTimestampDeserializer;
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

@Table(name = "ast_AttendenceDetails_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "AttendenceDetails", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "AttendenceDetails.DefaultFinders", query = "select e from AttendenceDetails e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId and e.inTime > :inTime and e.outTime > :outTime"), @javax.persistence.NamedQuery(name = "AttendenceDetails.findByEmpId", query = "select e from AttendenceDetails e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "AttendenceDetails.findById", query = "select e from AttendenceDetails e where e.systemInfo.activeStatus=1 and e.attendenceId =:attendenceId") })
public class AttendenceDetails implements Serializable, CommonEntityInterface, Comparator<AttendenceDetails> {

    @Column(name = "attendenceDate")
    @JsonProperty("attendenceDate")
    @NotNull
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date attendenceDate;

    @Column(name = "present")
    @JsonProperty("present")
    @NotNull
    private Boolean present;

    @Column(name = "absent")
    @JsonProperty("absent")
    @NotNull
    private Boolean absent;

    @Column(name = "privilege")
    @JsonProperty("privilege")
    @NotNull
    private Boolean privilege;

    @Column(name = "casualLeave")
    @JsonProperty("casualLeave")
    @NotNull
    private Boolean casualLeave;

    @Column(name = "sickLeave")
    @JsonProperty("sickLeave")
    @NotNull
    private Boolean sickLeave;

    @Column(name = "maternityLeave")
    @JsonProperty("maternityLeave")
    @NotNull
    private Boolean maternityLeave;

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

    @Column(name = "inTime")
    @JsonProperty("inTime")
    @NotNull
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp inTime;

    @Column(name = "outTime")
    @JsonProperty("outTime")
    @NotNull
    @JsonSerialize(using = CustomJsonTimestampSerializer.class)
    @JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
    private Timestamp outTime;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "attendenceId")
    @JsonProperty("attendenceId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String attendenceId;

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

    public Date getAttendenceDate() {
        return attendenceDate;
    }

    public void setAttendenceDate(Date _attendenceDate) {
        if (_attendenceDate != null) {
            this.attendenceDate = _attendenceDate;
        }
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean _present) {
        if (_present != null) {
            this.present = _present;
        }
    }

    public Boolean getAbsent() {
        return absent;
    }

    public void setAbsent(Boolean _absent) {
        if (_absent != null) {
            this.absent = _absent;
        }
    }

    public Boolean getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Boolean _privilege) {
        if (_privilege != null) {
            this.privilege = _privilege;
        }
    }

    public Boolean getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(Boolean _casualLeave) {
        if (_casualLeave != null) {
            this.casualLeave = _casualLeave;
        }
    }

    public Boolean getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(Boolean _sickLeave) {
        if (_sickLeave != null) {
            this.sickLeave = _sickLeave;
        }
    }

    public Boolean getMaternityLeave() {
        return maternityLeave;
    }

    public void setMaternityLeave(Boolean _maternityLeave) {
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

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp _inTime) {
        if (_inTime != null) {
            this.inTime = _inTime;
        }
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp _outTime) {
        if (_outTime != null) {
            this.outTime = _outTime;
        }
    }

    public String getPrimaryKey() {
        return attendenceId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return attendenceId;
    }

    public String getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(String _attendenceId) {
        this.attendenceId = _attendenceId;
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
    public int compare(AttendenceDetails object1, AttendenceDetails object2) {
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
        if (attendenceId == null) {
            return super.hashCode();
        } else {
            return attendenceId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.attendance.AttendenceDetails other = (com.app.shared.attendance.AttendenceDetails) obj;
            if (attendenceId == null) {
                return false;
            } else if (!attendenceId.equals(other.attendenceId)) {
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
