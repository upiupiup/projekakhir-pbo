package projek_akhir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUIGame extends javax.swing.JFrame {
    private ButtonGroup buttonGroup1;
    private BackgroundPane1 jPanel1;
    private HomeBase homeBase;
    private javax.swing.JToggleButton actionExitGame;
    private javax.swing.JToggleButton actionHelpGame;
    private javax.swing.JToggleButton actionPlayGame;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSplitPane jSplitPane1;

    private Player player;
    private Dungeon dungeon;
    private JLabel battleStatusLabel;
    private JTextArea battleLogTextArea;

    private JButton attackButton;
    private JButton specialAttackButton;
    private JButton elementalAttackButton;
    private JButton defendButton;
    private JButton useItemButton;
    private JButton runButton;

    private BufferedWriter battleLogWriter;
    private JPanel playerPanel;
    private JPanel enemyPanel;

    public GUIGame() {
        initComponents();
        homeBase = new HomeBase();
        
        try {
            battleLogWriter = new BufferedWriter(new FileWriter("battle_log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new BackgroundPane1(System.getProperty("user.home") + "/Downloads/pokemon1.jpg");
        jLabel1 = new javax.swing.JLabel();
        actionExitGame = new javax.swing.JToggleButton();
        actionPlayGame = new javax.swing.JToggleButton();
        actionHelpGame = new javax.swing.JToggleButton();

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        buttonGroup1.add(actionExitGame);
        buttonGroup1.add(actionPlayGame);
        buttonGroup1.add(actionHelpGame);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("GAME POKEMON UHUYY");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        actionExitGame.setFont(new java.awt.Font("Tahoma", 1, 25));
        actionExitGame.setText("EXIT");
        actionExitGame.setPreferredSize(new Dimension(150, 50));
        actionExitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionExitGameActionPerformed(evt);
            }
        });

        actionPlayGame.setFont(new java.awt.Font("Tahoma", 1, 25));
        actionPlayGame.setText("PLAY");
        actionPlayGame.setPreferredSize(new Dimension(150, 50));
        actionPlayGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPlayGameActionPerformed(evt);
            }
        });

        actionHelpGame.setFont(new java.awt.Font("Tahoma", 1, 25));
        actionHelpGame.setText("HELP");
        actionHelpGame.setPreferredSize(new Dimension(150, 50));
        actionHelpGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionHelpGameActionPerformed(evt);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 300));
        buttonPanel.add(actionPlayGame);
        buttonPanel.add(actionHelpGame);
        buttonPanel.add(actionExitGame);

        jPanel1.add(jLabel1, BorderLayout.NORTH);
        jPanel1.add(buttonPanel, BorderLayout.CENTER);

        jMenu1.setText("Homebase");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Dungeon");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

private void actionPlayGameActionPerformed(java.awt.event.ActionEvent evt) {
    List<Monster> monsterList = new ArrayList<>();
    monsterList.add(new ConcreteMonster("Ditto", 5, 48, Element.WIND, new WindFeature()));
    monsterList.add(new ConcreteMonster("Bulbasaur", 5, 58, Element.EARTH, new EarthFeature()));
    monsterList.add(new ConcreteMonster("Charmander", 5, 78, Element.FIRE, new FireFeature()));
    monsterList.add(new ConcreteMonster("Squirtle", 5, 79, Element.WATER, new WaterFeature()));
    monsterList.add(new ConcreteMonster("Pikachu", 5, 60, Element.FIRE, new FireFeature()));
    monsterList.add(new ConcreteMonster("Sandslash", 5, 70, Element.ICE, new IceFeature()));
    monsterList.add(new ConcreteMonster("Golem", 5, 80, Element.EARTH, new EarthFeature()));
    monsterList.add(new ConcreteMonster("Spheal", 5, 90, Element.WATER, new WaterFeature()));

    HomeBase homeBase = new HomeBase();
    player = new Player(monsterList, homeBase);

    JOptionPane.showMessageDialog(this, "Permainan dimulai. Silakan pilih aksi di Homebase.");
    showHomebase();
}


private void showHomebase() {
     JFrame homebaseFrame = new JFrame("Homebase");
    homebaseFrame.setSize(1366, 768);
    homebaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    BackgroundPane1 homebasePanel = new BackgroundPane1(System.getProperty("user.home") + "/Downloads/pokemon1.jpg");
    homebasePanel.setLayout(new BorderLayout());

    JLabel homebaseLabel = new JLabel("Homebase");
    homebaseLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
    homebaseLabel.setForeground(new java.awt.Color(255, 255, 255));
    homebaseLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JButton lihatMonsterButton = new JButton("Lihat Monster");
    JButton beliItemButton = new JButton("Beli Item");
    JButton gunakanItemButton = new JButton("Pulihkan HP");
    JButton pergiKeDungeonButton = new JButton("Pergi ke Dungeon");
    JButton levelUpButton = new JButton("Level Up");
    JButton evolveButton = new JButton("Evolve Monster");
    JButton keluarButton = new JButton("Keluar");

    lihatMonsterButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    lihatMonsterButton.setPreferredSize(new Dimension(200, 70));
    beliItemButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    beliItemButton.setPreferredSize(new Dimension(200, 70));
    gunakanItemButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    gunakanItemButton.setPreferredSize(new Dimension(200, 70));
    pergiKeDungeonButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    pergiKeDungeonButton.setPreferredSize(new Dimension(200, 70));
    levelUpButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    levelUpButton.setPreferredSize(new Dimension(200, 70));
    evolveButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    evolveButton.setPreferredSize(new Dimension(200, 70));
    keluarButton.setFont(new java.awt.Font("Tahoma", 1, 25));
    keluarButton.setPreferredSize(new Dimension(200, 70));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setOpaque(false);
    buttonPanel.setLayout(new GridLayout(4, 2, 20, 20));
    buttonPanel.add(lihatMonsterButton);
    buttonPanel.add(beliItemButton);
    buttonPanel.add(gunakanItemButton);
    buttonPanel.add(levelUpButton);
    buttonPanel.add(evolveButton);
    buttonPanel.add(pergiKeDungeonButton);
    buttonPanel.add(keluarButton);
    
    evolveButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        List<Monster> monsters = player.getMonsters();
        String[] monsterNames = new String[monsters.size()];
        for (int i = 0; i < monsters.size(); i++) {
            monsterNames[i] = monsters.get(i).getName();
        }

        String chosenMonsterName = (String) JOptionPane.showInputDialog(homebaseFrame,
                "Pilih monster untuk evolusi:",
                "Pilih Monster",
                JOptionPane.PLAIN_MESSAGE,
                null,
                monsterNames,
                monsterNames[0]);

        if (chosenMonsterName != null) {
            Monster chosenMonster = null;
            for (Monster monster : monsters) {
                if (monster.getName().equals(chosenMonsterName)) {
                    chosenMonster = monster;
                    break;
                }
            }

            if (chosenMonster != null) {
                List<Element> possibleEvolutions = homeBase.getPossibleEvolutions(chosenMonster.getElement());
                String[] evolutionOptions = new String[possibleEvolutions.size()];
                for (int i = 0; i < possibleEvolutions.size(); i++) {
                    evolutionOptions[i] = possibleEvolutions.get(i).toString();
                }

                String chosenEvolution = (String) JOptionPane.showInputDialog(homebaseFrame,
                        "Pilih evolusi untuk " + chosenMonster.getName() + ":",
                        "Pilih Evolusi",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        evolutionOptions,
                        evolutionOptions[0]);

                if (chosenEvolution != null) {
                    Element newElement = Element.valueOf(chosenEvolution);
                    boolean evolutionSuccess = homeBase.evolveMonster(chosenMonster, newElement);
                    if (evolutionSuccess) {
                        JOptionPane.showMessageDialog(homebaseFrame, chosenMonster.getName() + " berhasil berevolusi menjadi elemen " + newElement + "!");
                    } else {
                        JOptionPane.showMessageDialog(homebaseFrame, chosenMonster.getName() + " tidak memiliki EP yang cukup untuk berevolusi!");
                    }
                }
            }
        }
    }
});


    lihatMonsterButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            StringBuilder monsterInfo = new StringBuilder("Monster yang Anda miliki:\n");
            for (Monster monster : player.getMonsters()) {
                monsterInfo.append(monster.getName()).append(" - Level: ")
                        .append(monster.getLevel()).append(", HP: ")
                        .append(monster.getHealthPoints()).append(", EP: ")
                        .append(monster.getExperiencePoints()).append("\n");
            }
            JOptionPane.showMessageDialog(homebaseFrame, monsterInfo.toString());
        }
    });

    beliItemButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            List<Monster> monsters = player.getMonsters();
            String[] monsterNames = new String[monsters.size()];
            for (int i = 0; i < monsters.size(); i++) {
                monsterNames[i] = monsters.get(i).getName();
            }

            String chosenMonsterName = (String) JOptionPane.showInputDialog(homebaseFrame,
                    "Pilih monster yang akan membeli item:",
                    "Pilih Monster",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    monsterNames,
                    monsterNames[0]);

            if (chosenMonsterName != null) {
                Monster chosenMonster = null;
                for (Monster monster : monsters) {
                    if (monster.getName().equals(chosenMonsterName)) {
                        chosenMonster = monster;
                        break;
                    }
                }

                if (chosenMonster != null) {
                    String[] items = {"Health Potion", "Fire Potion", "Water Potion", "Wind Potion", "Earth Potion", "Ice Potion"};
                    String chosenItem = (String) JOptionPane.showInputDialog(homebaseFrame,
                            "Pilih item untuk dibeli:",
                            "Beli Item",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            items,
                            items[0]);

                    if (chosenItem != null) {
                        boolean purchaseSuccess = player.buyItem(chosenMonster, chosenItem);
                        if (purchaseSuccess) {
                            JOptionPane.showMessageDialog(homebaseFrame, "Item " + chosenItem + " berhasil dibeli untuk " + chosenMonster.getName() + "!");
                        } else {
                            JOptionPane.showMessageDialog(homebaseFrame, chosenMonster.getName() + " tidak memiliki EP yang cukup untuk membeli item " + chosenItem + "!");
                        }
                    }
                }
            }
        }
    });

    gunakanItemButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            player.healAllMonsters();
            JOptionPane.showMessageDialog(homebaseFrame, "Semua monster telah dipulihkan ke HP penuh!");
        }
    });

    levelUpButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            List<Monster> monsters = player.getMonsters();
            String[] monsterNames = new String[monsters.size()];
            for (int i = 0; i < monsters.size(); i++) {
                monsterNames[i] = monsters.get(i).getName();
            }

            String chosenMonsterName = (String) JOptionPane.showInputDialog(homebaseFrame,
                    "Pilih monster yang akan dinaikkan levelnya:",
                    "Pilih Monster",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    monsterNames,
                    monsterNames[0]);

            if (chosenMonsterName != null) {
                Monster chosenMonster = null;
                for (Monster monster : monsters) {
                    if (monster.getName().equals(chosenMonsterName)) {
                        chosenMonster = monster;
                        break;
                    }
                }

                if (chosenMonster != null) {
                    boolean levelUpSuccess = player.levelUpMonster(chosenMonster);
                    if (levelUpSuccess) {
                        JOptionPane.showMessageDialog(homebaseFrame, chosenMonster.getName() + " berhasil naik level!");
                    } else {
                        JOptionPane.showMessageDialog(homebaseFrame, chosenMonster.getName() + " tidak memiliki EP yang cukup untuk naik level!");
                    }
                }
            }
        }
    });

    pergiKeDungeonButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            List<Monster> monsters = player.getMonsters();
            String[] monsterNames = new String[monsters.size()];
            for (int i = 0; i < monsters.size(); i++) {
                monsterNames[i] = monsters.get(i).getName();
            }

            List<Monster> chosenMonsters = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                String chosenMonsterName = (String) JOptionPane.showInputDialog(homebaseFrame,
                        "Pilih monster " + (i + 1) + " untuk pergi ke dungeon:",
                        "Pilih Monster",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        monsterNames,
                        monsterNames[0]);

                if (chosenMonsterName != null) {
                    for (Monster monster : monsters) {
                        if (monster.getName().equals(chosenMonsterName)) {
                            chosenMonsters.add(monster);
                            break;
                        }
                    }
                }
            }

            if (chosenMonsters.size() == 3) {
                player.setDungeonMonsters(chosenMonsters); // Set the chosen monsters to the player
                dungeon = new Dungeon();
                JOptionPane.showMessageDialog(homebaseFrame, "Anda pergi ke dungeon!");
                showDungeon();
                homebaseFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(homebaseFrame, "Anda harus memilih 3 monster untuk pergi ke dungeon.");
            }
        }
    });

    keluarButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(homebaseFrame, "Apakah Anda ingin keluar?", "Keluar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    });

    homebasePanel.add(homebaseLabel, BorderLayout.NORTH);
    homebasePanel.add(buttonPanel, BorderLayout.CENTER);

    homebaseFrame.add(homebasePanel);
    homebaseFrame.setVisible(true);
}





    private void showDungeon() {
        JFrame dungeonFrame = new JFrame("Dungeon");
        dungeonFrame.setSize(1366, 768);
        dungeonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPane1 dungeonPanel = new BackgroundPane1(System.getProperty("user.home") + "/Downloads/pokemon1.jpg");
        dungeonPanel.setLayout(new BorderLayout());

        JLabel dungeonLabel = new JLabel("Dungeon");
        dungeonLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
        dungeonLabel.setForeground(new java.awt.Color(255, 255, 255));
        dungeonLabel.setHorizontalAlignment(SwingConstants.CENTER);

        battleStatusLabel = new JLabel("");
        battleStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 25));
        battleStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        battleStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        battleLogTextArea = new JTextArea();
        battleLogTextArea.setEditable(false);
        battleLogTextArea.setFont(new java.awt.Font("Tahoma", 1, 18));
        battleLogTextArea.setForeground(new java.awt.Color(255, 255, 255));
        battleLogTextArea.setBackground(new java.awt.Color(0, 0, 0));

        attackButton = new JButton("Attack");
        specialAttackButton = new JButton("Special Attack");
        elementalAttackButton = new JButton("Elemental Attack");
        defendButton = new JButton("Defend");
        useItemButton = new JButton("Use Item");
        runButton = new JButton("Run");

        attackButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        attackButton.setPreferredSize(new Dimension(150, 50));
        specialAttackButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        specialAttackButton.setPreferredSize(new Dimension(150, 50));
        elementalAttackButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        elementalAttackButton.setPreferredSize(new Dimension(150, 50));
        defendButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        defendButton.setPreferredSize(new Dimension(150, 50));
        useItemButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        useItemButton.setPreferredSize(new Dimension(150, 50));
        runButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        runButton.setPreferredSize(new Dimension(150, 50));

        JPanel battlePanel = new JPanel();
        battlePanel.setOpaque(false);
        battlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));

        battlePanel.add(attackButton);
        battlePanel.add(specialAttackButton);
        battlePanel.add(elementalAttackButton);
        battlePanel.add(defendButton);
        battlePanel.add(useItemButton);
        battlePanel.add(runButton);

        playerPanel = new JPanel();
        playerPanel.setOpaque(false);
        playerPanel.setPreferredSize(new Dimension(200, 200));

        enemyPanel = new JPanel();
        enemyPanel.setOpaque(false);
        enemyPanel.setPreferredSize(new Dimension(200, 200));

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setOpaque(false);
        statusPanel.add(playerPanel, BorderLayout.WEST);
        statusPanel.add(battleStatusLabel, BorderLayout.CENTER);
        statusPanel.add(enemyPanel, BorderLayout.EAST);

        dungeonPanel.add(dungeonLabel, BorderLayout.NORTH);
        dungeonPanel.add(statusPanel, BorderLayout.CENTER);
        dungeonPanel.add(battlePanel, BorderLayout.SOUTH);

        dungeonFrame.add(dungeonPanel);
        dungeonFrame.setVisible(true);

        List<Monster> wildMonsters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            wildMonsters.add(dungeon.encounterMonster());
        }

        if (!wildMonsters.isEmpty()) {
            encounterWildMonster(dungeonFrame, wildMonsters.get(0), wildMonsters.subList(1, wildMonsters.size()));
        }
    }

    private void encounterWildMonster(JFrame dungeonFrame, Monster wildMonster, List<Monster> remainingWildMonsters) {
    JOptionPane.showMessageDialog(dungeonFrame, "Monster anda sekarang adalah " + player.getCurrentMonster().getName() + ". Bertemu dengan " + wildMonster.getName());
    updateBattleStatus(player.getCurrentMonster(), wildMonster);

    playerPanel.removeAll();
    playerPanel.add(new MonsterPanel(player.getCurrentMonster()));
    playerPanel.revalidate();
    playerPanel.repaint();

    enemyPanel.removeAll();
    enemyPanel.add(new MonsterPanel(wildMonster));
    enemyPanel.revalidate();
    enemyPanel.repaint();

    // Clear existing action listeners
    clearActionListeners(attackButton);
    clearActionListeners(specialAttackButton);
    clearActionListeners(elementalAttackButton);
    clearActionListeners(defendButton);
    clearActionListeners(useItemButton);
    clearActionListeners(runButton);

    attackButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String log = player.getCurrentMonster().attack(wildMonster);
            appendBattleLog(log);
            logToFile(log);
            JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
            checkBattleOutcome(dungeonFrame, wildMonster, remainingWildMonsters);
            addEffect(playerPanel, enemyPanel);
        }
    });

    specialAttackButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String log = player.getCurrentMonster().specialAttack(wildMonster);
            appendBattleLog(log);
            logToFile(log);
            JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
            checkBattleOutcome(dungeonFrame, wildMonster, remainingWildMonsters);
            addEffect(playerPanel, enemyPanel);
        }
    });

    elementalAttackButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String log = player.getCurrentMonster().elementalAttack(wildMonster);
            appendBattleLog(log);
            logToFile(log);
            JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
            checkBattleOutcome(dungeonFrame, wildMonster, remainingWildMonsters);
            addEffect(playerPanel, enemyPanel);
        }
    });

    defendButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String log = player.getCurrentMonster().defend();
            appendBattleLog(log);
            logToFile(log);
            JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
            addEffect(playerPanel, enemyPanel);
        }
    });

    useItemButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            List<Item> inventory = player.getInventory();
            if (inventory.isEmpty()) {
                String log = "No items available!";
                appendBattleLog(log);
                logToFile(log);
                JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
            } else {
                JComboBox<String> itemComboBox = new JComboBox<>();
                for (Item item : inventory) {
                    itemComboBox.addItem(item.getType());
                }
                JButton confirmButton = new JButton("Use Item");

                JPanel itemPanel = new JPanel();
                itemPanel.add(itemComboBox);
                itemPanel.add(confirmButton);

                enemyPanel.removeAll();
                enemyPanel.add(itemPanel);
                enemyPanel.revalidate();
                enemyPanel.repaint();

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String chosenItem = (String) itemComboBox.getSelectedItem();
                        for (Item item : inventory) {
                            if (item.getType().equals(chosenItem)) {
                                player.useItem(item);
                                String log = "Item " + chosenItem + " digunakan!";
                                appendBattleLog(log);
                                logToFile(log);
                                JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
                                break;
                            }
                        }
                        // After using the item, remove the item panel
                        enemyPanel.remove(itemPanel);
                        enemyPanel.revalidate();
                        enemyPanel.repaint();
                    }
                });
            }
        }
    });

    runButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            String log;
            if (random.nextDouble() > 0.5) {
                log = player.getCurrentMonster().getName() + " berhasil melarikan diri!";
                appendBattleLog(log);
                logToFile(log);
                JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
                dungeonFrame.dispose();
                showHomebase();
            } else {
                log = "Failed to run away!";
                appendBattleLog(log);
                logToFile(log);
                JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
            }
        }
    });
}

private void clearActionListeners(JButton button) {
    ActionListener[] listeners = button.getActionListeners();
    for (ActionListener listener : listeners) {
        button.removeActionListener(listener);
    }
}


    private void checkBattleOutcome(JFrame dungeonFrame, Monster wildMonster, List<Monster> remainingWildMonsters) {
    if (player.getCurrentMonster().getHealthPoints() <= 0) {
        String log = "Semua monster Anda telah dikalahkan!";
        appendBattleLog(log);
        logToFile(log);
        JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result
        JOptionPane.showMessageDialog(dungeonFrame, "Semua monster Anda telah dikalahkan!");
        System.exit(0);
    } else if (wildMonster.getHealthPoints() <= 0) {
        String log = wildMonster.getName() + " dikalahkan!";
        appendBattleLog(log);
        logToFile(log);
        JOptionPane.showMessageDialog(dungeonFrame, log); // Show action result

        // Add EP to the player's current monster and update status label
        player.getCurrentMonster().addEP(50);
        String epGainLog = player.getCurrentMonster().getName() + " berhasil mendapatkan 50 EP!";
        appendBattleLog(epGainLog);
        logToFile(epGainLog);
        JOptionPane.showMessageDialog(dungeonFrame, epGainLog); // Show EP gain result

        updateBattleStatus(player.getCurrentMonster(), null); // Update battle status label
        battleStatusLabel.setText(epGainLog); // Update the label to show EP gain

        int option = JOptionPane.showOptionDialog(dungeonFrame,
                "Anda berhasil mengalahkan " + wildMonster.getName() + ". Apa yang ingin Anda lakukan selanjutnya?",
                "Battle Outcome",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Lanjutkan Battle", "Kembali ke Homebase"},
                "Lanjutkan Battle");
        if (option == JOptionPane.YES_OPTION && !remainingWildMonsters.isEmpty()) {
            encounterWildMonster(dungeonFrame, remainingWildMonsters.get(0), remainingWildMonsters.subList(1, remainingWildMonsters.size()));
        } else {
            dungeonFrame.dispose();
            showHomebase();
        }
    }
}



    private void logToFile(String log) {
        try {
            battleLogWriter.write(log + "\n");
            battleLogWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBattleStatus(Monster playerMonster, Monster wildMonster) {
        if (wildMonster != null) {
            battleStatusLabel.setText("Monster anda (" + playerMonster.getName() + ") sedang melawan (" + wildMonster.getName() + ")");
        } else {
            battleStatusLabel.setText("Monster anda (" + playerMonster.getName() + ") tidak melawan apapun");
        }
    }

    private void appendBattleLog(String message) {
        battleLogTextArea.append(message + "\n");
    }

    private void addEffect(JPanel attackerPanel, JPanel defenderPanel) {
        Timer timer = new Timer(50, new ActionListener() {
            int count = 0;
            boolean toggle = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggle) {
                    attackerPanel.setBackground(Color.YELLOW);
                    defenderPanel.setBackground(Color.ORANGE);
                } else {
                    attackerPanel.setBackground(Color.RED);
                    defenderPanel.setBackground(Color.BLUE);
                }
                toggle = !toggle;
                if (count++ > 10) {
                    ((Timer) e.getSource()).stop();
                    attackerPanel.setBackground(null);
                    defenderPanel.setBackground(null);
                }
            }
        });
        timer.start();
    }

    private void actionHelpGameActionPerformed(java.awt.event.ActionEvent evt) {
        String bantuan = "Selamat datang di GAME POKEMON UHUYY!\n\n"
            + "Petunjuk Permainan:\n"
            + "1. Tekan tombol 'PLAY' untuk memulai permainan.\n"
            + "2. Setelah permainan dimulai, Anda akan memasuki dunia Pokemon.\n"
            + "3. Pilih Pokemon Anda dan mulai petualangan Anda dengan melawan berbagai musuh.\n"
            + "4. Kalahkan musuh untuk mendapatkan pengalaman dan menaikkan level Pokemon Anda.\n"
            + "5. Gunakan item yang Anda temukan untuk memperkuat Pokemon Anda.\n"
            + "6. Anda dapat menyimpan permainan Anda kapan saja dan melanjutkannya nanti.\n"
            + "7. Jika Anda ingin keluar dari permainan, tekan tombol 'EXIT'.\n\n"
            + "Tips:\n"
            + "- Pelajari kelemahan dan kekuatan dari setiap jenis Pokemon untuk memenangkan pertempuran.\n"
            + "- Kumpulkan item langka untuk mendapatkan keuntungan dalam pertempuran.\n"
            + "- Simpan permainan Anda secara teratur untuk menghindari kehilangan progres.\n\n"
            + "Selamat bermain dan semoga berhasil!";
    
        JOptionPane.showMessageDialog(this, bantuan, "Bantuan Permainan", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actionExitGameActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame("EXIT");
        
        if(JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "GAME POKEMON", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIGame frame = new GUIGame();
                frame.setSize(1366, 768);
                frame.setVisible(true);
            }
        });
    }
}
