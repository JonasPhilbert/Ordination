package ordination;

import java.time.*;

public class DagligFast extends Ordination {

	private Dosis[] doser = new Dosis[4];
	
	public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
		super(startDen, slutDen, laegemiddel);
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
