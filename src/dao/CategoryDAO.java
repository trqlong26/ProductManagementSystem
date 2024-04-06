package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Category;
import utils.DatabaseConnection;

/**
 * CategoryDAO
 */
public class CategoryDAO implements ICategoryDAO {

    @Override
    public void deleteCategory(String categoryName) {
        // TODO Auto-generated method stub
        String sqlQuery = "DELETE FROM category WHERE CategoryName = ?";

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
            pstmt.setString(1, categoryName);

            pstmt.executeUpdate();

            System.out.println("Delete" + categoryName + "successfully");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void insertCategory(List<Category> categories) {
        String sqlQuery = "INSERT INTO category (CategoryID, CategoryName) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {

            conn.setAutoCommit(false);

            for (Category category : categories) {
                pstmt.setInt(1, category.getCategoryID());
                pstmt.setString(2, category.getCategoryName());
                pstmt.addBatch();
            }

            int[] executeResult = pstmt.executeBatch();

            for (int result : executeResult) {
                if (result == PreparedStatement.EXECUTE_FAILED) {
                    System.out.println("One or more statements failed to execute.");
                    return;
                }
            }

            conn.commit();
            System.out.println("Insert to category successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectCategory() {
        // TODO Auto-generated method stub
        String sqlQuery = "SELECT * FROM category";

        System.out.println("----------------------------------------");
        System.out.println("                 Categories             ");
        System.out.println("----------------------------------------");
        System.out.format("%-5s | %-10s%n", "ID", "Name");
        System.out.println("----------------------------------------");

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
                ResultSet result = pstmt.executeQuery()) {
            while (result.next()) {
                System.out.format("%-5d | %-10s%n", result.getInt(1), result.getString(2));
            }

            System.out.println("----------------------------------------");

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Override
    public void updateCategory(int categoryID, String categoryName) {
        // TODO Auto-generated method stub
        String sqlQuery = "UPDATE category SET CategoryName = ? WHERE CategoryID = ?";

        try (Connection conn = DatabaseConnection.connection();
                PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {
            pstmt.setString(1, categoryName);
            pstmt.setInt(2, categoryID);

            pstmt.executeUpdate();

            System.out.println("Update successfully !");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}