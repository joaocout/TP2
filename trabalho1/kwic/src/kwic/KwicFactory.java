package kwic;

public class KwicFactory {
	
	public KwicFactory(int mode) {
		if(mode == 1) // base
			new BaseKwic();
		else if(mode == 2)
			new DBLPBaseKwic();
	}
	
}
