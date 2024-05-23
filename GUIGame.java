package projek_akhir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIGame extends javax.swing.JFrame {
    private ButtonGroup buttonGroup1;
    private BackgroundPane1 jPanel1;
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

    public GUIGame() {
        initComponents();
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
        String[] monsters = {"Bulbasaur", "Charmander", "Squirtle", "Pikachu", "Sandslash", "Golem", "Spheal"};
        List<String> chosenMonsters = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String chosenMonster = (String) JOptionPane.showInputDialog(this, 
                "Pilih monster " + (i + 1) + ":", 
                "Pilih Monster", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                monsters, 
                monsters[0]);
            if (chosenMonster != null) {
                chosenMonsters.add(chosenMonster);
            } else {
                return;
            }
        }

        if (chosenMonsters.size() == 3) {
            List<Monster> monsterList = new ArrayList<>();
            for (String chosenMonster : chosenMonsters) {
                switch (chosenMonster) {
                    case "Bulbasaur":
                        monsterList.add(new ConcreteMonster("Bulbasaur", 5, 58, Element.EARTH, new EarthFeature()));
                        break;
                    case "Charmander":
                        monsterList.add(new ConcreteMonster("Charmander", 5, 78, Element.FIRE, new FireFeature()));
                        break;
                    case "Squirtle":
                        monsterList.add(new ConcreteMonster("Squirtle", 5, 79, Element.WATER, new WaterFeature()));
                        break;
                    case "Pikachu":
                        monsterList.add(new ConcreteMonster("Pikachu", 5, 60, Element.FIRE, new FireFeature()));
                        break;
                    case "Sandslash":
                        monsterList.add(new ConcreteMonster("Sandslash", 5, 70, Element.ICE, new IceFeature()));
                        break;
                    case "Golem":
                        monsterList.add(new ConcreteMonster("Golem", 5, 80, Element.EARTH, new EarthFeature()));
                        break;
                    case "Spheal":
                        monsterList.add(new ConcreteMonster("Spheal", 5, 90, Element.WATER, new WaterFeature()));
                        break;
                }
            }

            HomeBase homeBase = new HomeBase();
            player = new Player(monsterList, homeBase);

            for (String chosenMonster : chosenMonsters) {
                for (Monster monster : monsterList) {
                    if (monster.getName().equals(chosenMonster)) {
                        player.selectMonster(monster);
                    }
                }
            }

            JOptionPane.showMessageDialog(this, "Monster yang dipilih: " + String.join(", ", chosenMonsters));
            showHomebase();
        }
    }

    private void showHomebase() {
        JFrame homebaseFrame = new JFrame("Homebase");
        homebaseFrame.setSize(1366, 768); // Sama dengan ukuran frame utama
        homebaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPane1 homebasePanel = new BackgroundPane1(System.getProperty("user.home") + "/Downloads/pokemon1.jpg"); // Sama dengan gambar background utama
        homebasePanel.setLayout(new BorderLayout());

        JLabel homebaseLabel = new JLabel("Homebase");
        homebaseLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
        homebaseLabel.setForeground(new java.awt.Color(255, 255, 255));
        homebaseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton lihatMonsterButton = new JButton("Lihat Monster");
        JButton beliItemButton = new JButton("Beli Item");
        JButton gunakanItemButton = new JButton("Gunakan Item");
        JButton pergiKeDungeonButton = new JButton("Pergi ke Dungeon");
        JButton keluarButton = new JButton("Keluar");

        lihatMonsterButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        lihatMonsterButton.setPreferredSize(new Dimension(150, 50));
        beliItemButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        beliItemButton.setPreferredSize(new Dimension(150, 50));
        gunakanItemButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        gunakanItemButton.setPreferredSize(new Dimension(150, 50));
        pergiKeDungeonButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        pergiKeDungeonButton.setPreferredSize(new Dimension(150, 50));
        keluarButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        keluarButton.setPreferredSize(new Dimension(150, 50));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));
        buttonPanel.add(lihatMonsterButton);
        buttonPanel.add(beliItemButton);
        buttonPanel.add(gunakanItemButton);
        buttonPanel.add(pergiKeDungeonButton);
        buttonPanel.add(keluarButton);

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
                String[] items = {"Health Potion", "Fire Potion", "Water Potion", "Wind Potion", "Earth Potion", "Ice Potion"};
                String chosenItem = (String) JOptionPane.showInputDialog(homebaseFrame, 
                    "Pilih item untuk dibeli:", 
                    "Beli Item", 
                    JOptionPane.PLAIN_MESSAGE, 
                    null, 
                    items, 
                    items[0]);
                if (chosenItem != null) {
                    player.buyItem(chosenItem);
                    JOptionPane.showMessageDialog(homebaseFrame, "Item " + chosenItem + " berhasil dibeli!");
                }
            }
        });

        gunakanItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Item> inventory = player.getInventory();
                if (inventory.isEmpty()) {
                    JOptionPane.showMessageDialog(homebaseFrame, "Tidak ada item di inventory!");
                } else {
                    String[] itemArray = new String[inventory.size()];
                    for (int i = 0; i < inventory.size(); i++) {
                        itemArray[i] = inventory.get(i).getType();
                    }
                    String chosenItem = (String) JOptionPane.showInputDialog(homebaseFrame, 
                        "Pilih item untuk digunakan:", 
                        "Gunakan Item", 
                        JOptionPane.PLAIN_MESSAGE, 
                        null, 
                        itemArray, 
                        itemArray[0]);
                    if (chosenItem != null) {
                        for (Item item : inventory) {
                            if (item.getType().equals(chosenItem)) {
                                player.useItem(item);
                                JOptionPane.showMessageDialog(homebaseFrame, "Item " + chosenItem + " digunakan!");
                                break;
                            }
                        }
                    }
                }
            }
        });

        pergiKeDungeonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dungeon = new Dungeon();
                JOptionPane.showMessageDialog(homebaseFrame, "Anda pergi ke dungeon!");
                showDungeon(); // Pindah ke panel dungeon
                homebaseFrame.dispose(); // Tutup jendela homebase
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
        dungeonFrame.setSize(1366, 768); // Sama dengan ukuran frame utama
        dungeonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPane1 dungeonPanel = new BackgroundPane1(System.getProperty("user.home") + "/Downloads/pokemon1.jpg"); // Sama dengan gambar background utama
        dungeonPanel.setLayout(new BorderLayout());

        JLabel dungeonLabel = new JLabel("Dungeon");
        dungeonLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
        dungeonLabel.setForeground(new java.awt.Color(255, 255, 255));
        dungeonLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel battlePanel = new JPanel();
        battlePanel.setOpaque(false);
        battlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));

        JButton attackButton = new JButton("Attack");
        JButton specialAttackButton = new JButton("Special Attack");
        JButton elementalAttackButton = new JButton("Elemental Attack");
        JButton defendButton = new JButton("Defend");
        JButton runButton = new JButton("Run");

        attackButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        attackButton.setPreferredSize(new Dimension(150, 50));
        specialAttackButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        specialAttackButton.setPreferredSize(new Dimension(150, 50));
        elementalAttackButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        elementalAttackButton.setPreferredSize(new Dimension(150, 50));
        defendButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        defendButton.setPreferredSize(new Dimension(150, 50));
        runButton.setFont(new java.awt.Font("Tahoma", 1, 25));
        runButton.setPreferredSize(new Dimension(150, 50));

        battlePanel.add(attackButton);
        battlePanel.add(specialAttackButton);
        battlePanel.add(elementalAttackButton);
        battlePanel.add(defendButton);
        battlePanel.add(runButton);

        dungeonPanel.add(dungeonLabel, BorderLayout.NORTH);
        dungeonPanel.add(battlePanel, BorderLayout.CENTER);

        dungeonFrame.add(dungeonPanel);
        dungeonFrame.setVisible(true);

        List<Monster> wildMonsters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            wildMonsters.add(dungeon.encounterMonster());
        }

        for (Monster wildMonster : wildMonsters) {
            JOptionPane.showMessageDialog(dungeonFrame, "Bertemu dengan " + wildMonster.getName());
            attackButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentMonster().attack(wildMonster);
                    checkBattleOutcome(wildMonster, dungeonFrame);
                }
            });

            specialAttackButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentMonster().specialAttack(wildMonster);
                    checkBattleOutcome(wildMonster, dungeonFrame);
                }
            });

            elementalAttackButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentMonster().elementalAttack(wildMonster);
                    checkBattleOutcome(wildMonster, dungeonFrame);
                }
            });

            defendButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player.getCurrentMonster().defend();
                }
            });

            runButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(dungeonFrame, player.getCurrentMonster().getName() + " berhasil melarikan diri!");
                    dungeonFrame.dispose(); // Kembali ke homebase
                    showHomebase();
                }
            });
        }
    }

    private void checkBattleOutcome(Monster wildMonster, JFrame dungeonFrame) {
        if (player.getCurrentMonster().getHealthPoints() <= 0) {
            JOptionPane.showMessageDialog(dungeonFrame, "Semua monster Anda telah dikalahkan!");
            System.exit(0);
        } else if (wildMonster.getHealthPoints() <= 0) {
            JOptionPane.showMessageDialog(dungeonFrame, wildMonster.getName() + " dikalahkan!");
        }
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
