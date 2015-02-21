import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * Created by needa_000 on 2/21/2015.
 */
public abstract class DataEntryForm extends JPanel implements ActionListener,FocusListener
{
    private LinkedList<EnterListener> enterListeners;
    public DataEntryForm()
    {
        enterListeners = new LinkedList<>();
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
}
