package proje;

public class Eyleyici implements IKontrol, IObserver {

    private boolean acik_kapali;
    private SogutucuBilgisi AKbilgisi;

    public Eyleyici(SogutucuBilgisi AKbilgisi){
        this.AKbilgisi = AKbilgisi;
        AKbilgisi.registerObserver(this);
    }

    @Override
    public void update( boolean acik_kapali) {
        this.acik_kapali = acik_kapali;
    }
    @Override
    public void soutucuyuAc(MerkeziBirim merkeziBirim) {
        merkeziBirim.setAc_kapa(true);
    }

    @Override
    public void soutucuyuKapat(MerkeziBirim merkeziBirim) {
        merkeziBirim.setAc_kapa(false);
    }



}
