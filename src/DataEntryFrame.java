import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class DataEntryFrame extends JFrame implements ContainerListener, ActionListener
{
    private DataEntryNavigationBar dataEntryNavigationBar;

    private DataEntryPanel[] entryPanels;
    private  DataEntryPanel currentPanel;
    private int currentID;

    private JButton nextButton;
    private JButton previousButton;
    public DataEntryFrame()
    {
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());

        createTopPanel();
        createPanels();
        createButtons();

        setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void createTopPanel()
    {
        dataEntryNavigationBar = new DataEntryNavigationBar(0,this);
        add(dataEntryNavigationBar,BorderLayout.NORTH);
    }

    private void createPanels()
    {
        entryPanels = new DataEntryPanel[5];
        entryPanels[0] = new DataEntryPanel("Major",new MajorEntryForm());
        entryPanels[1] = new DataEntryPanel("Residential",new ResidentialEntryForm());
        entryPanels[2] = new DataEntryPanel("Classes",new ClassEntryForm());
        entryPanels[3] = new DataEntryPanel("Orgs",new OrgEntryForm());
        entryPanels[4] = new DataEntryPanel("Interests",new InterestEntryForm());
        for(DataEntryPanel ep: entryPanels)
            ep.addContainerListener(this);
        currentPanel = entryPanels[0];
        add(currentPanel);
    }

    private void createButtons()
    {
        nextButton = new JButton("Next Section");
        previousButton = new JButton("Previous Section");
        previousButton.setEnabled(false);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.setBackground(Color.WHITE);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void goToEntryForm(int id)
    {
        currentID = id;
        remove(currentPanel);
        currentPanel = entryPanels[id];
        add(currentPanel);
        dataEntryNavigationBar.setSelected(id);

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

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                pack();
            }
        });
        repaint();
    }

    @Override
    public void componentAdded(ContainerEvent e)
    {
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
            goToEntryForm(currentID - 1);
    }

    public void finish()
    {
        this.dispose();
        String[] args = {};
        ItemPageFrame.main(args);

    }
}
