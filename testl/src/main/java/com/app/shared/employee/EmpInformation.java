package com.app.shared.employee;
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
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.app.shared.contacts.CoreContacts;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

@Table(name = "ast_EmpInformation_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "EmpInformation", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "EmpInformation.DefaultFinders", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.coreContacts.contactId LIKE :contactId and e.deptTypeCode LIKE :deptTypeCode and e.designatnTypeCode LIKE :designatnTypeCode and e.reportingOfficer LIKE :reportingOfficer and e.jobCode LIKE :jobCode and e.visaCode LIKE :visaCode and e.pAN LIKE :pAN"), @javax.persistence.NamedQuery(name = "EmpInformation.findByContactId", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.coreContacts.contactId=:contactId"), @javax.persistence.NamedQuery(name = "EmpInformation.findByDeptTypeCode", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.deptTypeCode=:deptTypeCode"), @javax.persistence.NamedQuery(name = "EmpInformation.findByDesignatnTypeCode", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.designatnTypeCode=:designatnTypeCode"), @javax.persistence.NamedQuery(name = "EmpInformation.findByJobCode", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.jobCode=:jobCode"), @javax.persistence.NamedQuery(name = "EmpInformation.findByVisaCode", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.visaCode=:visaCode"), @javax.persistence.NamedQuery(name = "EmpInformation.findById", query = "select e from EmpInformation e where e.systemInfo.activeStatus=1 and e.empId =:empId") })
public class EmpInformation implements Serializable, CommonEntityInterface, Comparator<EmpInformation> {

    @Column(name = "reportingOfficer")
    @JsonProperty("reportingOfficer")
    @NotNull
    @Size(min = 0, max = 128)
    private String reportingOfficer;

    @Column(name = "PAN")
    @JsonProperty("pAN")
    @NotNull
    @Size(min = 0, max = 64)
    private String pAN;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "empId")
    @JsonProperty("empId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String empId;

    @Column(name = "deptTypeCode")
    @JsonProperty("deptTypeCode")
    private String deptTypeCode;

    @Column(name = "designatnTypeCode")
    @JsonProperty("designatnTypeCode")
    private String designatnTypeCode;

    @Column(name = "jobCode")
    @JsonProperty("jobCode")
    private String jobCode;

    @Column(name = "visaCode")
    @JsonProperty("visaCode")
    private String visaCode;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "contactId", referencedColumnName = "contactId")
    private CoreContacts coreContacts;

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

    public String getReportingOfficer() {
        return reportingOfficer;
    }

    public void setReportingOfficer(String _reportingOfficer) {
        if (_reportingOfficer != null) {
            this.reportingOfficer = _reportingOfficer;
        }
    }

    public String getpAN() {
        return pAN;
    }

    public void setpAN(String _pAN) {
        if (_pAN != null) {
            this.pAN = _pAN;
        }
    }

    public String getPrimaryKey() {
        return empId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String _empId) {
        this.empId = _empId;
    }

    public String getDeptTypeCode() {
        return deptTypeCode;
    }

    public void setDeptTypeCode(String _deptTypeCode) {
        this.deptTypeCode = _deptTypeCode;
    }

    public String getDesignatnTypeCode() {
        return designatnTypeCode;
    }

    public void setDesignatnTypeCode(String _designatnTypeCode) {
        this.designatnTypeCode = _designatnTypeCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String _jobCode) {
        this.jobCode = _jobCode;
    }

    public String getVisaCode() {
        return visaCode;
    }

    public void setVisaCode(String _visaCode) {
        this.visaCode = _visaCode;
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

    public CoreContacts getCoreContacts() {
        return coreContacts;
    }

    public void setCoreContacts(CoreContacts _coreContacts) {
        this.coreContacts = _coreContacts;
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
    public int compare(EmpInformation object1, EmpInformation object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((coreContacts.getPrimaryDisplay().toString() == null ? " " : coreContacts.getPrimaryDisplay().toString()) + ",");
        sb.append((pAN == null ? " " : pAN));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (empId == null) {
            return super.hashCode();
        } else {
            return empId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.employee.EmpInformation other = (com.app.shared.employee.EmpInformation) obj;
            if (empId == null) {
                return false;
            } else if (!empId.equals(other.empId)) {
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
