package projek_akhir;

public abstract class Monster {
    protected String name;
    protected int level;
    protected int healthPoints;
    protected int maxHealthPoints; // New field to store maximum HP
    protected int experiencePoints;
    protected Element element;
    protected ElementalFeature elementalFeature;
    protected boolean isDefending;

    public Monster(String name, int level, Element element, ElementalFeature elementalFeature) {
        this.name = name;
        this.level = level;
        this.element = element;
        this.elementalFeature = elementalFeature;
        this.experiencePoints = 0; // Default experience points
        this.isDefending = false; // Default defending state
        this.maxHealthPoints = healthPoints; // Initialize max HP
    }

    public abstract String attack(Monster opponent);
    public abstract String defend();
    public abstract void addEP(int amount);
    public abstract void levelUp() throws ValueOutOfRangeException;
    public abstract void changeElement(Element newElement, ElementalFeature newElementalFeature) throws InvalidElementChangeException;
    public abstract String specialAttack(Monster opponent);
    public abstract String elementalAttack(Monster opponent);

    public void performElementalAttack(Monster opponent) {
        elementalFeature.elementalAttack(this, opponent);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public ElementalFeature getElementalFeature() {
        return elementalFeature;
    }

    public void setElementalFeature(ElementalFeature elementalFeature) {
        this.elementalFeature = elementalFeature;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }

    public void restoreHealth() {
        this.healthPoints = this.maxHealthPoints; // Restore HP to max HP
    }
}
