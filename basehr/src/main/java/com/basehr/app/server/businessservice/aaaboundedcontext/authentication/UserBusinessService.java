package com.basehr.app.server.businessservice.aaaboundedcontext.authentication;
import com.basehr.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.basehr.app.shared.aaaboundedcontext.authentication.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserBusinessService {

    @Autowired
    private UserRepository userRepository;

    public void update(User entity) throws Exception {
        if (entity.isHardDelete()) {
            userRepository.delete(entity.getUserId());
        } else {
            userRepository.deletePassRecovery(entity.getDeletedPassRecoveryList());
            userRepository.update(entity);
        }
    }

    public void update(List<User> entity) throws Exception {
        for (User _user : entity) {
            if (_user.isHardDelete()) {
                userRepository.delete(_user.getUserId());
            } else {
                userRepository.deletePassRecovery(_user.getDeletedPassRecoveryList());
                userRepository.update(_user);
            }
        }
    }
}
