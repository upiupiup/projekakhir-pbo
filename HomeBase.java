package projek_akhir;

import java.util.ArrayList;
import java.util.List;

public class HomeBase {
    private List<Item> availableItems;
    private List<Item> purchasedItems;

    public HomeBase() {
        this.availableItems = new ArrayList<>();
        this.purchasedItems = new ArrayList<>();
        initializeItems();
    }

    private void initializeItems() {
        availableItems.add(new Item("Health Potion", "Restores HP", 10));
        availableItems.add(new Item("Fire Potion", "Fire Attack", 15));
        availableItems.add(new Item("Water Potion", "Water Attack", 15));
        availableItems.add(new Item("Wind Potion", "Wind Attack", 15));
        availableItems.add(new Item("Earth Potion", "Earth Attack", 15));
        availableItems.add(new Item("Ice Potion", "Ice Attack", 15));
    }

    public Item buyItem(Player player, String itemName) {
        for (Item item : availableItems) {
            if (item.getType().equalsIgnoreCase(itemName)) {
                if (player.getCurrentMonster().getExperiencePoints() >= item.getCost()) {
                    player.getCurrentMonster().setExperiencePoints(player.getCurrentMonster().getExperiencePoints() - item.getCost());
                    purchasedItems.add(item);
                    System.out.println("Purchased " + item.getType());
                    return item;
                } else {
                    System.out.println("Not enough EP to buy " + item.getType());
                    return null;
                }
            }
        }
        System.out.println("Item not found: " + itemName);
        return null;
    }

    public List<Item> getPurchasedItems() {
        return purchasedItems;
    }
}
