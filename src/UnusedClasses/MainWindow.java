//package UnusedClasses;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.Scanner;
//
///**
// * Created by needa_000 on 2/5/2015.
// */
//public class MainWindow extends JFrame
//{
//    public static void main(String[] args) throws FileNotFoundException
//    {
//        MainWindow window = new MainWindow();
//        DialoguePanel dialoguePanel = new DialoguePanel();
//        window.add(dialoguePanel);
//        window.pack();
//    }
//
//    public MainWindow()
//    {
//        super();
//        setTitle("Speakeasy");
//        setVisible(true);
//    }
//
//    public static HashMap<String, Color> loadColors(String fileName)
//    {
//        HashMap<String, Color> colorMap = new HashMap<String, Color>();
//        colorMap.put("DEFAULT", new Color(0xF2C23D));
//        Scanner scanner;
//        try
//        {
//             scanner = new Scanner(new File(fileName));
//        } catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//            System.err.println("Unable to load color preference file");
//            return colorMap;
//        }
//        while(scanner.hasNextLine())
//        {
//            String line = scanner.nextLine();
//            System.out.println(line);
//            int split = line.indexOf(':');
//            String name = line.substring(0,split).replace(" ","");
//            String colorCode = line.substring(split+1).replace(" ","");
//            colorMap.put(name, new Color(Integer.decode(colorCode)));
//        }
//        return colorMap;
//    }
//}
