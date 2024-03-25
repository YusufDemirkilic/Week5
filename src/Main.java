import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dizi index değerini giriniz: ");
        int choice = scanner.nextInt(); // kulanıcıdan değer alıyoruz
        try { //index değerinin sınırları kontorl ediyoruz
            System.out.println(Arrays.toString(Arrays(choice)));
        } catch (ArrayIndexOutOfBoundsException e) { // hataya takılırsa mesajaımızı yazdırıyoruz
            System.out.println("dizi boyutundan fazla değer girdiniz.");
        }
    }

    public static int[] Arrays(int arrays) {// 10 elemanlı dizi tanımlıyoruz.
        int[] array ={1,2,3,4,5,6,7,8,9,10};
        for (int a : array) {

            if (array[arrays] == a) {// eğer dizi değeri kullanıcıdan alına ile aynı ise değeri döndrüyoruz
                return new int[]{array[arrays]};
            }
        }
        return new int[]{array[arrays]};
    }
}