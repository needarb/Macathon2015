import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class DataEntryPanel extends JPanel implements EnterListener
{
    private static final String ITEMIZER = "-";
    private DataEntryForm entryForm;
    private JPanel componentPanel;
    public DataEntryPanel(String title, DataEntryForm entryForm)
    {
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createTitlePanel(title);
        createEntryPanel(entryForm);
        makePanelWhite();
    }

    private void createTitlePanel(String title)
    {
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,18));
        titlePanel.add(titleLabel);
        add(titlePanel);

    }

    private void createEntryPanel(DataEntryForm entryForm)
    {
        this.entryForm = entryForm;
        entryForm.addEnterListener(this);
        add(entryForm);
    }



    private void makePanelWhite()
    {
        for(Component comp: this.getComponents())
            if(comp instanceof JPanel)
            {
                comp.setBackground(Color.WHITE);
                for(Component comp2: ((JPanel)comp).getComponents())
                    if(comp2 instanceof JPanel)
                        comp2.setBackground(Color.WHITE);
            }
    }


    @Override
    public void onFormEnter(DataEntryForm dataForm)
    {
        String text = dataForm.convertToString();
        remove(dataForm);

        JPanel formDataPanel = new JPanel();
        formDataPanel.setBackground(Color.WHITE);
        JLabel formDataLabel = new JLabel(ITEMIZER + " " + text);
        formDataPanel.add(formDataLabel);
        add(formDataPanel);

        dataForm.resetForm();
        add(dataForm);

        dataForm.requestFocusInWindow();
        updateUI();
    }


}
