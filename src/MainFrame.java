import javax.swing.*;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class MainFrame extends JFrame
{
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
    }

    public MainFrame()
    {
        HomePagePanel homepage = new HomePagePanel();
        add(homepage);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
