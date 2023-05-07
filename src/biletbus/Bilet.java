package biletbus;

import java.util.Scanner;

public class Bilet {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int km = 0;
        int yas = 0;
        int yolculukTipi = 1;//hafizada yer almasi icin atadigimiz deger.1 veya 2 olmasini bir onemi yok

        String plakaNumarasi = "06 OFT 71";

        System.out.println("Lutfen gideceginiz mesafeyi km olarak veriniz.");
        km = input.nextInt();

        System.out.println("Lutfen yasinizi giriniz.");
        yas = input.nextInt();

        System.out.println("Lutfen yolculuk tipini giriniz." +
                "Sadece gidis ise 1\nGidis donus ise 2");
        yolculukTipi = input.nextInt();

        if (km > 0 && yas > 0 && (yolculukTipi == 1 || yolculukTipi == 2)) {
            double biletUcreti = km * 0.10;

            System.out.println("Indirimsiz bilet ucreti : " + biletUcreti);

            double yasIndirimOrani = 0;
            if (yas < 12) {
                yasIndirimOrani = 0.5;
            } else if (yas < 24) {
                yasIndirimOrani = 0.1;
            } else if (yas > 65) {
                yasIndirimOrani = 0.3;
            }

            biletUcreti -= biletUcreti * yasIndirimOrani;//biletucretini indirimli yastan cikarttik.

            if (yolculukTipi == 2) {
                biletUcreti -= biletUcreti * 0.2;
                biletUcreti *= 2;
            }

            biletDokum(plakaNumarasi, km, yolculukTipi,biletUcreti,yasIndirimOrani);
          //  System.out.println("Bilet ucreti : " +biletUcreti);
        } else {
            System.out.println("Hatali veri girdiniz...");
        }
    }

    private static void biletDokum(String plakaNumarasi, int km, int yolculukTipi, double biletUcreti,
                                   double yasIndirimOrani) {

        System.out.println("---------Bilet Dokum----------");
        System.out.println("Otobusun plakasi : " + plakaNumarasi);
        System.out.println("mesafe  : " + km);
        System.out.println("yolculuk tipi : " + (yolculukTipi == 1 ? "tek yon" : "gidis-donus"));
        System.out.println("Bilet ucreti : " + biletUcreti);

        slowPrint("Keyifli yolculuklar dileriz.", 50);

    }

    public static void slowPrint(String text, int delay) {

        for(char c : text.toCharArray()) {
            System.out.println(c);
            try {
                Thread.sleep(delay);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
