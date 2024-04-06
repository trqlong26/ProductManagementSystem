package dao;

import java.util.List;

import model.Category;

/**
 * ICategoryDAO
 */
public interface ICategoryDAO {
    // insert method
    public void insertCategory(List<Category> categories);

    // update method
    public void updateCategory(int categoryID, String categoryName);

    // delete by category's name method
    public void deleteCategory(String categoryName);

    // show all categories
    public void selectCategory();
}
