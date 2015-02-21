import javax.swing.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by needa_000 on 2/21/2015.
 */
public class ResidentalEntryForm extends DataEntryForm
{
    private static final String BUILDING_DEFAULT = "Enter a building";

    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        main.add(new DataEntryPanel("Residential",new ResidentalEntryForm()));
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.pack();
        main.setVisible(true);
    }
    private JComboBox<String> semesterBox;
    private JTextField buildingField;
    private JSpinner floorSpinner;
    private JSpinner yearSpinner;

    public ResidentalEntryForm()
    {
        super();
        semesterBox = new JComboBox<String>();
        semesterBox.addItem("Spring");
        semesterBox.addItem("Fall");
        floorSpinner = new JSpinner();
        yearSpinner = new JSpinner();

        buildingField = new JTextField(BUILDING_DEFAULT);
        resetForm();
        add(semesterBox);
        add(yearSpinner);
        add(floorSpinner);
        add(buildingField);
        buildingField.addActionListener(this);

    }
    @Override
    public String convertToString()
    {
        return semesterBox.getSelectedItem() + " " + yearSpinner.getValue() + " " + floorSpinner.getValue() + " " + buildingField.getText();
    }

    @Override
    public void resetForm()
    {
        semesterBox.setSelectedIndex(0);
        yearSpinner.setValue(2015);
        floorSpinner.setValue(0);
        buildingField.setText(BUILDING_DEFAULT);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        semesterBox.requestFocusInWindow();
    }

    @Override
    public void focusLost(FocusEvent e)
    {

    }
}
