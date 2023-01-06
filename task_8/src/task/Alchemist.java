package task;

public class Alchemist extends BattleUnitBase {
    public Alchemist (String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }
    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        BattleUnit maxHealthTeammate = null;
        BattleUnit minHealthTeammate = null;
        int maxHealth = -1;
        int minHealth = Integer.MAX_VALUE;
        for (BattleUnit teammate : ownTeam) {
            if (teammate.health() > maxHealth && teammate.health() > 0)
                maxHealthTeammate = teammate;
            maxHealth = teammate.health();
            if (teammate.health() < minHealth && teammate.health() > 0)
                minHealthTeammate = teammate;
            minHealth = teammate.health();
        }
        if (maxHealthTeammate != null)
            maxHealthTeammate.setStrength(maxHealthTeammate.strength() + 1);
        if (minHealthTeammate != null)
            minHealthTeammate.heal(10);
    }
    @Override
    public void attack(BattleUnit other) {
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}