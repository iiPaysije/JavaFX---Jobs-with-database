package Paketi;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class PosaoTh {

    private int satnica;
    public int brojac;
    private int posaoID;
    private Korisnik radnik;
    private ScheduledExecutorService executor;

    public void stopPosao() {
        executor.shutdown();
        DecimalFormat df = new DecimalFormat("#.##");
        double zarada = (satnica / 3600.00) * brojac;
        JOptionPane.showMessageDialog(null, "Korisnik: " + radnik.getIme() + " je zaradio: " + df.format(zarada) + "$");
    }

    public PosaoTh(int satnica, Korisnik radnik) {
        this.radnik = radnik;
        this.satnica = satnica;
        Runnable helloRunnable = () -> {
            brojac++;
        };

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    }
}
