package dao;

import java.util.List;

import model.Product;

/**
 * IProductDAO
 */
public interface IProductDAO {
    // insert method
    public void insertProduct(List<Product> products);

    // update method
    public void updateProduct(String productCode,
            String description,
            double unitPrice,
            int onHandQuantity,
            int categoryId);

    // delete by product's code method
    public void deleteProduct(String productCode);

    // show all products method
    public void selectProduct();

    // search by category's name method
    public void searchByCategory(String categoryName);

    // sort by unit price method
    public void sortByUnitPrice();

    // search by product's code
    public void searchByProductCode(String productCode);
}
