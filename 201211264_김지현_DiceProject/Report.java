import java.io.*;
public class Report {

    protected int pre_count;
    protected int pre_score;
	protected String pre_winner;
	
	public Report(){}
	
	public void setResult(int count,String winner, int score){
		
		if(pre_score <= score)
		{
			if(pre_score==score){				
				if(pre_count<count){
					try {
						FileWriter file = new FileWriter("DiceGameReport.txt");
						file.write(count+","+winner+","+score);
						file.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else{
				try {
					FileWriter file = new FileWriter("DiceGameReport.txt");
					file.write(count+","+winner+","+score);
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
	}
	
	public void getReport(){
 		try {
 			FileReader f = new FileReader("DiceGameReport.txt");
 			BufferedReader br = new BufferedReader(f);
 			String s = br.readLine();
 			if(s != null){
 				String data = s;
 				String[] result = data.split(",");
 			
 				pre_count = Integer.parseInt(result[0]);
 				pre_winner = result[1];
 				pre_score = Integer.valueOf(result[result.length-1]).intValue();
 			}
 			f.close();			
 		} catch (IOException e) {
 			e.printStackTrace();
 		}   
    }
	
}