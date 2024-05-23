
package projek_akhir;

public interface ElementalFeature {
    void elementalAttack(Monster opponent, Monster attacker);
    void applyElementalEffect();
}

class WaterFeature implements ElementalFeature {
    @Override
    public void elementalAttack(Monster opponent, Monster attacker) {
        // Implementasi serangan elemen api
        System.out.println(attacker.getName() + " menggunakan serangan elemen api!");

        int damage;
        // Menghitung damage berdasarkan level monster yang menyerang
        if (opponent.getElement() == Element.WIND) {
            damage = (int) (0.3 * attacker.getLevel()) + 10; // More damage for effective attack
            System.out.println("It's super effective! The fire attack deals " + damage + " damage!");
        } else {
            damage = (int) (0.15 * attacker.getLevel()) + 5; // Less damage for non-effective attack
            System.out.println("The fire attack deals " + damage + " damage.");
        }

        opponent.setHealthPoints(opponent.getHealthPoints() - damage);
        System.out.println(opponent.getName() + " now has " + opponent.getHealthPoints() + " HP.");
    }

    @Override
    public void applyElementalEffect() {
        System.out.println("Applying water elemental effect! The target is soaked and has reduced accuracy.");
    }
}



class FireFeature implements ElementalFeature {
    @Override
    public void elementalAttack(Monster attacker, Monster opponent) {
        // Implementasi serangan elemen api
        System.out.println(attacker.getName() + " menggunakan serangan elemen api!");

        int damage;
        // Menghitung damage berdasarkan level monster yang menyerang
        if (opponent.getElement() == Element.WIND) {
            damage = (int) (0.3 * attacker.getLevel()) + 10; // More damage for effective attack
            System.out.println("It's super effective! The fire attack deals " + damage + " damage!");
        } else {
            damage = (int) (0.15 * attacker.getLevel()) + 5; // Less damage for non-effective attack
            System.out.println("The fire attack deals " + damage + " damage.");
        }

        opponent.setHealthPoints(opponent.getHealthPoints() - damage);
        System.out.println(opponent.getName() + " now has " + opponent.getHealthPoints() + " HP.");
    }

    @Override
    public void applyElementalEffect() {
        System.out.println("Applying fire elemental effect! The target is burned and will take extra damage over time.");
    }
}




class WindFeature implements ElementalFeature {
    @Override
    public void elementalAttack(Monster opponent, Monster attacker) {
        // Implementasi serangan elemen api
        System.out.println(attacker.getName() + " menggunakan serangan elemen api!");

        int damage;
        // Menghitung damage berdasarkan level monster yang menyerang
        if (opponent.getElement() == Element.WIND) {
            damage = (int) (0.3 * attacker.getLevel()) + 10; // More damage for effective attack
            System.out.println("It's super effective! The fire attack deals " + damage + " damage!");
        } else {
            damage = (int) (0.15 * attacker.getLevel()) + 5; // Less damage for non-effective attack
            System.out.println("The fire attack deals " + damage + " damage.");
        }

        opponent.setHealthPoints(opponent.getHealthPoints() - damage);
        System.out.println(opponent.getName() + " now has " + opponent.getHealthPoints() + " HP.");
    }

    @Override
    public void applyElementalEffect() {
        System.out.println("Applying wind elemental effect! The user is surrounded by a storm and has increased speed.");
    }
}



class EarthFeature implements ElementalFeature {
    @Override
    public void elementalAttack(Monster opponent, Monster attacker) {
        // Implementasi serangan elemen api
        System.out.println(attacker.getName() + " menggunakan serangan elemen api!");

        int damage;
        // Menghitung damage berdasarkan level monster yang menyerang
        if (opponent.getElement() == Element.WIND) {
            damage = (int) (0.3 * attacker.getLevel()) + 10; // More damage for effective attack
            System.out.println("It's super effective! The fire attack deals " + damage + " damage!");
        } else {
            damage = (int) (0.15 * attacker.getLevel()) + 5; // Less damage for non-effective attack
            System.out.println("The fire attack deals " + damage + " damage.");
        }

        opponent.setHealthPoints(opponent.getHealthPoints() - damage);
        System.out.println(opponent.getName() + " now has " + opponent.getHealthPoints() + " HP.");
    }

    @Override
    public void applyElementalEffect() {
        System.out.println("Applying earth elemental effect! The user is reinforced by earth and has increased defense.");
    }
}



class IceFeature implements ElementalFeature {
    @Override
    public void elementalAttack(Monster opponent, Monster attacker) {
        // Implementasi serangan elemen api
        System.out.println(attacker.getName() + " menggunakan serangan elemen api!");

        int damage;
        // Menghitung damage berdasarkan level monster yang menyerang
        if (opponent.getElement() == Element.WIND) {
            damage = (int) (0.3 * attacker.getLevel()) + 10; // More damage for effective attack
            System.out.println("It's super effective! The fire attack deals " + damage + " damage!");
        } else {
            damage = (int) (0.15 * attacker.getLevel()) + 5; // Less damage for non-effective attack
            System.out.println("The fire attack deals " + damage + " damage.");
        }

        opponent.setHealthPoints(opponent.getHealthPoints() - damage);
        System.out.println(opponent.getName() + " now has " + opponent.getHealthPoints() + " HP.");
    }

    @Override
    public void applyElementalEffect() {
        System.out.println("Applying ice elemental effect! The target is frozen and has reduced speed.");
    }
}



