package com.basehr.app.server.repository.aaaboundedcontext.authorization;
import com.basehr.app.server.repository.core.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import java.util.List;
import com.basehr.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for Roles Transaction table", complexity = Complexity.MEDIUM)
public interface RolesRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void deleteRoleMenuBridge(List<RoleMenuBridge> rolemenubridge);

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public T findById(String roleId) throws Exception;
}
