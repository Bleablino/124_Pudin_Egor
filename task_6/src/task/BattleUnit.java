package task;

public class BattleUnit {
    private final int strength;
    private int armor;
    private int health;
    private int x;
    private int y;
    public BattleUnit(int strength, int armor, int health, int x, int y){
        this.strength = strength;
        this.armor = armor;
        this.health = health;
        this.x = x;
        this.y = y;
    }
    public int getStrength(){
        return strength;
    }
    public int getArmor(){
        return armor;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getHealth(){
        return health;
    }

    public void attacked(BattleUnit enemy){
        if(armor > 0) {
            if (enemy.strength >= armor)
                health = health - (enemy.strength - armor);
        }
        else
            health = health - enemy.strength;
    }

    public void moveUp(){
        y--;
    }
    public void moveDown(){
        y++;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }

    public boolean isAlive(){
        return health > 0;
    }
}