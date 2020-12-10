package automation.infrastructure.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class FileUserDataMapper implements UserDataMapper {

    private ArrayList<User> users = new ArrayList();

    public FileUserDataMapper() {
        try {
            FileReader fr = new FileReader("users.txt");
            try (BufferedReader bf = new BufferedReader(fr)) {

                String line = "";

                while ((line = bf.readLine()) != null) {
                    String userData[] = line.split(",");
                    users.add(new User(userData[1], userData[0], userData[2]));
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException("File was not open", ex);
        }
    }

    public List<User> users() {
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByUserName(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }

        }
        throw new UserNotFoundException();
    }
}