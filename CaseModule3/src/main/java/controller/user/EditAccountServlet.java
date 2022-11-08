package controller.user;
import dao.product.ProductDao;
import dao.user.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Product;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/editAccountServlet")
public class EditAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        int id = Integer.parseInt(req.getParameter("id"));
        for (Account a: AccountDao.getAll()) {
            if(a.getId() == id)
            {
                req.setAttribute("a", a);
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/editUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        String phonenumber = req.getParameter("phonenumber");
        int id_role = Integer.parseInt(req.getParameter("id_role"));
        AccountDao.UpdateAccount(new Account(id,username,password,address,birthday,phonenumber,id_role));
        resp.sendRedirect("/showAccount");
    }
}
