import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * Created by needa_000 on 2/21/2015.
 */
public abstract class DataEntryForm extends JPanel implements ActionListener,FocusListener
{
    private LinkedList<EnterListener> enterListeners;
    private JPanel componentPanel;
    private JButton enterButton;
    public DataEntryForm()
    {
        enterListeners = new LinkedList<>();
        componentPanel = new JPanel();
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        super.add(componentPanel);
        super.add(enterButton);

    }
    public abstract String convertToString();
    public abstract void resetForm();


    public void addEnterListener(EnterListener el)
    {
        enterListeners.add(el);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(EnterListener el: enterListeners)
            el.onFormEnter(this);

    }

    @Override
    public Component add(Component comp)
    {
        System.out.println("Added something");
        componentPanel.add(comp);
        return comp;
    }
}
