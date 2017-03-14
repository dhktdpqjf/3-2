public class DicePlayer extends Player {
	Dice d;

	public DicePlayer(String name) {
		super(name);
	}

	public void roll(){
        d=new Dice();
		d.roll();
		super.setNum(d.getNum());
	}	
}