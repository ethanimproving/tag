package org.improving.tag;

public class Adversary {
    private String name;
    private int hitPoints;
    private int damageTaken;
    private int attackDamage;
    private int maxHitPoints;

    public Adversary(String name) {
        this.name = name;
        this.maxHitPoints = 100;
        this.hitPoints = this.maxHitPoints - this.damageTaken;
        this.damageTaken = 0;
        this.attackDamage = 15;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
