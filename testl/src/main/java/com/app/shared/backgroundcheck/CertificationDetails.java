package com.app.shared.backgroundcheck;
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
import com.app.shared.documentmanager.DocumentList;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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

@Table(name = "ast_CertificationDetails_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "CertificationDetails", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "CertificationDetails.DefaultFinders", query = "select e from CertificationDetails e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId and e.certCode LIKE :certCode and e.grdCode LIKE :grdCode and e.obtainedDuration LIKE :obtainedDuration and e.instituteName LIKE :instituteName"), @javax.persistence.NamedQuery(name = "CertificationDetails.findByEmpId", query = "select e from CertificationDetails e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "CertificationDetails.findByCertCode", query = "select e from CertificationDetails e where e.systemInfo.activeStatus=1 and e.certCode=:certCode"), @javax.persistence.NamedQuery(name = "CertificationDetails.findByGrdCode", query = "select e from CertificationDetails e where e.systemInfo.activeStatus=1 and e.grdCode=:grdCode"), @javax.persistence.NamedQuery(name = "CertificationDetails.findById", query = "select e from CertificationDetails e where e.systemInfo.activeStatus=1 and e.certPk =:certPk") })
public class CertificationDetails implements Serializable, CommonEntityInterface, Comparator<CertificationDetails> {

    @Column(name = "obtainedDuration")
    @JsonProperty("obtainedDuration")
    @NotNull
    @Size(min = 0, max = 64)
    private String obtainedDuration;

    @Column(name = "instituteName")
    @JsonProperty("instituteName")
    @NotNull
    @Size(min = 0, max = 256)
    private String instituteName;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "certPk")
    @JsonProperty("certPk")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String certPk;

    @Column(name = "empId")
    @JsonProperty("empId")
    private String empId;

    @Column(name = "certCode")
    @JsonProperty("certCode")
    private String certCode;

    @Column(name = "grdCode")
    @JsonProperty("grdCode")
    private String grdCode;

    @JoinTable(name = "ast_UploadCertDoc_B", joinColumns = { @javax.persistence.JoinColumn(name = "certPk", referencedColumnName = "certPk") }, inverseJoinColumns = { @javax.persistence.JoinColumn(name = "docId", referencedColumnName = "docId") })
    @OneToMany(cascade = CascadeType.ALL)
    private List<DocumentList> documentList;

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

    public String getObtainedDuration() {
        return obtainedDuration;
    }

    public void setObtainedDuration(String _obtainedDuration) {
        if (_obtainedDuration != null) {
            this.obtainedDuration = _obtainedDuration;
        }
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String _instituteName) {
        if (_instituteName != null) {
            this.instituteName = _instituteName;
        }
    }

    public String getPrimaryKey() {
        return certPk;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return certPk;
    }

    public String getCertPk() {
        return certPk;
    }

    public void setCertPk(String _certPk) {
        this.certPk = _certPk;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String _empId) {
        this.empId = _empId;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String _certCode) {
        this.certCode = _certCode;
    }

    public String getGrdCode() {
        return grdCode;
    }

    public void setGrdCode(String _grdCode) {
        this.grdCode = _grdCode;
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

    public CertificationDetails addDocumentList(DocumentList _documentList) {
        if (this.documentList == null) {
            this.documentList = new java.util.ArrayList<com.app.shared.documentmanager.DocumentList>();
        }
        if (_documentList != null) {
            this.documentList.add(_documentList);
        }
        return this;
    }

    public CertificationDetails removeDocumentList(DocumentList _documentList) {
        if (this.documentList != null) {
            this.documentList.remove(_documentList);
        }
        return this;
    }

    public CertificationDetails addAllDocumentList(List<DocumentList> _documentList) {
        if (this.documentList == null) {
            this.documentList = new java.util.ArrayList<com.app.shared.documentmanager.DocumentList>();
        }
        if (_documentList != null) {
            this.documentList.addAll(_documentList);
        }
        return this;
    }

    @JsonIgnore
    public Integer sizeOfDocumentList() {
        if (this.documentList != null) {
            return this.documentList.size();
        }
        return 0;
    }

    public List<DocumentList> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<DocumentList> _documentList) {
        this.documentList = _documentList;
    }

    @JsonIgnore
    public List<DocumentList> getDeletedDocumentListList() {
        List<DocumentList> documentlistToRemove = new java.util.ArrayList<DocumentList>();
        for (DocumentList _documentlist : documentList) {
            if (_documentlist.isHardDelete()) {
                documentlistToRemove.add(_documentlist);
            }
        }
        documentList.removeAll(documentlistToRemove);
        return documentlistToRemove;
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
        setValidatordocumentList(_validateFactory);
    }

    private void setValidatordocumentList(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < documentList.size(); i++) {
            documentList.get(i).setEntityValidator(_validateFactory);
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
        if (this.documentList == null) {
            this.documentList = new java.util.ArrayList<DocumentList>();
        }
        for (DocumentList _documentList : documentList) {
            _documentList.setEntityAudit(customerId, userId, recordType);
            _documentList.setSystemInformation(recordType);
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
        if (this.documentList == null) {
            this.documentList = new java.util.ArrayList<DocumentList>();
        }
        for (DocumentList _documentList : documentList) {
            _documentList.setEntityAudit(customerId, userId);
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
    public int compare(CertificationDetails object1, CertificationDetails object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((empId.toString() == null ? " " : empId.toString()) + ",");
        sb.append((certCode.toString() == null ? " " : certCode.toString()) + ",");
        sb.append((grdCode.toString() == null ? " " : grdCode.toString()) + ",");
        sb.append((obtainedDuration == null ? " " : obtainedDuration) + ",");
        sb.append((instituteName == null ? " " : instituteName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (certPk == null) {
            return super.hashCode();
        } else {
            return certPk.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.backgroundcheck.CertificationDetails other = (com.app.shared.backgroundcheck.CertificationDetails) obj;
            if (certPk == null) {
                return false;
            } else if (!certPk.equals(other.certPk)) {
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
