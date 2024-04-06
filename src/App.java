import java.util.ArrayList;
import java.util.List;

import dao.CategoryDAO;
import dao.ICategoryDAO;
import model.Category;

public class App {
    public static void main(String[] args) throws Exception {
        // ICategoryDAO categoryDAO = new CategoryDAO();
        // List<Category> categories = new ArrayList<>();
        // categories.add(new Category("Quan ao"));

        // categoryDAO.insertCategory(categories);

        // IPropertyDAO propertyDAO = new PropertyDAO();
        // System.out.println("Welcome to Property Management System");

        // Scanner sc = new Scanner(System.in);
        // boolean exit = false;

        // do {
        //     System.out.println("1. Add properties");
        //     System.out.println("2. Show all properties");
        //     System.out.println("3. Search");
        //     System.out.println("4. Delete");
        //     System.out.println("5. Update");
        //     System.out.println("6. Exit");
        //     System.out.print("Enter choice (1 - 6): ");

        //     int choice = sc.nextInt();
        //     sc.nextLine();

        //     switch (choice) {
        //         case 1:
        //             List<Property> properties = new ArrayList<>();
        //             System.out.println("Enter properties to add (MaTaiSan, TenTaiSan, GiaTri): ");
        //             while (true) {
        //                 System.out.print("Enter MaTaiSan: ");
        //                 String maTaiSan = sc.nextLine();
        //                 System.out.print("Enter TenTaiSan: ");
        //                 String tenTaiSan = sc.nextLine();
        //                 System.out.print("Enter GiaTri: ");
        //                 double giaTri = sc.nextDouble();
        //                 sc.nextLine();

        //                 properties.add(new Property(maTaiSan, tenTaiSan, giaTri));

        //                 System.out.print("Do you want to add another property? (yes/no): ");
        //                 String answer = sc.nextLine();
        //                 if (answer.equalsIgnoreCase("no")) {
        //                     break;
        //                 }
        //             }
        //             propertyDAO.insertData(properties);
        //             break;

        //         case 2:
        //             propertyDAO.selectData();
        //             break;
        //         case 3:
        //             System.out.print("Enter keyword for properties: ");
        //             String keyword = sc.nextLine();
        //             propertyDAO.search(keyword);
        //             break;
        //         case 4:
        //             System.out.print("Enter MaTaiSan to delete: ");
        //             String MaTaiSan = sc.nextLine();
        //             propertyDAO.delete(MaTaiSan);
        //             break;
        //         case 5:
        //             System.out.print("Enter MaTaiSan to update: ");
        //             String MaTaiSanUpdate = sc.nextLine();
        //             System.out.print("Enter new TenTaiSan: ");
        //             String newTenTaiSan = sc.nextLine();
        //             System.out.print("Enter new GiaTri: ");
        //             double newGiaTri = sc.nextDouble();
        //             sc.nextLine();

        //             propertyDAO.update(MaTaiSanUpdate, newTenTaiSan, newGiaTri);
        //             break;
        //         case 6:
        //             exit = true;
        //             break;

        //         default:
        //             System.out.println("Please enter valid choice !");
        //             break;
        //     }
        // } while (!exit);

        // sc.close();
    }
}
