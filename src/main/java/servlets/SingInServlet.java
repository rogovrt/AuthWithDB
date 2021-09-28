package servlets;

import accounts.AccountService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SingInServlet extends HttpServlet {
        private final AccountService accountService;

        public SingInServlet(AccountService accountService) {
            this.accountService = accountService;
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            if (accountService.isRegistered(login, pass)) {
                response.setStatus(200);
                response.getWriter().println("Authorized: " + login);
            }
            else {
                response.setStatus(401);
                response.getWriter().println("Unauthorized");
            }
        }
}
