package org.improving.tag;

import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "adversary")
public class Adversary {
    // Won't need this later
    @Id
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "HitPoints")
    private int hitPoints;

    @Column(name = "DamageTaken")
    private int damageTaken;

    @Column(name = "AttackDamage")
    private int attackDamage;

    @Transient
    private int maxHitPoints;

    @Transient
    private Inventory inventory;

    @Column(name = "DropItem")
    private String dropItemDb;

    @Enumerated(EnumType.STRING)
    private UniqueItems item;

    public Adversary() {
    }

    public Adversary(String name, UniqueItems item) {
        this.name = name;
        this.maxHitPoints = 100;
        this.hitPoints = this.maxHitPoints - this.damageTaken;
        this.damageTaken = 0;
        this.attackDamage = 15;
        this.inventory = new Inventory();
        this.item = item;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public UniqueItems getItem() {
        return item;
    }

    public void setItem(UniqueItems item) {
        this.item = item;
    }

    public String getDropItemDb() {
        return dropItemDb;
    }

    public void setDropItemDb(String dropItemDb) {
        this.dropItemDb = dropItemDb;
    }

    @PostLoad
    public void postLoad() {
        if (null != dropItemDb) {
            this.setItem(Arrays
                    .stream(UniqueItems.values())
                    .filter(item -> item.getName().equals(dropItemDb))
                    .findFirst()
                    .orElse(null));
        }
    }
}
