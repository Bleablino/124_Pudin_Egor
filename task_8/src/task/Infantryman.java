package task;

public class Infantryman extends BattleUnitBase {
    public Infantryman(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
    }
    @Override
    public void attack(BattleUnit other) {
        int damage = this.strength();
        int halfDamage = damage / 2;
        int quarterDamage =  damage / 4;
        if (damage < 1) {
            damage = 1;
        }
        if (halfDamage < 1) {
            halfDamage = 1;
        }
        if (quarterDamage < 1) {
            quarterDamage = 1;
        }
        if (other.armor() > 0) {
            other.takeDamage(halfDamage);
            other.damageArmor(quarterDamage);
        }
        else
            other.takeDamage(damage);
    }
}