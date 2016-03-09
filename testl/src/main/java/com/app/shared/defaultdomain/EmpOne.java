package com.app.shared.defaultdomain;
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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_EmpOne_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "shweta.zagade@algorhythm.co.in", versionNumber = "4", comments = "EmpOne", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "empId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "EmpOne.findById", query = "select e from EmpOne e where e.systemInfo.activeStatus=1 and e.empId =:empId") })
public class EmpOne implements Serializable, CommonEntityInterface, Comparator<EmpOne> {

    @Column(name = "empOne")
    @JsonProperty("empOne")
    @NotNull
    @Size(min = 0, max = 256)
    private String empOne;

    @Column(name = "empNew")
    @JsonProperty("empNew")
    @NotNull
    @Size(min = 0, max = 256)
    private String empNew;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "empId")
    @JsonProperty("empId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String empId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "empOne")
    private List<EmpTwo> empTwo;

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

    public String getEmpOne() {
        return empOne;
    }

    public void setEmpOne(String _empOne) {
        if (_empOne != null) {
            this.empOne = _empOne;
        }
    }

    public String getEmpNew() {
        return empNew;
    }

    public void setEmpNew(String _empNew) {
        if (_empNew != null) {
            this.empNew = _empNew;
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

    public EmpOne addEmpTwo(EmpTwo _empTwo) {
        if (this.empTwo == null) {
            this.empTwo = new java.util.ArrayList<com.app.shared.defaultdomain.EmpTwo>();
        }
        if (_empTwo != null) {
            _empTwo.setEmpOne(this);
            this.empTwo.add(_empTwo);
        }
        return this;
    }

    public EmpOne removeEmpTwo(EmpTwo _empTwo) {
        if (this.empTwo != null) {
            this.empTwo.remove(_empTwo);
        }
        return this;
    }

    public EmpOne addAllEmpTwo(List<EmpTwo> _empTwo) {
        if (this.empTwo == null) {
            this.empTwo = new java.util.ArrayList<com.app.shared.defaultdomain.EmpTwo>();
        }
        if (_empTwo != null) {
            for (int i = 0; i < _empTwo.size(); i++) {
                _empTwo.get(i).setEmpOne(this);
            }
            this.empTwo.addAll(_empTwo);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfEmpTwo() {
        if (this.empTwo != null) {
            return this.empTwo.size();
        }
        return 0;
    }

    public List<EmpTwo> getEmpTwo() {
        return empTwo;
    }

    public void setEmpTwo(List<EmpTwo> _empTwo) {
        for (int i = 0; i < _empTwo.size(); i++) {
            if (_empTwo.get(i).getEmpOne() == null) {
                _empTwo.get(i).setEmpOne(this);
            }
        }
        this.empTwo = _empTwo;
    }

    @JsonIgnore
    public List<EmpTwo> getDeletedEmpTwoList() {
        List<EmpTwo> emptwoToRemove = new java.util.ArrayList<EmpTwo>();
        for (EmpTwo _emptwo : empTwo) {
            if (_emptwo.isHardDelete()) {
                emptwoToRemove.add(_emptwo);
            }
        }
        empTwo.removeAll(emptwoToRemove);
        return emptwoToRemove;
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
        setValidatorempTwo(_validateFactory);
    }

    private void setValidatorempTwo(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < empTwo.size(); i++) {
            empTwo.get(i).setEntityValidator(_validateFactory);
        }
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
        if (this.empTwo == null) {
            this.empTwo = new java.util.ArrayList<EmpTwo>();
        }
        for (EmpTwo _empTwo : empTwo) {
            _empTwo.setEntityAudit(customerId, userId, recordType);
            _empTwo.setSystemInformation(recordType);
        }
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
        if (this.empTwo == null) {
            this.empTwo = new java.util.ArrayList<EmpTwo>();
        }
        for (EmpTwo _empTwo : empTwo) {
            _empTwo.setEntityAudit(customerId, userId);
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
            this.systemInfo.setActiveStatus(-1);
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
    public int compare(EmpOne object1, EmpOne object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((empOne == null ? " " : empOne) + ",");
        sb.append((empNew == null ? " " : empNew));
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
            com.app.shared.defaultdomain.EmpOne other = (com.app.shared.defaultdomain.EmpOne) obj;
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
