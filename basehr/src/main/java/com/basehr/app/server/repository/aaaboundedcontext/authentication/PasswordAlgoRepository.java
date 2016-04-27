package com.basehr.app.server.repository.aaaboundedcontext.authentication;
import com.basehr.app.server.repository.core.SearchInterface;
import com.spartan.server.password.interfaces.PasswordAlgoRepositoryIntefrace;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.spartan.server.password.interfaces.PasswordAlgoInterface;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for PasswordAlgo Master table Entity", complexity = Complexity.LOW)
public interface PasswordAlgoRepository<T> extends SearchInterface, PasswordAlgoRepositoryIntefrace {

    public List<PasswordAlgoInterface> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public T findById(String algoId) throws Exception;
}
