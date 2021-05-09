package proje;

import java.util.ArrayList;

public class SogutucuBilgisi implements ISubject {
    private ArrayList observers;
    String sicaklik;
    boolean acik_kapali;

    public SogutucuBilgisi() {
        observers = new ArrayList();
    }

    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    public void removeObserver(IObserver o) {
        int i = observers.indexOf(o);
        if (i > 0) {
            observers.remove(i);
        }
    }

    public void notifyObververs() {
        for (int i = 0; i < observers.size(); i++) {
            IObserver observer = (IObserver) observers.get(i);
            observer.update(acik_kapali);
        }
    }

    public void setSBilgisi( boolean acik_kapali) {
        this.acik_kapali = acik_kapali;
        notifyObververs();
    }


}
