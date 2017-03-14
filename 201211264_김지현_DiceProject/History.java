public class History extends Report {

	public History(){
		super.getReport();
	}
	
	public String getWinner(){
		return super.pre_winner;
	}
	
	public int getCount(){
		return super.pre_count;
	}
	
	public int getScore(){
		return super.pre_score;
	}
}