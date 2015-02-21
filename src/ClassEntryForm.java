import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class ClassEntryForm extends DataEntryForm
{
    private static final String CLASS_DEFAULT = "Enter a class";

    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        main.add(new DataEntryPanel("Classes",new ClassEntryForm()));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.pack();
        main.setVisible(true);
    }

    private JComboBox<String> semesterBox;
    private JSpinner yearSpinner;
    private JTextField classField;

    public ClassEntryForm()
    {
        super();
        semesterBox = new JComboBox<String>();
        semesterBox.addItem("Spring");
        semesterBox.addItem("Fall");

        yearSpinner = new JSpinner();
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(yearSpinner);
        editor.getFormat().setGroupingUsed(false);
        yearSpinner.setEditor(editor);

        classField = new JTextField();
        classField.addActionListener(this);
        classField.addFocusListener(this);
        classField.setPreferredSize(new Dimension(150,20));

        resetForm();
        add(semesterBox);
        add(yearSpinner);
        add(classField);
    }
    @Override
    public String convertToString()
    {
        return semesterBox.getSelectedItem() + " " + yearSpinner.getValue() + " " + classField.getText();
    }

    @Override
    public void resetForm()
    {
        yearSpinner.setValue(2015);
        classField.setText(CLASS_DEFAULT);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == classField)
        {
            if(classField.getText().equals(CLASS_DEFAULT))
                classField.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {

    }
}
