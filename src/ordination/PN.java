package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {

    private ArrayList<LocalDate> doserGivet = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    private double antalEnheder;

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen Returnerer true hvis
     * givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     *
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // Checker om dateon er inden for doserings datoerne, og tilføjer dato for dosis
        // til et ArrayList (doserGivet)
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())) {
            doserGivet.add(givesDen);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double doegnDosis() {
        // TODO
        return 0.0;
    }

    @Override
    public double samletDosis() {
        // TODO
        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return -1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

}
