package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {

    private ArrayList<LocalDate> doserGivet = new ArrayList<>();
    private double antalEnheder;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
    }

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
        return samletDosis() / ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
    }

    @Override
    public double samletDosis() {
        return getAntalGangeGivet() * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return doserGivet.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        return "PN";
    }

}
