package proje;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        MerkeziBirim merkeziBirim = new MerkeziBirim();
        SogutucuBilgisi SBilgisi = new SogutucuBilgisi();
        RastgeleSıcaklıkUret Rsicaklik = new RastgeleSıcaklıkUret();

        Eyleyici eyleyici = new Eyleyici(SBilgisi);
        AgArayuzu agArayuzu = new AgArayuzu(SBilgisi);
        SicaklikAlgilayıcisi sicaklikAlgilayıcisi = new SicaklikAlgilayıcisi();


        boolean secenek = true;
        int secim;
        Scanner giris = new Scanner(System.in);


        if (agArayuzu.kullainci_girisi()) {
            merkeziBirim.yazdir();
            do {
                System.out.println("\n---------işlem seçin---------");
                System.out.println("1-)sogutucu aç");
                System.out.println("2-)sogutucu kapat");
                System.out.println("3-)sicaklik goruntule");
                System.out.println("4-)çıkıs");
                System.out.println("Secim:");
                secim = giris.nextInt();
                switch (secim) {
                    case 1:
                        merkeziBirim.durum_bekleme();
                        merkeziBirim.agArayuzu.soutucuyuAc(merkeziBirim);
                        SBilgisi.setSBilgisi(true);
                        System.out.println("************************************");
                        merkeziBirim.yazdir();
                        break;
                    case 2:
                        merkeziBirim.agArayuzu.soutucuyuKapat(merkeziBirim);
                        SBilgisi.setSBilgisi(false);
                        merkeziBirim.durum_kapalı();
                        System.out.println("************************************");
                        merkeziBirim.yazdir();
                        break;
                    case 3:
                        System.out.println("************************************");
                        merkeziBirim.agArayuzu.sicaklik_gonder(merkeziBirim);
                        merkeziBirim.durum_yazdir();
                        break;
                    default:
                        secenek = false;
                        break;
                }
                System.out.println("************************************\n");
            } while (secenek);
        } else {
            System.out.println("kullanıcı geçersiz tekrar deneyin");
        }


    }
}
