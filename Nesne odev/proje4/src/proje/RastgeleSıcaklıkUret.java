package proje;

import java.text.DecimalFormat;
import java.util.Random;

public class RastgeleSıcaklıkUret {
    private float sicaklık;
    private Random random;
    private final float MinSicaklık = 0.0f;
    private final float MaxSicaklık = 50.0f;
    private DecimalFormat df ;
    private String format;

    public RastgeleSıcaklıkUret() {
        random = new Random();
        df = new DecimalFormat("##.##");
    }

    public String getSicaklık() {
        sicaklık = MinSicaklık + random.nextFloat() * (MaxSicaklık - MinSicaklık);
        format = df.format(sicaklık);
        return format;
    }

}




