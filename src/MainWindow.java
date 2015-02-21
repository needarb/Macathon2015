import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by needa_000 on 2/5/2015.
 */
public class MainWindow extends JFrame
{
    public static void main(String[] args)
    {
        HashMap<String, Color> colorMap = loadColors("res/colors.pref");
        for(String s: colorMap.keySet())
        {
            System.out.println(colorMap.get(s));
        }
    }

    public MainWindow()
    {
        super();
        setTitle("Ned was here");
        add(new JButton("I AM A BUTTON"));
        add(new JLabel("Fuck Scott Walker"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static HashMap<String, Color> loadColors(String fileName)
    {
        HashMap<String, Color> colorMap = new HashMap<String, Color>();
        colorMap.put("DEFAULT", new Color(0xF2C23D));
        Scanner scanner;
        try
        {
             scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.err.println("Unable to load color preference file");
            return colorMap;
        }
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line);
            int split = line.indexOf(':');
            String name = line.substring(0,split).replace(" ","");
            String colorCode = line.substring(split+1).replace(" ","");
            colorMap.put(name, new Color(Integer.decode(colorCode)));
        }
        return colorMap;
    }
}
