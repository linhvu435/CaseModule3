package controller.user;

import dao.user.LoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;

@WebServlet(urlPatterns = ("/login"))
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = LoginDao.login(username,password);
        if(account != null){
            if (account.getId_role() == 1)
            {
                session.setAttribute("account", account);
                resp.sendRedirect("/adminServlet");
            }
            else {
                session.setAttribute("account", account);
                resp.sendRedirect("/showProductUser");
            }

        }else {
            req.setAttribute("messeger","Lỗi rồi kiểm tra lại!!!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("User/login.jsp");
            dispatcher.forward(req,resp);
        }

    }

}
