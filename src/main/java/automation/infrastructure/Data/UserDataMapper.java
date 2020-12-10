package automation.infrastructure.Data;

public interface UserDataMapper {

    User getUserByEmail(String email);

    User getUserByUserName(String userName);
}
