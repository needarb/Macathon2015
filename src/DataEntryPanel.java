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
    private BufferedImage background;

    public DataEntryPanel(String title, DataEntryForm entryForm)
    {
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.background = DataLoader.loadImage("plaid.jpg");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.entryForm = entryForm;
        entryForm.addEnterListener(this);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,18));
        titlePanel.add(titleLabel);
        add(titlePanel);
        add(entryForm);
    }

    @Override
    public void onFormEnter(DataEntryForm dataForm)
    {
        String text = dataForm.convertToString();
        remove(dataForm);
        JPanel formDataPanel = new JPanel();
        JLabel formDataLabel = new JLabel(ITEMIZER + " " + text);
        formDataPanel.add(formDataLabel);
        formDataPanel.setBackground(new Color(0,0,0,0));
        add(formDataPanel);
        dataForm.resetForm();
        add(dataForm);
        dataForm.requestFocusInWindow();
        updateUI();
    }


}
