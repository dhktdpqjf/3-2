import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DiceGame extends JFrame implements ActionListener {
	
	JTextField tf1,tf2,tf3,tf4;
	JTextArea ta1,ta2;
    JButton bt1,bt2;
    Container cp;
    
    JTextField tf5,tf6,tf7;
    JLabel label8,label9,label10,lb1,lb2;
    
    Player p1;
    Player p2;
    int sum1;
    int sum2;
    
    public void startGame() {
    	setTitle("Dice Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(254,255,230));
        panel.setLayout(new GridLayout(9,2)); 
        cp = getContentPane();
        cp.add(panel);       
        
        JLabel label1 = new JLabel("     Player1's name");
		JLabel label2 = new JLabel("     Player2's name");
		panel.add(label1);        
	    panel.add(label2);	        
		
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        panel.add(tf1);
        panel.add(tf2);
        
        JLabel label3 = new JLabel("     Player1's result");
		JLabel label4 = new JLabel("     Player2's result");
        panel.add(label3);
        panel.add(label4);
        
        lb1 = new JLabel("  ");
        lb2 = new JLabel("  ");
        lb1.setBackground(new Color(218,251,242));
        lb2.setBackground(new Color(218,251,242));
        panel.add(lb1);
        panel.add(lb2);
        
        ta1 = new JTextArea();
        ta2 = new JTextArea();
        ta1.setBackground(new Color(218,251,242));
        ta2.setBackground(new Color(218,251,242));
        panel.add(ta1);
        panel.add(ta2);
        
		
        JLabel label5 = new JLabel("      Pre-winner's Winnings");
        JLabel label6 = new JLabel("      Pre-winner's Name");
        JLabel label7 = new JLabel("      Pre-winner's Score");        
        
        label8 = new JLabel("");
        label9 = new JLabel("");
        label10 = new JLabel("");

        panel.add(label5);
        panel.add(label8);
        panel.add(label6);
        panel.add(label9);
        panel.add(label7);
        panel.add(label10);   
        
        bt1 = new JButton("Play");
        bt1.addActionListener(this);
        bt2 = new JButton("History");
        bt2.addActionListener(this);
        panel.add(bt1);
        panel.add(bt2);
        
        pack();
        setVisible(true); 
    }    
    
    
	public void playGame(){
		String name1 = tf1.getText();
	    String name2 = tf2.getText();
	    
	    DicePlayer p1 = new DicePlayer(name1.toUpperCase());
		DicePlayer p2 = new DicePlayer(name2.toUpperCase());
		
        int cnt1 = 0;
        int cnt2 = 0;
        sum1 = 0;
        sum2 = 0;
        
        Report rp = new Report();
        rp.getReport();
        
        for(int i = 0; i<10; i++){
        	p1.roll();
        	p2.roll();
            
            if (p1.getNum() > p2.getNum()) {
            	sum1 += p1.getNum();
            	cnt1++;
            }
            else if (p1.getNum() == p2.getNum()) {
            	sum1 += p1.getNum();
            	sum2 += p2.getNum();
            	cnt1++;cnt2++;
            }
            else{
            	sum2 += p1.getNum();
            	cnt2++;
            }
        }
        
        if(sum1>sum2){
        	rp.setResult(cnt1,p1.getName(),sum1);
        	ta1.setText("           "+p1.getName()+" win!");
        	ta2.setText("");
        }else if (sum1<sum2){
        	rp.setResult(cnt2,p2.getName(),sum2);
        	ta2.setText("           "+p2.getName()+" win!");
        	ta1.setText("");
        }else{
        	if(cnt1<cnt2){
        		rp.setResult(cnt2,p2.getName(),sum2);
            	ta2.setText("           "+p2.getName()+" win!");
            	ta1.setText("");
        	}else if (cnt1>cnt2){
        		rp.setResult(cnt1,p1.getName(),sum1);
            	ta1.setText("           "+p1.getName()+" win!");
            	ta2.setText("");
        	}else {
        		ta1.setText("           "+p1.getName()+" draw!");
            	ta2.setText("           "+p2.getName()+" draw!");
        	}
        } 
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
        
		if(b == bt1){	
 		    playGame();   		    
	        lb1.setText("           "+sum1);
	        lb2.setText("           "+sum2);   
	        
		}else{			
			
			History h = new History();
			label8.setText("         "+String.valueOf(h.getCount()));
			label9.setText("         "+h.getWinner());
			label10.setText("         "+String.valueOf(h.getScore()));

		}		
	}
	
	public static void main(String args[]) {
        DiceGame g = new DiceGame();
        g.startGame();
    }
}