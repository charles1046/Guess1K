import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    int number = (int)(Math.random()*1000 + 1);
    int guessCount;
    JLabel countTitle;
    JTextField field;
    JLabel guessMessage;

    Frame(){
        guessCount = 0;

        this.setSize(520,180);
        this.setLocation(700, 420);
        this.setLayout(new FlowLayout());
        this.setTitle("Guess number");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(520, 30));
        panel.setLayout(new FlowLayout());
        this.add(panel);

        JLabel title = new JLabel();
        title.setText("Guess a number between 1 and 1000");
        title.setFont(new Font("Consolas", Font.BOLD, 24));
        panel.add(title);

        field = new JTextField();
        field.setPreferredSize(new Dimension(280, 30));
        field.setFont(new Font("Consolas", Font.PLAIN, 20));
        field.addActionListener(e -> showResult(field.getText()));
        this.add(field);

        JButton button = new JButton();
        button.setText("Guess!");
        button.setFocusable(false);
        button.setFont(new Font("Consolas", Font.BOLD, 18));
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(e -> showResult(field.getText()));
        this.add(button);

        guessMessage = new JLabel();
        guessMessage.setText("Result will be showed here.");
        guessMessage.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(guessMessage);

        countTitle = new JLabel();
        countTitle.setText("You have guessed "+guessCount+" times.");
        countTitle.setFont(new Font("Consolas", Font.BOLD, 20));
        this.add(countTitle);

        this.setVisible(true);
    }

    private void showResult(String s){
        if (s.length() == 0){
            JOptionPane.showMessageDialog(this,
                    "You need to guess a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if (Integer.parseInt(s) == number){
                guessMessage.setText("Bingo! The answer is "+number+".");
                number = (int)(Math.random()*1000 + 1); // reset the number
                countTitle.setText("You guessed "+guessCount+" times.");
                guessCount = 0;
            } else if (Integer.parseInt(s) < number){
                guessMessage.setText("The answer is BIGGER than "+s+" !");
                guessCount++;
                countTitle.setText("You have guessed "+guessCount+" times");
            } else if (Integer.parseInt(s) > number){
                guessMessage.setText("The answer is SMALLER than "+s+" !");
                guessCount++;
                countTitle.setText("You have guessed "+guessCount+" times.");
            }
        }
        field.setText("");  //clear the text field
    }
}
