package model.characters;

import model.exceptions.NotAUsableItemException;
import model.items.Item;

import java.util.Objects;

public abstract class AbstractCharacter implements Character {

    protected int life, strength, maximumLife;
    protected String name;
    protected Bag bag;

    protected AbstractCharacter(String name, int maximumLife, int strength) {
        this.maximumLife = maximumLife;
        this.life = maximumLife;
        this.strength = strength;
        this.name = name;
        this.bag = new Bag();
    }

    /**
     * Modifies the life of the specified number of points.
     * Precisely, if delta >= 0, the life increases of delta
     * else, it decreases of delta.
     *
     * @param delta - the number of points the life will be modified.
     */
    public void updateLife(int delta) {
        life = Math.min(maximumLife, life + delta);
    }

    public void updateMaxLife(int delta) { maximumLife += delta; }

    /**
     * Modifies the strength of the specified number of points.
     * Precisely, if delta >= 0, the strength increases of delta
     * else, it decreases of delta.
     * But we always have 0 <= strength.
     *
     * @param delta - the number of points the strength will be modified.
     */
    public void updateStrength(int delta) {
        strength = Math.max(0, strength + delta);
    }

    /**
     * Attacks the specified character <code>target</code>
     *
     * @param target - the character being attacked.
     */
    public void attack(Character target) {
        target.updateLife(- strength);
    }

    public boolean use(Item item, Character target) throws NotAUsableItemException {
        if (!bag.contains(item)) return false;
        item.useOn(target);
        bag.remove(item);
        return true;
    }

    /**
     * Returns <code>True</code> if the Character is dead
     * (i.e. if his life is less or equal than 0).
     *
     * @return true if the character is dead.
     */
    public boolean isDead() {
        return life <= 0;
    }

    public int getMaximumLife() {
        return maximumLife;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public Bag getBag() {
        return bag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCharacter that = (AbstractCharacter) o;
        return strength == that.strength &&
                maximumLife == that.maximumLife &&
                Objects.equals(name, that.name);
    }
}

