import javax.swing.*;
import java.awt.event.FocusEvent;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class OrgEntryForm extends DataEntryForm
{
    private static final String ORG_NAME_DEFAULT = "Enter an org";

    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        main.add(new DataEntryPanel("Orgs",new OrgEntryForm()));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.pack();
        main.setVisible(true);
    }

    private JTextField orgNameField;
    private JComboBox<String> orgSizeBox;

    public OrgEntryForm()
    {
        super();
        orgNameField = new JTextField();
        orgNameField.addActionListener(this);
        orgNameField.addFocusListener(this);
        orgSizeBox = new JComboBox<String>();
        orgSizeBox.addItem("Large");
        orgSizeBox.addItem("Small");
        resetForm();
        add(orgSizeBox);
        add(orgNameField);
    }
    @Override
    public String convertToString()
    {
        return orgSizeBox.getSelectedItem() + " " + orgNameField.getText();
    }

    @Override
    public void resetForm()
    {
        orgNameField.setText(ORG_NAME_DEFAULT);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == orgNameField)
            if(orgNameField.getText().equals(ORG_NAME_DEFAULT))
                orgNameField.selectAll();
    }

    @Override
    public void focusLost(FocusEvent e)
    {

    }
}
