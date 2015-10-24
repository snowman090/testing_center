package core.user;

public interface AuthenticationService {
    boolean registeredUserId(String userId);

    boolean login (String userId, String password);
}
