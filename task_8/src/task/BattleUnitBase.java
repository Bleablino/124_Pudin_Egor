package task;

public abstract class BattleUnitBase implements BattleUnit {
    private final String name;
    private int maxArmor;
    private final int basicStrength;
    private int maxHealth;
    private int armor;
    private int health;
    protected int strength;

    public BattleUnitBase(String name, int maxHealth, int basicStrength, int maxArmor) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.basicStrength = basicStrength;
        this.maxArmor = maxArmor;
        health = maxHealth;
        strength = basicStrength;
        armor = maxArmor;
    }
    @Override
    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    @Override
    public abstract void attack(BattleUnit other);
    @Override
    //реализованные методы
    public String name() {
        return name;
    }
    @Override
    public int health() {
        return health;
    }
    @Override
    public int maxHealth() {
        return maxHealth;
    }
    @Override
    public void setMaxHealth(int value) {
        maxHealth = Math.max(value, 0);
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    @Override
    public void heal(int value) {
        health = health + value;
        if (health > maxHealth)
            health = maxHealth;
    }
    @Override
    public void takeDamage(int value) {
        health -= value;
        if (health < 0)
            health = 0;
    }
    @Override
    public int strength() {
        return strength;
    }
    @Override
    public void setStrength(int value) {
        strength = value;
    }
    @Override
    public int baseStrength() {
        return basicStrength;
    }
    @Override
    public int armor() {
        return armor;
    }
    @Override
    public void restoreArmor(int value) {
        armor += value;
        if (armor > maxArmor) {
            armor = maxArmor;
        }
    }
    @Override
    public void damageArmor(int value) {
        armor -= value;
        if (armor < 0) {
            armor = 0;
        }
    }
    @Override
    public int maxArmor() {
        return maxArmor;
    }
    @Override
    public void setMaxArmor(int value) {
        maxArmor = value;
        if (maxArmor < 0) {
            maxArmor = 0;
        }
        if (maxArmor < armor) {
            armor = maxArmor;
        }
    }
}