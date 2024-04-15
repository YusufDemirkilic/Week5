import java.util.ArrayList;
import java.util.Scanner;

public class NooteBook {
    private int protectedID;
    private String brandName;
    private String category;
    private double piece;
    private double discountRate;
    private int intstock;
    private String protectedName;
    private Double screenSize;
    private String memoryInfo;
    private int ram;

    public NooteBook(int protectedID, String brandName, String category, double piece, double discountRate, int intstock, String protectedName, Double screenSize, String memoryInfo, int ram) {
        this.protectedID = protectedID;
        this.brandName = brandName;
        this.category = category;
        this.piece = piece;
        this.discountRate = discountRate;
        this.intstock = intstock;
        this.protectedName = protectedName;
        this.screenSize = screenSize;
        this.memoryInfo = memoryInfo;
        this.ram = ram;
    }

    private static ArrayList<NooteBook> notebookListesi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void prtcNooteBook() {

        notebookListesi.add(new NooteBook(1, "Samsung", "NoteBook", 1000, 0, 1, "Samsung Nova", 15.4, "512 SSD", 16));
        notebookListesi.add(new NooteBook(2, "HP", "NoteBook", 1200, 0, 1, "HP EliteBook", 14.0, "1 TB HDD", 8));
        notebookListesi.add(new NooteBook(3, "Dell", "NoteBook", 1350, 0, 1, "Dell XPS", 13.3, "256 SSD", 16));


    }

    public static void newNooteBookGetInfo() {

        System.out.println("Yeni NoteBook Bilgilerini Girin:");

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
        double fiyat = scanner.nextDouble();
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

        System.out.println("Depolama GB:");
        String depolama = scanner.nextLine();

        System.out.println("Ram GB:");
        while (!scanner.hasNextInt()){
            System.out.println("Sayısal deger giriniz");
            scanner.nextLine();
        }
        int ram = scanner.nextInt();




        notebookListesi.add(new NooteBook(notebookListesi.size() + 1, marka, kategori, fiyat, 0, 1, model, ekranBoyutu, depolama, ram));
        printNoteBookList(notebookListesi); //0 ,str,str,d,0,0,str,double,str,int
    }

    public static void noteBookListesi() {

        printNoteBookList(notebookListesi);
    }

    public static void deleteProduct() {
        // Veri listesinde productId'ye sahip ürünü bul

        System.out.println("Silmek İstediginiz Ürünün İdsini giriniz");
        int productId = scanner.nextInt();
        NooteBook productToDelete = null;
        for (NooteBook nooteBook : notebookListesi) {
            if (nooteBook.protectedID == productId) {
                productToDelete = nooteBook;
                break;
            }
        }

        if (productToDelete != null) {
            // Ürünü listeden sil
            notebookListesi.remove(productToDelete);
            System.out.println("Ürün başarıyla silindi.");

        } else {
            System.out.println("Belirtilen ID'ye sahip ürün bulunamadı.");
        }

        printNoteBookList(notebookListesi);

    }

    public static void brandFilter() {

        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter = scanner.nextLine();
        ArrayList<NooteBook> filterNbook = new ArrayList<>();
        for (NooteBook n : notebookListesi) {
            if (filter.equalsIgnoreCase(n.brandName)) {
                filterNbook.add(n);
            }
        }
        printNoteBookList(filterNbook);
    }

    public static void printNoteBookList(ArrayList<NooteBook> noteBookList) {

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-5s|%-10s|%-13s|%-10s|%-18s|%-8s|%-15s|%-17s|%-7s|%-13s|\n", "ID", "Marka", "Kategori", "Fiyat", "İndirim Oranı", "Stok", "Model İsmi", "Ekran Boyutu", "Ram", "Depolama");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (NooteBook noteBook : noteBookList) {
            System.out.printf("|%-5d|%-10s|%-13s|%-10.2f|%-18.2f|%-8d|%-15s|%-17.2f|%-7d|%-13s|\n",
                    noteBook.getProtectedID(), noteBook.getBrandName(), noteBook.getCategory(), noteBook.getPiece(),
                    noteBook.getDiscountRate(), noteBook.getIntstock(), noteBook.getProtectedName(),
                    noteBook.getScreenSize(), noteBook.getRam(), noteBook.getMemoryInfo());

        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
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

    public double getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public double getDiscountRate() {
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
