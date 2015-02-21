import javax.swing.*;
import java.awt.*;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class DataEntryFrame extends JFrame
{
    public static void main(String[] args)
    {
        DataEntryFrame frame = new DataEntryFrame();
    }
    public DataEntryFrame()
    {
        super();

        setLayout(new BorderLayout());
        add(new TopPanel(0),BorderLayout.NORTH);
        add(new DataEntryPanel("Residential",new ResidentialEntryForm()));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
