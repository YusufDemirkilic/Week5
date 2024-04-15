import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PatikaStore {
    public static Scanner input = new Scanner(System.in);

    public static void run()  {

        boolean isVote = true;
        while (isVote) {
            System.out.println("Kategori Seçiniz\n" + "1 - Cep Telefonu İşlemleri" + "\n2 - Notebook İşlemleri: " + "\n3 - Marka Listele" + "\n0 - Çıkış Yap");

            while (!input.hasNextInt())
            {
                System.out.println("Kategori Seçiniz\n" + "1 - Cep Telefonu İşlemleri" + "\n2 - Notebook İşlemleri: " + "\n3 - Marka Listele" + "\n0 - Çıkış Yap");
                input.nextLine();
            }

            int vote = input.nextInt();
            switch (vote) {
                    case 1: {
                        System.out.println("1 - Ürünleri Listele 2 - Ürün Ekle  3 - Ürün Sil 4 - Markaya Göre Ara");
                        int userInp = input.nextInt();
                        if (userInp == 1) {
                            Telephone.telProductList();
                        } else if (userInp == 2) {
                            Telephone.newTelePhoneGetInfo();
                            input.nextLine();
                        } else if (userInp == 3) {
                            Telephone.deleteProduct();

                        } else if (userInp == 4) {
                            Telephone.brandFilter();

                        } else {

                            System.out.println("NooteBook Listesi boş.");


                        }
                        break;
                    }

                    case 2: {
                        System.out.println("NoteBook Listesi:");

                        System.out.println("1 - Ürünleri Listele 2 - Ürün Ekle  3 - Ürün Sil 4 - Markaya Göre Ara");
                        int userInp = input.nextInt();

                        if (userInp == 1) {
                            NooteBook.noteBookListesi();
                        } else if (userInp == 2) {
                            NooteBook.newNooteBookGetInfo();
                            input.nextLine();
                        } else if (userInp == 3) {
                            NooteBook.deleteProduct();

                        } else if (userInp == 4) {
                            NooteBook.brandFilter();

                        } else {

                            System.out.println("NooteBook Listesi boş.");

                        }
                        break;
                    }

                    case 3: {

                        Brand.printBrands();
                        System.out.println();
                        break;
                    }
                    case 0: {
                        isVote = false;
                        break;
                    }
                }

        }
    }
}










