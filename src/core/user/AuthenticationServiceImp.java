package core.user;

import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationServiceImp implements AuthenticationService{
    @Override
    public boolean registeredUserId(String userId) {
        return false;
    }

    @Override
    public boolean login(String userId, String password) {
        return false;
    }
}
