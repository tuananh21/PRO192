import java.util.*;

public class MyUtils {
    private static final String[] BRANDS = {
        "Yamaha", "Honda", "Suzuki", "Kawasaki", "Ducati",
        "BMW", "Harley", "Triumph", "KTM", "Benelli"
    };
    private static final String[] NAMES = {
        "R15", "CBR150R", "GSX-R150", "Ninja 400", "Panigale V4",
        "MT-07", "CB500X", "Z900", "Bonneville", "Duke 390",
        "Africa Twin", "Rebel 500", "Versys 650", "Monster", "S1000RR"
    };
    private static final String[] COLORS = {
        "Red", "Black", "Blue", "White", "Gray", "Green", "Yellow", "Orange"
    };
    private static final String[] SIZES = {
        "Small", "Medium", "Large", "Sport", "Touring"
    };
    private static final Random R = new Random();

    public static String randomName() { return NAMES[R.nextInt(NAMES.length)]; }
    public static String randomBrand() { return BRANDS[R.nextInt(BRANDS.length)]; }
    public static String randomColor() { return COLORS[R.nextInt(COLORS.length)]; }
    public static String randomSize() { return SIZES[R.nextInt(SIZES.length)]; }
    public static int randomEngine() { return 100 + R.nextInt(1000); }
    public static double randomFuel() { return 5 + R.nextDouble() * 15; }
    public static double randomPrice() { return 30000000 + R.nextDouble() * 200000000; }
}
