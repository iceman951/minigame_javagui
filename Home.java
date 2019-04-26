import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Home extends JFrame {

    Hunt hunt;

    public Home(Novice novice) {
        super("Home");

        Container homeContainer = getContentPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel comboPanel = new JPanel();
        //JPanel jobPanel = new JPanel();
        homeContainer.setLayout(new BoxLayout(homeContainer, BoxLayout.X_AXIS));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        //jobPanel.setLayout(new BoxLayout(jobPanel, BoxLayout.X_AXIS));
        homeContainer.add(panel1);
        homeContainer.add(panel2);
        

        ArrayList<JLabel> itemLabels = new ArrayList<JLabel>(novice.bag.getBagCapacity());
        JLabel swordmanPicture = new JLabel(new ImageIcon("Swordman.png"));
        JLabel merchantPicture = new JLabel(new ImageIcon("Merchant.png"));
        JLabel name = new JLabel("Name: " + novice.getName());
        JLabel job = new JLabel("Job: " + novice.getJob());
        JLabel Hp = new JLabel("HP: " + String.valueOf(novice.getHp()) + "/" + String.valueOf(novice.getMaxHp()));
        JLabel level = new JLabel("Level: " + String.valueOf(novice.getLevel()));
        JLabel exp = new JLabel("Exp: " + String.valueOf(novice.getExp()));
        JLabel money = new JLabel("Money: " + String.valueOf(novice.getMoney()));
        JLabel killCount = new JLabel("Kill Count: " + String.valueOf(novice.getKillCount()));
        JButton bagButton = new JButton("Click for Check Items in Bag");
        JButton useMaxPotionButton = new JButton("Use MaxPotion");
        JButton buyMaxPotionButton = new JButton("Buy MaxPotion ($10)");
        JLabel select = new JLabel("Select Monster For Hunt");  
        String[] monsters = { "Slime (Easy)", "Org (Hard)", "Goblin (Medium)", };
        JComboBox comboBox = new JComboBox(monsters);
        JButton huntButton = new JButton("Let's Hunt");
        comboBox.setSelectedIndex(2);
        //JLabel buyJob = new JLabel("Pay 1000 for change Job");
        //JButton swordmanButton = new JButton("Swordman");
        //JButton merchantButton = new JButton("Merchant");

        JLabel space1 = new JLabel(" ");
        JLabel space2 = new JLabel(" ");
        JLabel space3 = new JLabel(" ");
        JLabel space4 = new JLabel(" ");
        JLabel space5 = new JLabel(" ");

        if(novice.getJob().equals("Merchant")){
            panel1.add(merchantPicture);
        }
        else panel1.add(swordmanPicture);
        
        panel1.add(name);
        panel1.add(job);
        panel1.add(Hp);
        panel1.add(level);
        panel1.add(exp);
        panel1.add(money);
        panel1.add(killCount);
        panel1.add(space1);
        panel1.add(select);
        comboPanel.add(comboBox);
        comboPanel.add(huntButton);
        panel1.add(comboPanel);
        
        
        //Panel2 => Job + Bag
        //panel2.add(buyJob);
        
        //jobPanel.add(swordmanButton);
        //jobPanel.add(merchantButton);
        //panel2.add(jobPanel);
        panel2.add(space2);
        panel2.add(buyMaxPotionButton);
        panel2.add(space3);
        panel2.add(bagButton);

        bagButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (novice.bag.checkFullBag() > 0) {
                    for(int i=0; i < novice.bag.items.size(); i++){
                        itemLabels.add(new JLabel(novice.bag.items.get(i).getName()));
                        panel2.add(itemLabels.get(i));
                        itemLabels.get(i).setText(Integer.toString(i+1) + ". " + novice.bag.items.get(i).getName());
                    }
                    panel2.add(space4);
                    panel2.add(useMaxPotionButton);
                }else {
                    JOptionPane.showMessageDialog(null, "Bag is Empty");
                }
                
            }    
        });

        useMaxPotionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (novice.bag.checkFullBag() > 0) {

                    novice.healFullLife(0);
                    Hp.setText("HP: " + String.valueOf(novice.getHp()) + "/" + String.valueOf(novice.getMaxHp()));
                    novice.bag.useItem(novice.bag.checkFullBag());
                    itemLabels.get(novice.bag.checkFullBag()).setText("");
                }else {
                    JOptionPane.showMessageDialog(null, "Bag is Empty");
                }

            }
        });


        buyMaxPotionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if ( novice.getMoney() >= 10 && novice.bag.items.size() < 5 ) {
                    novice.bag.putMaxPotionInBag();
                    novice.useMoney(10);
                    money.setText("Money: " + String.valueOf(novice.getMoney()));
                    
                    //itemLabels.get(novice.bag.items.size()-1).setText(Integer.toString(novice.bag.items.size()) + ". " + novice.bag.items.get(novice.bag.items.size()-1).getName());
                }else {
                    if (novice.getMoney() < 10)
                        JOptionPane.showMessageDialog(null, "Not Enough Money!");
                    else
                        JOptionPane.showMessageDialog(null, "Bag is Full!");
                }

            }
        });

        huntButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Slime (Easy)") {
                    Monster monster = new Monster("Monster");
                    monster = new Slime(monster);
                    new Hunt(novice, monster);
                    dispose();
                }
                else if (comboBox.getSelectedItem() == "Org (Hard)") {
                    Monster monster = new Monster("Monster");
                    monster = new Org(monster);
                    new Hunt(novice, monster);
                    dispose();
                }
                else if (comboBox.getSelectedItem() == "Goblin (Medium)") {
                    Monster monster = new Monster("Monster");
                    monster = new Goblin(monster);
                    new Hunt(novice, monster);
                    dispose();
                }
                
			}
        });

        setSize(500, 420);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}