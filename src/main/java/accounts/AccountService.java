package accounts;

import dbservise.DBService;

import java.io.IOException;

public class AccountService {
    private final DBService dbService;

    public AccountService() {
        this.dbService = new DBService();
    }

    public void addUser(String login, String pass) {
        dbService.add(login, pass);
    }

    public boolean isRegistered(String login, String pass) {
        try {
            dbService.getId(login, pass);
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }
}
