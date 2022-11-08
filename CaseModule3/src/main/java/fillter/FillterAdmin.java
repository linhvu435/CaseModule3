package fillter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/User/admin.jsp","/User/editUser.jsp","/User/ShowAccount.jsp","/Product/CreateProduct.jsp","/Product/ShowProduct.jsp",
        "/adminServlet","/deleteAccount","/editAccountServlet","/showAccount","/createProduct", "/deleteProduct"
})
public class FillterAdmin extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            res.sendRedirect("/User/login.jsp");
        } else if (account.getId_role() == 1) {
            chain.doFilter(req,res);
        } else {
            PrintWriter printWriter = res.getWriter();
            printWriter.println("<h1>Quyền Admin Không có quyền truy cập</h1>");
        }
    }
}
