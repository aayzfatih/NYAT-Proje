package proje;

import java.sql.Connection;

public interface IKullaniciVeritabaniServisi {
    public Connection baglan();
    public boolean kullaniciDogrulama(String kullaniciAdi, String sifre);
}
