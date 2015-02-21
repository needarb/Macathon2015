import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Created by needa_000 on 2/20/2015.
 */
public class TestPane extends JPanel implements AdjustmentListener, Scrollable
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("This is a test");
        frame.add(new TestPane());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public TestPane()
    {
        setLayout(new BorderLayout());
        JScrollBar scrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        scrollBar.addAdjustmentListener(this);
        add(scrollBar, BorderLayout.SOUTH);
        JPanel middlePanel = new JPanel();
        for (int i = 0; i < 4; i++)
        {
            middlePanel.add(new JButton("Option " + i));
        }
        add(middlePanel, BorderLayout.CENTER);

    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        System.out.println(e.getValue());
    }

    @Override
    public Dimension getPreferredScrollableViewportSize()
    {
        return new Dimension(50,50);
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth()
    {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight()
    {
        return false;
    }
}
