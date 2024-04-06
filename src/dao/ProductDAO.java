package dao;

import java.sql.Connection;
import java.util.List;

import model.Product;

/**
 * ProductDAO
 */
public class ProductDAO implements IProductDAO {
    Connection conn;

    @Override
    public void deleteProduct(String productCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void insertProduct(List<Product> products) {
        // TODO Auto-generated method stub

    }

    @Override
    public void searchByCategory(String categoryName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void searchByProductCode(String productCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void selectProduct() {
        // TODO Auto-generated method stub

    }

    @Override
    public void sortByUnitPrice() {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateProduct(String productCode, String description, double unitPrice, int onHandQuantity,
            int categoryId) {
        // TODO Auto-generated method stub

    }
}
