import javax.swing.*;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class DataEntryPanel extends JPanel implements EnterListener
{
    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        main.add(new DataEntryPanel("Majors",new MajorEntryForm()));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.pack();
        main.setVisible(true);
    }
    private DataEntryForm entryForm;

    public DataEntryPanel(String title, DataEntryForm entryForm)
    {
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.entryForm = entryForm;
        entryForm.addEnterListener(this);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel(title));
        add(entryForm);
    }

    @Override
    public void onFormEnter(DataEntryForm dataForm)
    {
        String text = dataForm.convertToString();
        remove(dataForm);
        add(new JLabel(text));
        dataForm.resetForm();
        add(dataForm);
        dataForm.requestFocusInWindow();
        updateUI();
    }


}
