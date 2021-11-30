package hardwaremanager;

import hardwaremanager.ui.Userinterface;
import java.util.Scanner;

public class Hardman {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Userinterface userinterface = new Userinterface(reader);
        userinterface.start();

    }

}
