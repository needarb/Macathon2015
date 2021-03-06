import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by needa_000 on 2/20/2015.
 */
public class DataEntryNavigationBar extends JPanel implements MouseListener
{
    public static final String[] MENU_OPTIONS = {"Major","Residential","Classes","Orgs","Interests"};
    public static final Color FINISHED = new Color(255, 218, 204,200);
    public static final Color CURRENT = new Color(32, 31, 255,200);
    public static final Color TODO = new Color(43, 44, 39,200);
    private int active;
    private DataEntryFrame entryFrame;
    public DataEntryNavigationBar(int active, DataEntryFrame entryFrame)
    {
        setPreferredSize(new Dimension(450, 40));
        System.out.println("DataEntryNavigationBar created");
        this.active = active;
        this.entryFrame = entryFrame;
        addMouseListener(this);
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        System.out.println("Painted " + getWidth() + " " + getHeight());
        int width = getWidth();
        int height = getHeight();
        BufferedImage b = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D bg2 = (Graphics2D)b.getGraphics();
        bg2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        bg2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        for (int i = 0; i < MENU_OPTIONS.length; i++)
        {
            if(i < active)
                bg2.setColor(FINISHED);
            else if(i == active)
                bg2.setColor(CURRENT);
            else
                bg2.setColor(TODO);
            bg2.fillRect(i * (int)Math.ceil(width / 5.0), 0, (int)Math.ceil(width / 5.0),height);

            bg2.setColor(Color.BLACK);
            bg2.drawRect(i * (int) Math.ceil(width / 5.0), 0, (int) Math.ceil(width / 5.0) - 1, height - 1);

            int stringLen = (int)bg2.getFontMetrics().getStringBounds(MENU_OPTIONS[i], bg2).getWidth();
            int start = width/5/2 - stringLen/2;
            bg2.drawString(MENU_OPTIONS[i], start + i*(width/5), height/2 + 10);
            //bg2.drawString(MENU_OPTIONS[i],i*width/5+ 10,height/2);

        }
        g.drawImage(b,0,0,null);
    }


    public void setSelected(int id)
    {
        if(id >= MENU_OPTIONS.length)
            return;
        else
            active = id;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        int sectionClickedOn = e.getX()/(getWidth()/MENU_OPTIONS.length);
        entryFrame.goToEntryForm(sectionClickedOn);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
