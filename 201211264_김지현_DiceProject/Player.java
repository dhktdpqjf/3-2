public class Player {
    String name;
    int num;
    Dice d;    
    
    public Player(String name) {
        this.name=name;
    }
    
    public void setNum(int num){    	
    	this.num = num;
    }
    
    public void play() {
        d=new Dice();
        d.roll();
        setNum(d.getNum());        
    }
    
    public String getName() {
        return name;
    }
    
    public int getNum() {
        return num;
    }
}