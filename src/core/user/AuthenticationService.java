package core.user;

public interface AuthenticationService {
    boolean registeredUserId(String userId);

    Authorization login (String userId, String password);
}
