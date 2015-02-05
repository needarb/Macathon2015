import javax.swing.*;

/**
 * Created by needa_000 on 2/5/2015.
 */
public class MainWindow extends JFrame
{

    public static void main(String[] args)
    {
        MainWindow main = new MainWindow();
    }

    public MainWindow()
    {
        super();
        setTitle("Ned was here");
        add(new JButton("I AM A BUTTON"));
        add(new JLabel("Twins = worst bird"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
