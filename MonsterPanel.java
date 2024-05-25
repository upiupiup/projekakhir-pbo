/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projek_akhir;

import javax.swing.*;
import java.awt.*;

public class MonsterPanel extends JPanel {
    private Monster monster;

    public MonsterPanel(Monster monster) {
        this.monster = monster;
        setPreferredSize(new Dimension(150, 150));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setBackground(getColorForElement(monster.getElement()));
        add(new JLabel(monster.getName()));
    }

    private Color getColorForElement(Element element) {
        switch (element) {
            case FIRE:
                return Color.RED;
            case WATER:
                return Color.BLUE;
            case EARTH:
                return Color.GREEN;
            case ICE:
                return Color.CYAN;
            case WIND:
                return Color.lightGray;
            default:
                return Color.GRAY;
        }
    }
}
