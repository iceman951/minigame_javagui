import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ChooseJob extends JFrame {
    public static void main( String[] args ) {
        new ChooseJob();
}
    public ChooseJob() {
        super("ChooseJob");

        Novice novice = new Novice("Enter Name");
        Container c = getContentPane();
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


        JRadioButton swordman,merchant;
        JLabel swordmanPicture = new JLabel(new ImageIcon("Swordman.png"));
        JLabel merchantPicture = new JLabel(new ImageIcon("Merchant.png"));
        JLabel novicetPicture = new JLabel(new ImageIcon("novice.png"));
        JLabel welcome = new JLabel("       Welcome");
        JLabel choose = new JLabel("        [Novice]");

        swordman = new JRadioButton( "[Swordman]");
        panel1.add(swordman);
        merchant = new JRadioButton( "[Merchant]");
        panel0.add(merchant);

        swordman.setSelected(true);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add( swordman );
        radioGroup.add( merchant );
        
        swordman.setActionCommand("swordman");
        merchant.setActionCommand("merchant");

        JButton okButton = new JButton("Choose Job");
        panel0.add(merchantPicture);
        panel1.add(swordmanPicture);
        
        panel2.add(welcome);
        panel2.add(choose);
        panel2.add(novicetPicture);
        panel2.add(okButton);
        c.add(panel0);
        c.add(panel1);
        c.add(panel2);

        

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (radioGroup.getSelection().getActionCommand().equals("swordman")){
                    MyGame game = new MyGame(new Swordman(novice));
                    dispose();
                }
                else if (radioGroup.getSelection().getActionCommand().equals("merchant")){
                    MyGame game = new MyGame(new Merchant(novice));
                    dispose();
                }
            }
        });

        setSize(370, 260);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}