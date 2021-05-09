package proje;

import java.sql.*;

public class Sunucu {
    private static Sunucu instance = null;

    private Sunucu() {}

    public static Sunucu getInstance() {
        if (instance == null) {
            instance = new Sunucu();
        }
        return instance;
    }

    public Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proje_n",
                    "postgres", "1968");
            if (conn != null){

            }
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean kullaniciDogrulama(String kullaniciAdi, String sifre) {
        Connection conn = null;//veritabanı bağlantısı sağlar
        PreparedStatement stmt = null;//veritabanı sorguları yapmamızı sağlar
        ResultSet rs = null;//sorgu sonuçlarını tutar
        String sorgu = "select \"kullaniciAdi\", \"kullaniciSifre\" from \"kullanici\"";
        try {
            conn = this.baglan();
            stmt = conn.prepareStatement(sorgu);
            rs = stmt.executeQuery();

            while (rs.next()){
                String kullanici_a = rs.getString("kullaniciAdi");
                String kullanici_s = rs.getString("kullaniciSifre");
                if (kullaniciAdi.contains(kullanici_a)){
                    if (sifre.contains(kullanici_s)) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                    stmt.close();
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
