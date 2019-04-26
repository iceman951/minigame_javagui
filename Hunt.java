import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Hunt extends JFrame {
    public Hunt(Novice novice, Monster monster) {

        super("Hunt");
        setSize(400, 340);
        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);

        GridBagConstraints gbc = new GridBagConstraints();
        Insets ins = new Insets(5, 5, 5, 5);
        int anc = GridBagConstraints.WEST;

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Your Name: " + novice.getName()), gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 1;
        gbc.gridy = 1;
        JButton attackButton = new JButton("Attack");
        add(attackButton, gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton runButton = new JButton("Run");
        add(runButton, gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(new JLabel("Monster: " + monster.getName()), gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel noviceHp = new JLabel("HP: " + novice.getHp() + "/" + novice.getMaxHp());
        add(noviceHp, gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 2;
        gbc.gridy = 2;
        JLabel monsterHp = new JLabel("HP: " + monster.getHp() + "/" + monster.getMaxHp());
        add(monsterHp, gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Atk: " + novice.getAttackPower()), gbc);

        gbc.anchor = anc;
        gbc.insets = ins;
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(new JLabel("Atk: " + monster.getAttackPower()), gbc);

        gbc.anchor = anc;
            gbc.insets = ins;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel(new ImageIcon("novice.png")), gbc);

        if (monster.getName() == "Goblin"){
            gbc.anchor = anc;
            gbc.insets = ins;
            gbc.gridx = 2;
            gbc.gridy = 0;
            add(new JLabel(new ImageIcon("Goblin.png")), gbc);
        }
        else if (monster.getName() == "Slime"){
            gbc.anchor = anc;
            gbc.insets = ins;
            gbc.gridx = 2;
            gbc.gridy = 0;
            add(new JLabel(new ImageIcon("Slime.png")), gbc);
        }
        else if (monster.getName() == "Org"){
            gbc.anchor = anc;
            gbc.insets = ins;
            gbc.gridx = 2;
            gbc.gridy = 0;
            add(new JLabel(new ImageIcon("Org.png")), gbc);
        }

        runButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Home(novice);
                dispose();
            }
        });
        
        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                novice.takeDamage(monster.getAttackPower());
                monster.takeDamage(novice.getAttackPower());
                noviceHp.setText("HP: " + novice.getHp() + "/" + novice.getMaxHp());
                monsterHp.setText("HP: " + monster.getHp() + "/" + monster.getMaxHp());
                if (novice.getHp() <= 0) {
                    novice.reborn();
                    new Home(novice);
                    dispose();
                }
                else if (monster.getHp() <= 0) {
                    novice.takeMoney(monster.getExp());
                    novice.expGain(monster.getExp());
                    novice.stackKill();
                    novice.levelUp(novice.getExp(), novice.getLevel());
                    new Home(novice);
                    dispose();
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}