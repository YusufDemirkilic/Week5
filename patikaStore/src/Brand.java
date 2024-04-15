import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Brand  {
    private int id;
    private String ad;
    private static ArrayList<Brand> brandListByID = new ArrayList<>();
    private static TreeSet<Brand> brandList = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getAd().compareTo(o2.getAd());
        }
    });


    public Brand(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public static void createBrands() {
        brandList.add(new Brand(1, "Samsung"));
        brandList.add(new Brand(2, "Lenovo"));
        brandList.add(new Brand(3, "Apple"));
        brandList.add(new Brand(4, "Huawei"));
        brandList.add(new Brand(5, "Casper"));
        brandList.add(new Brand(6, "Asus"));
        brandList.add(new Brand(7, "HP"));
        brandList.add(new Brand(8, "Xiaomi"));
        brandList.add(new Brand(9, "Monster"));
        brandListByID.addAll(brandList);
    }
    public static void sortBrandsById() {
        Collections.sort(brandListByID, Comparator.comparingInt(Brand::getId));
    }
    public static void printBrandsByID() {
        createBrands();
        sortBrandsById();
        System.out.println("Marka Listesi ");
        for (Brand brand : brandListByID) {
            System.out.println(brand.getId()+" "+brand.getAd());
        }
        System.out.println("----------------------------");
    }
    public static void printBrands() {
        createBrands();
        System.out.println("Marka Listesi ");
        for (Brand brand : brandList) {
            System.out.println(brand.getAd());
        }
        System.out.println("----------------------------");
    }

    public static Brand getBrand(int id) {
        for (Brand b : brandList) {
            if (id == b.getId()) {
                return b;
            }
        }
        return null;
    }
}
