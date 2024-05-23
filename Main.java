package projek_akhir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi home base dan monster pemain
        HomeBase homeBase = new HomeBase();
        List<Monster> allMonsters = new ArrayList<>();
        allMonsters.add(new ConcreteMonster("Ditto", 5, 48, Element.WIND, new WindFeature()));
        allMonsters.add(new ConcreteMonster("Bulbasaur", 5, 58, Element.EARTH, new EarthFeature()));
        allMonsters.add(new ConcreteMonster("Charmander", 5, 78, Element.FIRE, new FireFeature()));
        allMonsters.add(new ConcreteMonster("Squirtle", 5, 79, Element.WATER, new WaterFeature()));
        allMonsters.add(new ConcreteMonster("Pikachu", 5, 60, Element.FIRE, new FireFeature()));
        allMonsters.add(new ConcreteMonster("Sandslash", 5, 70, Element.ICE, new IceFeature()));
        allMonsters.add(new ConcreteMonster("Golem", 5, 80, Element.EARTH, new EarthFeature()));
        allMonsters.add(new ConcreteMonster("Spheal", 5, 90, Element.WATER, new WaterFeature()));

        List<Monster> playerMonsters = new ArrayList<>();

        // Scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih 3 monster untuk dibawa ke dungeon:");
        for (int i = 0; i < allMonsters.size(); i++) {
            System.out.println((i + 1) + ") " + allMonsters.get(i).getName() + " - Element: " + allMonsters.get(i).getElement() + ", HP: " + allMonsters.get(i).getHealthPoints());
        }
        while (playerMonsters.size() < 3) {
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= allMonsters.size() && !playerMonsters.contains(allMonsters.get(choice - 1))) {
                playerMonsters.add(allMonsters.get(choice - 1));
                System.out.println(allMonsters.get(choice - 1).getName() + " ditambahkan ke tim Anda.");
            } else {
                System.out.println("Pilihan tidak valid atau monster sudah dipilih.");
            }
        }

        // Inisialisasi pemain
        Player player = new Player(playerMonsters, homeBase);

        // Memulai permainan
        startGame(player);

        scanner.close();
    }

    public static void startGame(Player player) {
        List<Monster> playerMonsters = player.getMonsters();
        Dungeon dungeon = new Dungeon();
        boolean gameRunning = true;
        boolean inDungeon = false;
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            if (!inDungeon) {
                System.out.println("Anda berada di home base. Pilih tindakan:");
                System.out.println("1) Lihat Monster 2) Beli Item 3) Gunakan Item 4) Pergi ke Dungeon 5) Keluar");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Monster yang Anda miliki:");
                        for (Monster monster : playerMonsters) {
                            System.out.println(monster.getName() + " - Level: " + monster.getLevel() + ", HP: " + monster.getHealthPoints() + ", EP: " + monster.getExperiencePoints());
                        }
                        break;
                    case 2:
                        System.out.println("Pilih item untuk dibeli:");
                        System.out.println("1) Health Potion (10 HP)");
                        System.out.println("2) Fire Potion (15 FP)");
                        System.out.println("3) Water Potion (15 WP)");
                        System.out.println("4) Wind Potion (15 WP)");
                        System.out.println("5) Earth Potion (15 EP)");
                        System.out.println("6) Ice Potion (15 IP)");
                        System.out.println("7) Keluar");
                        int buyChoice = scanner.nextInt();
                        switch (buyChoice) {
                            case 1:
                                player.buyItem("Health Potion");
                                break;
                            case 2:
                                player.buyItem("Fire Potion");
                                break;
                            case 3:
                                player.buyItem("Water Potion");
                                break;
                            case 4:
                                player.buyItem("Wind Potion");
                                break;
                            case 5:
                                player.buyItem("Earth Potion");
                                break;
                            case 6:
                                player.buyItem("Ice Potion");
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                        break;
                    case 3:
                        System.out.println("Pilih item untuk digunakan:");
                        List<Item> inventory = player.getInventory();
                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.println((i + 1) + ") " + inventory.get(i).getType());
                        }
                        int itemChoice = scanner.nextInt();
                        if (itemChoice > 0 && itemChoice <= inventory.size()) {
                            player.useItem(inventory.get(itemChoice - 1));
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        break;
                    case 4:
                        inDungeon = true;
                        break;
                    case 5:
                        gameRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } else {
                dungeon.enterDungeon(player);
                List<Monster> wildMonsters = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    wildMonsters.add(dungeon.encounterMonster());
                }

                for (Monster wildMonster : wildMonsters) {
                    System.out.println("Bertemu dengan " + wildMonster.getName());
                    player.battle(wildMonster);

                    if (player.getCurrentMonster().getHealthPoints() <= 0) {
                        System.out.println("Semua monster Anda telah dikalahkan!");
                        gameRunning = false;
                        break;
                    }

                    if (wildMonster.getHealthPoints() <= 0) {
                        System.out.println(wildMonster.getName() + " dikalahkan!");
                    }
                }

                inDungeon = false;
            }
        }

        scanner.close();
    }
}
