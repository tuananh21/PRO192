public class Product extends Item {
    private String brand;
    private int engineCapacity; 
    private double fuelCapacity; 
    private String size;
    private String color;
    private double price; 

    public Product(String id, String name, String brand, int engineCapacity,
                   double fuelCapacity, String size, String color, double price) {
        super(id, name);
        this.brand = brand;
        this.engineCapacity = engineCapacity;
        this.fuelCapacity = fuelCapacity;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getBrand() { return brand; }
    public int getEngineCapacity() { return engineCapacity; }
    public double getFuelCapacity() { return fuelCapacity; }
    public String getSize() { return size; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s | %-12s | %-8s | %4dcc | %.1fL | %-10s | %-8s | %,.0f VND",
                id, name, brand, engineCapacity, fuelCapacity, size, color, price);
    }

    //Nối các data cách nhau bởi dấu phẩy
    public String saveData() {
        return String.join(",",
                id, name, brand,
                String.valueOf(engineCapacity),
                String.valueOf(fuelCapacity),
                size, color, String.valueOf(price));
    }

    //Đọc ngược lại data từ file txt
    public static Product readData(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] p = line.split(",");
        if (p.length < 8) return null;      
            return new Product(
                p[0].trim(),
                p[1].trim(),
                p[2].trim(),
                Integer.parseInt(p[3].trim()),
                Double.parseDouble(p[4].trim()),
                p[5].trim(),
                p[6].trim(),
                Double.parseDouble(p[7].trim())
            );
    }
}
