
import java.util.*;
import java.io.*;

public class ProductStore {

    private ArrayList<Product> list = new ArrayList<>();
    private int idCounter = 1;

    public String nextId() {
        return String.format("MB%04d", idCounter++);
    }

    public void addProduct(Product p) {
        list.add(p);
        System.out.println("Them thanh cong!");
    }

    public void removeById(String id) {
        Product p = findById(id);
        if (p == null) {
            System.out.println("san pham khong ton tai!");
            return;
        }
        list.remove(p);
        System.out.println("Xoa thanh cong!");
    }

    public Product findById(String id) {
        for (Product p : list) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> searchByName(String keyword) {
        ArrayList<Product> res = new ArrayList<>();
        for (Product p : list) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                res.add(p);
            }
        }
        return res;
    }

    public void generateRandomProducts(int n) {
        for (int i = 0; i < n; i++) {
            list.add(new Product(
                    nextId(),
                    MyUtils.randomName(),
                    MyUtils.randomBrand(),
                    MyUtils.randomEngine(),
                    MyUtils.randomFuel(),
                    MyUtils.randomSize(),
                    MyUtils.randomColor(),
                    MyUtils.randomPrice()
            ));
        }
        System.out.println("Generated " + n + " random products.");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No products available!");
            return;
        }
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Product p : list) {
                pw.println(p.saveData());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                Product p = Product.readData(line);
                if (p != null) {
                    list.add(p);
                }
            }
            idCounter = list.size() + 1;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void sortByName(boolean ascending) {
        Comparator<Product> cmp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareToIgnoreCase(p2.getName());
            }
        };
        if (!ascending) {
            cmp = Collections.reverseOrder(cmp);
        }
        Collections.sort(list, cmp);
        System.out.println("Sorted by name " + (ascending ? "ASC" : "DESC"));
    }

    public void sortByPrice(boolean ascending) {
        Comparator<Product> cmp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() < p2.getPrice()) {
                    return -1;
                } else if (p1.getPrice() > p2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        if (!ascending) {
            cmp = Collections.reverseOrder(cmp);
        }
        Collections.sort(list, cmp);
        System.out.println("Sorted by price " + (ascending ? "ASC" : "DESC"));
    }

    public void sortById(boolean ascending) {
        Comparator<Product> cmp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getId().compareToIgnoreCase(p2.getId());
            }
        };
        if (!ascending) {
            cmp = Collections.reverseOrder(cmp);
        }
        Collections.sort(list, cmp);
        System.out.println("Sorted by ID " + (ascending ? "ASC" : "DESC"));
    }

}
