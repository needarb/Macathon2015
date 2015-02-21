import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class DataEntryFrame extends JFrame implements ContainerListener, ActionListener
{

    public static void main(String[] args)
    {
        DataEntryFrame frame = new DataEntryFrame();
    }
    private TopPanel topPanel;
    private int currentID;
    private DataEntryPanel[] entryPanels;
    private  DataEntryPanel currentPanel;
    private JButton nextButton;
    private JButton previousButton;
    public DataEntryFrame()
    {
        super();

        this.topPanel = new TopPanel(0,this);
        this.entryPanels = new DataEntryPanel[5];
        entryPanels[0] = new DataEntryPanel("Major",new MajorEntryForm());
        entryPanels[1] = new DataEntryPanel("Residential",new ResidentialEntryForm());
        entryPanels[2] = new DataEntryPanel("Classes",new ClassEntryForm());
        entryPanels[3] = new DataEntryPanel("Orgs",new OrgEntryForm());
        entryPanels[4] = new DataEntryPanel("Interests",new InterestEntryForm());
        for(DataEntryPanel ep: entryPanels)
            ep.addContainerListener(this);
        this.currentPanel = entryPanels[0];
        this.nextButton = new JButton("Next Section");
        this.previousButton = new JButton("Previous Section");
        previousButton.setEnabled(false);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(currentPanel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void goToEntryForm(int id)
    {
        currentID = id;
        remove(currentPanel);
        currentPanel = entryPanels[id];
        add(currentPanel);
        topPanel.setSelected(id);
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                pack();
            }
        });
        if(id == entryPanels.length - 1)
            nextButton.setText("Finish");
        else if (id == 0)
        {
            previousButton.setEnabled(false);
        }
        else
        {
            nextButton.setText("Next Section");
            previousButton.setEnabled(true);
        }

        repaint();
    }

    @Override
    public void componentAdded(ContainerEvent e)
    {
        System.out.println("Something added");
        pack();
    }

    @Override
    public void componentRemoved(ContainerEvent e)
    {
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == nextButton)
        {
            if(currentID == entryPanels.length-1)
                finish();
            else
                goToEntryForm(currentID + 1);

        }
        else if(e.getSource() == previousButton)
        {
            goToEntryForm(currentID - 1);
        }
    }

    public void finish()
    {

    }
}
