import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class InterestEntryForm extends DataEntryForm
{
    private static final String INTEREST_DEFAULT = "Enter an interest";


    private JTextField interestField;

    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        main.add(new DataEntryPanel("Interests",new InterestEntryForm()));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.pack();
        main.setVisible(true);
    }

    public InterestEntryForm()
    {
        super();
        addFocusListener(this);
        initComponents();
    }

    private void initComponents()
    {
        interestField = new JTextField();
        interestField.addActionListener(this);
        interestField.addFocusListener(this);
        interestField.setPreferredSize(new Dimension(150,20));

        resetForm();
        add(interestField);
    }

    @Override
    public String convertToString()
    {
        return interestField.getText();
    }

    @Override
    public void resetForm()
    {
        interestField.setText(INTEREST_DEFAULT);
        interestField.requestFocusInWindow();
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == this)
        interestField.requestFocusInWindow();
        if(e.getSource() == interestField)
            if(interestField.getText().equals(INTEREST_DEFAULT))
                interestField.selectAll();
    }

    @Override
    public void focusLost(FocusEvent e)
    {

    }
}
