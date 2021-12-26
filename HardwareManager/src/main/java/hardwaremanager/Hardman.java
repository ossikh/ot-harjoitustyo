package hardwaremanager;

import hardwaremanager.ui.Userinterface;
import java.util.Scanner;

/**
 * ICT Hardware Manager ohjelmiston käynnistävä pääluokka
 */
public class Hardman {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Userinterface userinterface = new Userinterface(reader);
        if (args.length > 0) {
            userinterface.uiAutoloadHardwarelist(args[0].toString());
        }
        userinterface.start();
    }
}
