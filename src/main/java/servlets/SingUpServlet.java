package servlets;

import accounts.AccountService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SingUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SingUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        accountService.addUser(login, pass);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
