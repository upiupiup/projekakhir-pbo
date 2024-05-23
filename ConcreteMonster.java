package projek_akhir;

public class ConcreteMonster extends Monster {
    private boolean isDefending;

    public ConcreteMonster(String name, int level, int healthPoints, Element element, ElementalFeature elementalFeature) {
        super(name, level, element, elementalFeature);
        this.healthPoints = healthPoints;
        this.experiencePoints = 0; // Nilai default
        this.isDefending = false; // Status bertahan default
    }

    @Override
    public void attack(Monster opponent) {
        if (isDefending) {
            System.out.println(this.name + " sedang bertahan dan tidak bisa menyerang.");
            return;
        }

        // Implementasi serangan dasar (basic attack)
        System.out.println(this.name + " menggunakan serangan dasar!");
        int damage = (int) (0.1 * this.level) + 10; // Kerusakan sedang, minimal 10
        if (opponent.isDefending()) {
            damage /= 2; // Mengurangi kerusakan jika lawan sedang bertahan
            opponent.setDefending(false); // Reset status bertahan setelah serangan
            System.out.println(opponent.getName() + " sedang bertahan! Kerusakan berkurang menjadi " + damage);
        }
        opponent.setHealthPoints(Math.max(0, opponent.getHealthPoints() - damage));
        System.out.println("Serangan menghasilkan " + damage + " kerusakan pada " + opponent.getName() + "!");
        System.out.println(opponent.getName() + " sekarang memiliki " + opponent.getHealthPoints() + " HP.");
    }

    @Override
    public void specialAttack(Monster opponent) {
        if (isDefending) {
            System.out.println(this.name + " sedang bertahan dan tidak bisa menyerang.");
            return;
        }

        // Implementasi serangan spesial (special attack)
        System.out.println(this.name + " menggunakan serangan spesial!");
        int damage = (int) (0.2 * this.level) + 20; // Kerusakan lebih besar, minimal 20
        double missChance = 0.1; // 10% kemungkinan meleset

        if (Math.random() < missChance) {
            System.out.println("Serangan spesial meleset!");
        } else {
            if (opponent.isDefending()) {
                damage /= 2; // Mengurangi kerusakan jika lawan sedang bertahan
                opponent.setDefending(false); // Reset status bertahan setelah serangan
                System.out.println(opponent.getName() + " sedang bertahan! Kerusakan berkurang menjadi " + damage);
            }
            opponent.setHealthPoints(Math.max(0, opponent.getHealthPoints() - damage));
            System.out.println("Serangan spesial menghasilkan " + damage + " kerusakan pada " + opponent.getName() + "!");
            System.out.println(opponent.getName() + " sekarang memiliki " + opponent.getHealthPoints() + " HP.");
        }
    }

    @Override
    public void elementalAttack(Monster opponent) {
        if (isDefending) {
            System.out.println(this.name + " sedang bertahan dan tidak bisa menyerang.");
            return;
        }

        // Melakukan serangan elemen menggunakan fitur elemen monster
        this.elementalFeature.elementalAttack(this, opponent);
        // Menerapkan efek elemen setelah serangan
        this.elementalFeature.applyElementalEffect();
    }

    @Override
    public void defend() {
        // Implementasi bertahan
        this.isDefending = true;
        System.out.println(this.name + " sedang bertahan! Serangan berikutnya akan mengurangi kerusakan.");
    }

    @Override
    public void addEP(int amount) {
        this.experiencePoints += amount;
        System.out.println(this.name + " mendapatkan " + amount + " poin pengalaman!");
    }

    @Override
    public void levelUp() throws ValueOutOfRangeException {
        if (this.level >= 99) {
            throw new ValueOutOfRangeException("Level monster tidak bisa lebih dari 99.");
        }
        if (this.experiencePoints >= 100) { // Misalkan diperlukan 100 EP untuk naik level
            this.level++;
            this.experiencePoints -= 100;
            System.out.println(this.name + " naik ke level " + this.level + "!");
        } else {
            System.out.println(this.name + " tidak memiliki cukup poin pengalaman untuk naik level.");
        }
    }

    @Override
    public void changeElement(Element newElement, ElementalFeature newElementalFeature) throws InvalidElementChangeException {
        // Implementasi penggantian elemen
        this.element = newElement;
        this.elementalFeature = newElementalFeature;
        System.out.println(this.name + " berubah elemen menjadi " + newElement + " dengan fitur " + newElementalFeature);
    }

    @Override
    public boolean isDefending() {
        return isDefending;
    }

    @Override
    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }
    
}
