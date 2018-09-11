package ordination;

import java.time.*;
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
