package task;

public class ArmorDestroyer extends BattleUnitBase {
    public ArmorDestroyer (String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        BattleUnit enemyMaxArmor = null;
        int maxArmor = -1;
        for (BattleUnit enemy : enemyTeam) {
            if (enemy.armor() > maxArmor && enemy.health() > 0) {
                enemyMaxArmor = enemy;
                maxArmor = enemy.armor();
            }
        }
        int damage = this.strength;
        int doubleDamage = damage * 2;
        int quarterDamage =  damage / 4;

        if (doubleDamage < 1) {
            doubleDamage = 1;
        }
        if (quarterDamage < 1) {
            quarterDamage = 1;
        }
        if (enemyMaxArmor == null) {
            return;
        }
        if (enemyMaxArmor.armor() > 0)
            enemyMaxArmor.damageArmor(doubleDamage);
        else {
            enemyMaxArmor.takeDamage(quarterDamage);
        }
    }
    @Override
    public void attack(BattleUnit other) {
        int damage = this.strength();
        int halfDamage = damage / 2;
        int quarterDamage =  damage / 4;
        if (damage <= 1) {
            damage = 1;
        }
        if (halfDamage <= 1) {
            halfDamage = 1;
        }
        if (quarterDamage <= 1) {
            quarterDamage = 1;
        }
        if (other.armor() > 0) {
            other.takeDamage(quarterDamage);
            other.damageArmor(damage);
        } else {
            other.takeDamage(halfDamage);
        }
    }
}