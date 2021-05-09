package proje;

enum Durum {
    kapalı,
    kontol,
    beklemede,
    algılama;
}

public class MerkeziBirim {
    private String sicaklik;
    private boolean ac_kapa;
    private Durum merkeziBirimDurum = Durum.kapalı;

    SogutucuBilgisi AKbilgisi = new SogutucuBilgisi();
    Eyleyici eyleyici = new Eyleyici(AKbilgisi);
    AgArayuzu agArayuzu = new AgArayuzu(AKbilgisi);
    SicaklikAlgilayıcisi sicaklikAlgilayıcisi = new SicaklikAlgilayıcisi();


    public MerkeziBirim(){
        sicaklikAlgilayıcisi.sicaklikOku(this);
        eyleyici.soutucuyuAc(this);
        durum_bekleme();
    }

    public void durum_kapalı(){
        merkeziBirimDurum = Durum.kapalı;
    }
    public void durum_kontol(){
        merkeziBirimDurum = Durum.kontol;
    }
    public void durum_bekleme(){
        merkeziBirimDurum = Durum.beklemede;
    }
    public void durum_algilama(){
        merkeziBirimDurum = Durum.algılama;
    }

    public void yazdir(){
        durum_yazdir();
        Ac_kapali_yazdir();
        siciklik_Yazdir();
    }

    public void siciklik_Yazdir(){
        durum_algilama();
        sicaklikAlgilayıcisi.sicaklikOku(this);
        System.out.println("sicaklik: "+ sicaklik+"°C");

    }

    public void Ac_kapali_yazdir(){
        if (ac_kapa){
            System.out.println("soğutucu: açık ");
        }else{
            System.out.println("soğutucu: kapalı");
        }
    }

    public void durum_yazdir(){
        switch (merkeziBirimDurum){
            case kapalı:
                System.out.println("Durum: kapalı");
                break;
            case kontol:
                System.out.println("Durum: kontol");
                break;
            case algılama:
                System.out.println("Durum: algılama");
                break;
            case beklemede:
                System.out.println("Durum: beklemede");
                break;
            default:
                break;
        }
    }

    public String getSicaklik() {
        return sicaklik;
    }

    public void setSicaklik(String sicaklik) {
        this.sicaklik = sicaklik;
    }

    public boolean isAc_kapa() {
        return ac_kapa;
    }

    public void setAc_kapa(boolean ac_kapa) {
        this.ac_kapa = ac_kapa;
    }


}
