package com.basehr.app.server.repository.aaaboundedcontext.authentication;
import com.basehr.app.server.repository.core.SearchInterface;
import com.spartan.server.interfaces.LoginSessionRepositoryInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for LoginSession Transaction table", complexity = Complexity.MEDIUM)
public interface LoginSessionRepository<T> extends SearchInterface, LoginSessionRepositoryInterface {
}