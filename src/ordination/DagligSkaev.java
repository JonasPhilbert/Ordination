package ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    
	private ArrayList<Dosis> doser = new ArrayList<>();

    public void opretDosis(LocalTime tid, double antal) {
        // TODO
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
