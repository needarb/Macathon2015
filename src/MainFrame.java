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
        this.setResizable(true);
        HomePagePanel homePagePanel = new HomePagePanel();
        add(homePagePanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        this.mainPanel = homePagePanel;
        homePagePanel.jButton1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        this.setVisible(false);
        this.remove(this.mainPanel);
        this.setLayout(new BorderLayout());
        this.add(new TopPanel(0), BorderLayout.NORTH);
        this.add(new DataEntryPanel("Residential", new ResidentialEntryForm()));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
