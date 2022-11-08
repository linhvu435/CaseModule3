package dao.product;

import dao.user.ConnectionMySQL;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static Connection connection = ConnectionMySQL.getConnection();
    public static List<Product> products ;
    public static List<Product> getAll() {
        String sql = "Select * from product";
        List<Product> products = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String img = resultSet.getString("img");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                products.add(new Product(id,type,img,name,price,amount));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
    public static void save(Product product) {
        try {
            String sql = "insert into product (type,img,name,price,amount) value (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getType());
            preparedStatement.setString(2,product.getImg());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setInt(5,product.getAmount());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdateProduct(Product product) {
        try {
            String sql = "UPDATE product set type = ?, img = ?,name = ?, price = ? ,amount = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(6,product.getId());
            preparedStatement.setString(1, product.getType());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getAmount());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM product WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int FindAmountById(int id){
        int amount =0;
        try{
            String sql = "Select amount from product where id =  "+ id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                amount = resultSet.getInt("amount");

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return amount;
    }
    public static void UpdateAfterBuy (int id, int number){
        try{
            String sql = "UPDATE product set amount = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2,id);
            preparedStatement.setInt(1,number);
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Product FindProductById(int id1)
    {
        Product products = null;
        try{
            String sql = "Select * from product where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id1);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String img = resultSet.getString("img");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                products = new Product(id,type,img,name,price,amount);
            }
            return products;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
