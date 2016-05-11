package com.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for EmpInformation Transaction table", complexity = Complexity.MEDIUM)
public interface EmpInformationRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByContactId(String contactId) throws Exception, SpartanPersistenceException;

    public List<T> findByDeptTypeCode(String deptTypeCode) throws Exception, SpartanPersistenceException;

    public List<T> findByDesignatnTypeCode(String designatnTypeCode) throws Exception, SpartanPersistenceException;

    public List<T> findByJobCode(String jobCode) throws Exception, SpartanPersistenceException;

    public List<T> findByVisaCode(String visaCode) throws Exception, SpartanPersistenceException;

    public T findById(String empId) throws Exception, SpartanPersistenceException;
}
