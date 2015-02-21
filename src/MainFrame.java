import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Benjamin Mathers on 2/21/2015.
 */
public class MainFrame extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
    }

    JPanel mainPanel;

    public MainFrame()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        HomePagePanel homePagePanel = new HomePagePanel();
        homePagePanel.jButton1.addActionListener(this);
        this.mainPanel = new HomePagePanel();
        add(homePagePanel);

        this.setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
       this.dispose();
       DataEntryFrame entryFrame = new DataEntryFrame();

    }
}
