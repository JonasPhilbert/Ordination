package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    
	public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
		super(startDen, slutDen, laegemiddel);
	}

	private ArrayList<Dosis> doser = new ArrayList<>();

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doegnDosis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
