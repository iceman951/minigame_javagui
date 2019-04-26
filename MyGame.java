import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGame extends JFrame {

    Home homePage;

    public MyGame(Novice novice) {

        super("MyGame");
        
        GridBagLayout setNamePage = new GridBagLayout();
        setLayout(setNamePage);

        JLabel setName = new JLabel("Enter Your Name : ");
        GridBagConstraints gbc_setName = new GridBagConstraints();
        gbc_setName.gridx = 0;
		gbc_setName.gridy = 0;
        getContentPane().add(setName, gbc_setName);

        JTextField nameField = new JTextField();
        GridBagConstraints gbc_nameField = new GridBagConstraints();
        nameField.setColumns(10);
        gbc_setName.gridx = 1;
		gbc_setName.gridy = 0;
		getContentPane().add(nameField, gbc_nameField);

        JButton okButton = new JButton("     OK     ");
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.gridx = 2;
		gbc_okButton.gridy = 0;
        getContentPane().add(okButton, gbc_okButton);

        JButton cancelButton = new JButton(" Cancel ");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridx = 2;
		gbc_cancelButton.gridy = 1;
        getContentPane().add(cancelButton, gbc_cancelButton);
        cancelButton.setVisible(false);
        
        JLabel yourName = new JLabel("           Your Name : ");
        GridBagConstraints gbc_yourName = new GridBagConstraints();
        gbc_yourName.gridx = 0;
        gbc_yourName.gridy = 1;
        getContentPane().add(yourName, gbc_yourName);

        JLabel showName = new JLabel();
        GridBagConstraints gbc_showName = new GridBagConstraints();
        gbc_showName.gridx = 1;
        gbc_showName.gridy = 1;
        getContentPane().add(showName, gbc_showName);

        JButton playButton = new JButton("Let's Play");
        GridBagConstraints gbc_playButton = new GridBagConstraints();
        gbc_playButton.gridx = 1;
        gbc_playButton.gridy = 2;
        getContentPane().add(playButton, gbc_playButton);
        playButton.setVisible(false);

        JLabel buyJob = new JLabel(" ");
        GridBagConstraints gbc_buyJob = new GridBagConstraints();
        gbc_playButton.gridx = 2;
        gbc_playButton.gridy = 0;
        getContentPane().add(buyJob, gbc_buyJob);
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                novice.setName(nameField.getText());
                showName.setText(novice.getName());
            
                playButton.setVisible(true);
                okButton.setVisible(false);
                cancelButton.setVisible(true);
			}
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButton.setVisible(true);
                cancelButton.setVisible(false);
            }
        });

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home(novice);
                dispose();
			}
        });

        setSize(350, 155);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}