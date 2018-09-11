package ordination;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DagligFast extends Ordination {

	private Dosis[] doser = new Dosis[4];
	
	public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
		super(startDen, slutDen, laegemiddel);
	}
	
	public Dosis[] getDoser(){
		return Arrays.copyOf(doser, 4);
	}
	
	@Override
	public double samletDosis() {
		return doegnDosis() * ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
	}

	@Override
	public double doegnDosis() {
		double sum = 0d;
		for (int i = 0; i < doser.length; i++) {
			if (doser[i] != null) {
				sum += doser[i].getAntal();
			}
		}
		
		return sum;
	}

	@Override
	public String getType() {
		return "FAST";
	}
}
