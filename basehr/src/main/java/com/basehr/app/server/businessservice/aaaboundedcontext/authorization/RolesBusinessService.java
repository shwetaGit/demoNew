package com.basehr.app.server.businessservice.aaaboundedcontext.authorization;
import com.basehr.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.basehr.app.shared.aaaboundedcontext.authorization.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RolesBusinessService {

    @Autowired
    private RolesRepository rolesRepository;

    public void update(Roles entity) throws Exception {
        if (entity.isHardDelete()) {
            rolesRepository.delete(entity.getRoleId());
        } else {
            rolesRepository.deleteRoleMenuBridge(entity.getDeletedRoleMenuBridgeList());
            rolesRepository.update(entity);
        }
    }

    public void update(List<Roles> entity) throws Exception {
        for (Roles _roles : entity) {
            if (_roles.isHardDelete()) {
                rolesRepository.delete(_roles.getRoleId());
            } else {
                rolesRepository.deleteRoleMenuBridge(_roles.getDeletedRoleMenuBridgeList());
                rolesRepository.update(_roles);
            }
        }
    }
}
