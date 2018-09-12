package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    public void opretDosis(LocalTime tid, double antal) {
        addDosis(new Dosis(tid, antal));
    }

    public void addDosis(Dosis dosis) {
        doser.add(dosis);
    }

    public void removeDosis(Dosis dosis) {
        doser.remove(dosis);
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * super.antalDage();
    }

    @Override
    public double doegnDosis() {
        double sum = 0d;
        for (Dosis d : doser) {
            sum += d.getAntal();
        }

        return sum;
    }

    @Override
    public String getType() {
        return "SKAEV";
    }
}
