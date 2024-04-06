import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CategoryDAO;
import dao.ICategoryDAO;
import dao.IProductDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ICategoryDAO categoryDAO = new CategoryDAO();
        IProductDAO productDAO = new ProductDAO();

        System.out.println("Welcome to Product Management System");

        boolean exit = false;

        do {
            System.out.println("1. Categories Management");
            System.out.println("2. Products Management");
            System.out.println("3. Exit");
            System.out.print("Enter your choice(1-3): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manageCategories(categoryDAO);
                    break;
                case 2:
                    manageProducts(productDAO);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        } while (!exit);
    }

    // Manage categories method
    private static void manageCategories(ICategoryDAO categoryDAO) {
        boolean backToMenu = false;

        do {
            System.out.println("\n----- Categories Management -----");
            System.out.println("1. Add category");
            System.out.println("2. Update category");
            System.out.println("3. Delete category");
            System.out.println("4. Display all Categories");
            System.out.println("5. Back to main Menu");
            System.out.print("Enter your choice(1-5): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    List<Category> categories = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter category's name: ");
                        String categoryName = sc.nextLine();

                        categories.add(new Category(categoryName));

                        System.out.print("Do you want to add more? (yes/no): ");
                        String answer = sc.nextLine();
                        if (answer.equals("no")) {
                            break;
                        }
                    }
                    categoryDAO.insertCategory(categories);
                    break;
                case 2:
                    System.out.print("Enter category's id want to update: ");
                    int categoryID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new category name: ");
                    String newCategoryName = sc.nextLine();

                    categoryDAO.updateCategory(categoryID, newCategoryName);
                    break;
                case 3:
                    System.out.print("Enter category's name want to delete: ");
                    String categoryName = sc.nextLine();

                    categoryDAO.deleteCategory(categoryName);
                    break;
                case 4:
                    categoryDAO.selectCategory();
                    break;
                case 5:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        } while (!backToMenu);
    }

    // Manage products method
    private static void manageProducts(IProductDAO productDAO) {
        boolean backToMenu = false;

        do {
            System.out.println("\n----- Products Management -----");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Search product by category");
            System.out.println("5. Search product by product's code");
            System.out.println("6. Display all products");
            System.out.println("7. Display all products sort by unit price");
            System.out.println("8. Back to main menu");
            System.out.print("Enter your choice(1-6): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Insert product
                    List<Product> products = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter product's code: ");
                        String productCode = sc.nextLine();

                        System.out.print("Enter product's description: ");
                        String productDescription = sc.nextLine();

                        System.out.print("Enter product's unit price: ");
                        double unitPrice = sc.nextDouble();

                        System.out.print("Enter product's on hand quantity: ");
                        int onHandQuantity = sc.nextInt();

                        System.out.print("Enter product's category id: ");
                        int categoryID = sc.nextInt();

                        sc.nextLine();

                        products.add(
                                new Product(productCode, productDescription, unitPrice, onHandQuantity, categoryID));

                        System.out.print("Do you want to add more? (yes/no): ");
                        String answer = sc.nextLine();
                        if (answer.equals("no")) {
                            break;
                        }
                    }
                    productDAO.insertProduct(products);
                    break;
                case 2:
                    // Update Product
                    System.out.print("Enter product's code want to update: ");
                    String productCode = sc.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = sc.nextLine();
                    System.out.print("Enter new unit price: ");
                    double newUnitPrice = sc.nextDouble();
                    System.out.print("Enter new on hand quantity: ");
                    int newOnHandQuantity = sc.nextInt();
                    System.out.print("Enter new category id: ");
                    int newCategoryID = sc.nextInt();

                    productDAO.updateProduct(productCode, newDescription, newUnitPrice, newOnHandQuantity,
                            newCategoryID);
                    break;
                case 3:
                    // Delete Product
                    System.out.print("Enter product's code want to delete: ");
                    String deleteProductCode = sc.nextLine();

                    productDAO.deleteProduct(deleteProductCode);
                    break;
                case 4:
                    // Search Product by Category
                    System.out.print("Enter category name: ");
                    String categoryName = sc.nextLine();

                    productDAO.searchByCategory(categoryName);
                    break;
                case 5:
                    // Search by product's code
                    System.out.print("Enter product's code: ");
                    String targetProductCode = sc.nextLine();

                    productDAO.searchByProductCode(targetProductCode);
                    break;
                case 6:
                    // Display All Products
                    productDAO.selectProduct();
                    break;
                case 7:
                    // Display sorted unit price
                    productDAO.sortByUnitPrice();
                    break;
                case 8:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        } while (!backToMenu);
    }

}
