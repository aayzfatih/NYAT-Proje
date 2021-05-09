package proje;

public class SicaklikAlgilayıcisi implements ISicaklıkOku {
    RastgeleSıcaklıkUret Rsicaklik;

    public SicaklikAlgilayıcisi(){
        Rsicaklik = new RastgeleSıcaklıkUret();
    }

    @Override
    public void sicaklikOku(MerkeziBirim merkeziBirim) {
        merkeziBirim.setSicaklik(Rsicaklik.getSicaklık());
    }
}
