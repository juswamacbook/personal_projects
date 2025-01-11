package newcode;

public abstract class  Player {
    protected String nickName;
    private int points;
    public Player() {
        nickName = null;
        points = 0;
    }
    public Player(String nickName, int points) {
        this.nickName = nickName;
        this.points = points;
    }
    public String getNickName() {
        return nickName;
    }
    public int getPoints() {
        return points;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void addPoints(int length) {
        if (length == 1 || length == 2) {
            this.points++;
        } else {
            points += (length - 1);
        }
    }
    
    /**
     * Word minimum length of 3. Adds score to points attribute.
     * @param length
     */
    public void addPointsNormal(int length) {
    	if (length >= 8) {
    		this.points += 11;
    	}
    	else if (length == 7) {
    		this.points += 5;
    	}
    	else if (length == 6) {
    		this.points += 3;
    	}
    	else if (length == 5) {
    		this.points += 2;
    	}
    	else if (length == 3 || length == 4) {
    		this.points += 1;
    	}
    }
    
    public void resetPoints() {
        this.points = 0;
    }
   
}