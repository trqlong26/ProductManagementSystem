package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Product;
import utils.DatabaseConnection;

/**
 * ProductDAO
 */
public class ProductDAO implements IProductDAO {

    @Override
    public void deleteProduct(String productCode) {
        // TODO Auto-generated method stub
        String sqlQuery = "DELETE FROM products WHERE ProductCode = ?";
        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
            pstmt.setString(1, productCode);

            pstmt.executeUpdate();
            System.out.println("Delete " + productCode + "Successfully !");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void insertProduct(List<Product> products) {
        // TODO Auto-generated method stub
        String sqlQuery = "INSERT INTO products (ProductCode, Description, UnitPrice, OnHandQuantity, CategoryID) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
            conn.setAutoCommit(false);

            for (Product product : products) {
                pstmt.setString(1, product.getProductCode());
                pstmt.setString(2, product.getDescription());
                pstmt.setDouble(3, product.getUnitPrice());
                pstmt.setInt(4, product.getOnHandQuantity());
                pstmt.setInt(5, product.getCategoryId());

                pstmt.addBatch();
            }

            int[] excecuteResult = pstmt.executeBatch();

            for (int result : excecuteResult) {
                if (result == PreparedStatement.EXECUTE_FAILED) {
                    System.out.println("One or more statements failed to execute.");
                    return;
                }
            }

            conn.commit();
            System.out.println("Insert into products successfully !");

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void searchByCategory(String categoryName) {
        String sqlQuery = "SELECT * FROM products p " +
                "INNER JOIN category c ON p.CategoryID = c.CategoryID " +
                "WHERE c.CategoryName = ?";

        System.out.println("----------------------------------------");
        System.out.println("                 Products             ");
        System.out.println("----------------------------------------");
        System.out.format("%-10s | %-20s | %-10s | %-15s | %-10s%n", "ProductCode", "Description", "UnitPrice",
                "OnHandQuantity", "CategoryID");
        System.out.println("----------------------------------------");

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
            pstmt.setString(1, categoryName);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                System.out.format("%-10s | %-20s | %-10.2f | %-15d | %-10d%n", result.getString(1), result.getString(2),
                        result.getDouble(3), result.getInt(4), result.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchByProductCode(String productCode) {
        // TODO Auto-generated method stub
        String sqlQuery = "SELECT * FROM products WHERE ProductCode = ?";

        System.out.println("----------------------------------------");
        System.out.println("                 Products             ");
        System.out.println("----------------------------------------");
        System.out.format("%-10s | %-20s | %-10s | %-15s | %-10s%n", "ProductCode", "Description", "UnitPrice",
                "OnHandQuantity", "CategoryID");
        System.out.println("----------------------------------------");

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
                ResultSet result = pstmt.executeQuery()) {
            while (result.next()) {
                System.out.format("%-10s | %-20s | %-10.2f | %-15d | %-10d%n", result.getString(1), result.getString(2),
                        result.getDouble(3), result.getInt(4), result.getInt(5));
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void selectProduct() {
        // TODO Auto-generated method stub
        String sqlQuery = "SELECT * FROM products";

        System.out.println("----------------------------------------");
        System.out.println("                 Products             ");
        System.out.println("----------------------------------------");
        System.out.format("%-10s | %-20s | %-10s | %-15s | %-10s%n", "ProductCode", "Description", "UnitPrice",
                "OnHandQuantity", "CategoryID");
        System.out.println("----------------------------------------");

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
                ResultSet result = pstmt.executeQuery()) {
            while (result.next()) {
                System.out.format("%-10s | %-20s | %-10.2f | %-15d | %-10d%n", result.getString(1), result.getString(2),
                        result.getDouble(3), result.getInt(4), result.getInt(5));

            }
            System.out.println("----------------------------------------");

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void sortByUnitPrice() {
        // TODO Auto-generated method stub
        String sqlQuery = "SELECT * FROM products ORDER BY UnitPrice ASC";

        System.out.println("----------------------------------------");
        System.out.println("                 Products             ");
        System.out.println("----------------------------------------");
        System.out.format("%-10s | %-20s | %-10s | %-15s | %-10s%n", "ProductCode", "Description", "UnitPrice",
                "OnHandQuantity", "CategoryID");
        System.out.println("----------------------------------------");

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
                ResultSet result = pstmt.executeQuery()) {
            while (result.next()) {
                System.out.format("%-10s | %-20s | %-10.2f | %-15d | %-10d%n", result.getString(1), result.getString(2),
                        result.getDouble(3), result.getInt(4), result.getInt(5));
            }
            System.out.println("----------------------------------------");

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void updateProduct(String productCode, String description, double unitPrice, int onHandQuantity,
            int categoryId) {
        String sqlQuery = "UPDATE products SET Description = ?, UnitPrice = ?, OnHandQuantity = ?, CategoryID = ? WHERE ProductCode = ?";

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
            pstmt.setString(1, description);
            pstmt.setDouble(2, unitPrice);
            pstmt.setInt(3, onHandQuantity);
            pstmt.setInt(4, categoryId);
            pstmt.setString(5, productCode);

            pstmt.executeUpdate();

            System.out.println("Update successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
