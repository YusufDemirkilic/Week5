import java.util.ArrayList;
import java.util.Scanner;

public class Telephone {
    private int protectedID;
    private String brandName;
    private String category;
    private int piece;
    private int discountRate;
    private int intstock;
    private String protectedName;
    private Double screenSize;
    private String memoryInfo;
    private String batteryPower;
    private int ram;
    private String color;//Renk (Siyah,Kırmızı,Mavi)

    public Telephone(int protectedID, String brandName, String category, int piece, int discountRate, int intstock, String protectedName, Double screenSize, String memoryInfo, String batteryPower, int ram, String color) {
        this.protectedID = protectedID;
        this.brandName = brandName;
        this.category = category;
        this.piece = piece;
        this.discountRate = discountRate;
        this.intstock = intstock;
        this.protectedName = protectedName;
        this.screenSize = screenSize;
        this.memoryInfo = memoryInfo;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;

    }

    private static  ArrayList<Telephone> telephonesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void prtcTelephones() {
        telephonesList.add(new Telephone(1, "Huwai", "Mobil", 1000, 0, 1, "Huwai Amiral", 6.7, "128 GB", "4000 Mah", 8, "Red"));
        telephonesList.add(new Telephone(2, "Apple", "Mobil", 1500, 0, 1, "Apple XR", 10.0, "64 GB", "3300 Mah", 16, "Black"));
        telephonesList.add(new Telephone(3, "Samsung", "Mobil", 770, 0, 1, "Samsung Galaxy", 6.0, "512 GB", "2800 Mah", 32, "Blue"));
        telephonesList.add(new Telephone(4, "Apple", "Mobil", 1500, 0, 1, "Apple XR", 10.0, "64 GB", "3300 Mah", 16, "Black"));

    }

    public static void newTelePhoneGetInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yeni Telefon Bilgilerini Girin:");

        System.out.println("Marka:");
        Brand.printBrandsByID();
        int ID = scanner.nextInt();
        String marka = Brand.getBrand(ID).getAd();
        scanner.nextLine();


        System.out.println("Kategori:");
        String kategori = scanner.nextLine();

        System.out.println("Fiyatı:");
        while (!scanner.hasNextInt()){
            System.out.println("Sayısal deger giriniz");
            scanner.nextLine();
        }
        int fiyat = scanner.nextInt();
        scanner.nextLine(); // Boş satırı oku

        System.out.println("Model:");
        String model = scanner.nextLine();

        System.out.println("Ekran Boyutu İnc:");
        while (!scanner.hasNextInt()){
            System.out.println("Sayısal deger giriniz");
            scanner.nextLine();
        }
        double ekranBoyutu = scanner.nextDouble();
        scanner.nextLine(); // Boş satırı oku

        System.out.println("Depolama GB: ");
        String depolama = scanner.nextLine();

        System.out.println("Pil Kapasitesi Mah: ");
        String pilKapasitesi = scanner.nextLine();

        System.out.println("Ram GB: ");
        while (!scanner.hasNextInt()){
            System.out.println("Sayısal deger giriniz");
            scanner.nextLine();
        }
        int ram = scanner.nextInt();
        scanner.nextLine(); // Boş satırı oku

        System.out.println("Renk:");
        String renk = scanner.nextLine();


        telephonesList.add(new Telephone(telephonesList.size() + 1, marka, kategori, fiyat, 0, 1, model, ekranBoyutu, depolama, pilKapasitesi, ram, renk));
        printTelList(telephonesList);
    }

    public static void telProductList() {

        printTelList(telephonesList);
    }

    public static void deleteProduct() {
        // Veri listesinde productId'ye sahip ürünü bul
        System.out.println("Silmek İstediginiz Ürünün İdsini giriniz");
        int productId = scanner.nextInt();

        Telephone productToDelete = null;
        for (Telephone telephone : telephonesList) {
            if (telephone.protectedID == productId) {
                productToDelete = telephone;
                break;
            }
        }

        if (productToDelete != null) {
            // Ürünü listeden sil
            telephonesList.remove(productToDelete);
            System.out.println("Ürün başarıyla silindi.");

        } else {
            System.out.println("Belirtilen ID'ye sahip ürün bulunamadı.");
        }
        printTelList(telephonesList); // Güncellenmiş listeyi bastır

    }

    public static void brandFilter() {

        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter = scanner.nextLine();
        ArrayList<Telephone> filterTel = new ArrayList<>();
        for (Telephone t : telephonesList) {
            if (filter.equalsIgnoreCase(t.brandName)) {
                filterTel.add(t);
            }
        }
        printTelList(filterTel);
    }

    public static void printTelList(ArrayList<Telephone> printList) {
        System.out.println("Çep Telefonu Listesi:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-10s | %-12s | %-8s | %-15s | %-6s | %-14s | %-15s | %-10s | %-8s | %-6s | %-10s |\n", "ID", "Marka", "Kategori", "Fiyat", "İndirim Oranı", "Stok", "Model İsmi", "Ekran Boyutu", "Depolama", "Batarya", "Ram", "Renk");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Telephone tel : printList) {
            System.out.printf("| %-4s | %-10s | %-12s | %-8s | %-15s | %-6s | %-14s | %-15s | %-10s | %-8s | %-6s | %-10s |\n",
                    tel.getProtectedID(), tel.getBrandName(), tel.getCategory(), tel.getPiece(), tel.getDiscountRate(),
                    tel.getIntstock(), tel.getProtectedName(), tel.getScreenSize(), tel.getMemoryInfo(), tel.getBatteryPower(), tel.getRam(), tel.getColor());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

    }

    public int getProtectedID() {
        return protectedID;
    }

    public void setProtectedID(int protectedID) {
        this.protectedID = protectedID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getIntstock() {
        return intstock;
    }

    public void setIntstock(int intstock) {
        this.intstock = intstock;
    }

    public String getProtectedName() {
        return protectedName;
    }

    public void setProtectedName(String protectedName) {
        this.protectedName = protectedName;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public String getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(String memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public String getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(String batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}