import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class MajorEntryForm extends DataEntryForm
{
    public static final String DEFAULT_TEXT = "Enter a major";
    private JTextField textField;

    public MajorEntryForm()
    {
        super();
        addFocusListener(this);
        textField = new JTextField(DEFAULT_TEXT);
        textField.addActionListener(this);
        textField.addFocusListener(this);
        textField.setPreferredSize(new Dimension(150,20));
        add(textField);
    }
    @Override
    public String convertToString()
    {
        return textField.getText();
    }

    @Override
    public void resetForm()
    {
        textField.setText(DEFAULT_TEXT);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(textField.getText().equals(DEFAULT_TEXT))
        {
            textField.requestFocusInWindow();
            textField.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {

    }
}
