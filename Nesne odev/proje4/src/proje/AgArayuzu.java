package proje;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu, IObserver {

    private boolean acik_kapali;
    private SogutucuBilgisi AKbilgisi;

    public AgArayuzu(SogutucuBilgisi AKbilgisi) {
        this.AKbilgisi = AKbilgisi;
        AKbilgisi.registerObserver(this);
    }

    @Override
    public void sicaklik_gonder(MerkeziBirim merkeziBirim) {
        System.out.println("sicaklik: " + merkeziBirim.getSicaklik());
    }

    @Override
    public void soutucuyuAc(MerkeziBirim merkeziBirim) {
        merkeziBirim.setAc_kapa(true);
    }

    @Override
    public void soutucuyuKapat(MerkeziBirim merkeziBirim) {
        merkeziBirim.setAc_kapa(false);
    }

    @Override
    public void update(boolean acik_kapali) {
        this.acik_kapali = acik_kapali;
    }

    public boolean kullainci_girisi() {
        Scanner giris = new Scanner(System.in);

        System.out.println("Kullanici adinizi giriniz:");
        String kullanici_adi = giris.next();
        System.out.println("Sifrenizi Giriniz:");
        String kullainci_sifresi = giris.next();

       if (Sunucu.getInstance().kullaniciDogrulama(kullanici_adi, kullainci_sifresi)) {
            return true;
        }
        return false;

    }

}
