import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        final String FILENAME = "products.txt";
        ProductStore store = new ProductStore();

        if (!store.loadFromFile(FILENAME)) {
            System.out.println("file khong tontai. Sinh 20 san pham ngau nhien");
            store.generateRandomProducts(20);
            store.saveToFile(FILENAME);
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Hien thi toan bo san pham");
            System.out.println("2. Them san pham moi");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Tim theo ten");
            System.out.println("5. Sap xep theo ten");
            System.out.println("6. Sap xep theo gia");
            System.out.println("7. Sinh them 20 san pham ngau nhien");
            System.out.println("8. Luu vao file text");
            System.out.println("9. Sap xep theo id");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            String c = sc.nextLine();

            switch (c) {
                case "1":
                    store.displayAll();
                    break;
                case "2":
                    String id = store.nextId();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Brand: "); String brand = sc.nextLine();
                    System.out.print("Engine (cc): "); int eng = Integer.parseInt(sc.nextLine());
                    System.out.print("Fuel (L): "); double fuel = Double.parseDouble(sc.nextLine());
                    System.out.print("Size: "); String size = sc.nextLine();
                    System.out.print("Color: "); String color = sc.nextLine();
                    System.out.print("Price: "); double price = Double.parseDouble(sc.nextLine());
                    store.addProduct(new Product(id, name, brand, eng, fuel, size, color, price));
                    break;
                case "3":
                    System.out.print("Nhap ID de xoa: ");
                    store.removeById(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Tim kiem: ");
                    List<Product> found = store.searchByName(sc.nextLine());
                    if (found.isEmpty()) System.out.println("No results!");
                    else found.forEach(System.out::println);
                    break;
                case "5":
                    System.out.print("Tang dan (true/false)? ");
                    store.sortByName(Boolean.parseBoolean(sc.nextLine()));
                    store.displayAll();
                    break;
                case "6":
                    System.out.print("Tang dan (true/false)? ");
                    store.sortByPrice(Boolean.parseBoolean(sc.nextLine()));
                    store.displayAll();
                    break;
                case "7":
                    store.generateRandomProducts(20);
                    break;
                case "8":
                    if (store.saveToFile(FILENAME)) System.out.println("Luu thang cong!");
                    else System.out.println("Luu that bai!");
                    break;
                case "9":
                    store.sortById(true);
                    store.displayAll();
                    break;
                case "0":
                    System.out.println("Thoat!");
                    sc.close();
                    return;
                default:
                    System.out.println("Khong hop le!");
            }
        }
    }
}
