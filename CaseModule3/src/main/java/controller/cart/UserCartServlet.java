package controller.cart;

import dao.product.ProductDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartDetail;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/CartServlet")
public class UserCartServlet extends HttpServlet {

    static public List<CartDetail> cartDetails = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");

        double totalPrice =0;

        List<Product> productList = new ArrayList<>();

        List<Double> prices = new ArrayList<>();

        for (CartDetail cart: cartDetails) {
            productList.add(ProductDao.FindProductById(cart.getId_product()));
        }
        for (int i = 0; i < cartDetails.size(); i++) {
            int index = productList.indexOf(new Product(cartDetails.get(i).getId_product()));
            totalPrice += cartDetails.get(i).getAmount() * productList.get(index).getPrice();
        }

        for (int i = 0; i < cartDetails.size(); i++) {
            int index = productList.indexOf(new Product(cartDetails.get(i).getId_product()));
            double price= cartDetails.get(i).getAmount() * productList.get(index).getPrice();
            prices.add(price);
        }
        req.setAttribute("totalPrice",totalPrice);
        req.setAttribute("prices",prices);
        req.setAttribute("productList", productList);
        req.setAttribute("cartDetails", cartDetails);
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/UserCartDetail.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        int id = Integer.parseInt(req.getParameter("productId"));
        int number = Integer.parseInt(req.getParameter("number"));
        int amount = ProductDao.FindAmountById(id);
        int afterBuy = amount - number;
        ProductDao.UpdateAfterBuy(id, afterBuy);


        boolean search = false;
        for (int i = 0; i < cartDetails.size(); i++) {
            if (cartDetails.get(i).getId_product() == id) {
                cartDetails.get(i).setAmount(cartDetails.get(i).getAmount() + number);
                search = true;
                break;
            }
        }
        if (search == false) {
            // them id account dung vao
            cartDetails.add(new CartDetail(1, id, number));
        }
        resp.sendRedirect("/showProductUser");
    }
}
