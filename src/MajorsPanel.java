import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by needa_000 on 2/20/2015.
 */
public class MajorsPanel extends JPanel implements ActionListener, FocusListener
{
    private static final String DEFAULT_TEXT = "Enter a major";

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.add(new MajorsPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public MajorsPanel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Majors"));
        addTextField();
    }

    private void addTextField()
    {
        JTextField enterField = new JTextField("Enter a major");
        enterField.addActionListener(this);
        enterField.addFocusListener(this);
        add(enterField);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Action Performed");
        if(!(e.getSource() instanceof JTextField))
            return;
        JTextField enterField = (JTextField) e.getSource();
        String text = enterField.getText();
        remove(enterField);
        add(new JLabel(text));
        enterField.setText("Enter a major");
        add(enterField);
        enterField.requestFocusInWindow();
        enterField.selectAll();
        updateUI();
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() instanceof JTextField)
        {
            JTextField textField = (JTextField)e.getSource();
            if(textField.getText().equals(DEFAULT_TEXT))
                textField.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {

    }
}
