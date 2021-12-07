package hardwaremanager.ui;

import hardwaremanager.logics.Hardware;
import hardwaremanager.logics.Manager;
import java.util.Scanner;

public class Userinterface {

    private Scanner reader;
    private Manager manager;

    public Userinterface(Scanner reader) {

        this.reader = reader;
        manager = new Manager();
    }

    public void start() {

        System.out.println("-=[   Welcome to ICT Hardware Manager   ]=-");

        while (true) {
            System.out.println("Available actions > "
                    + "[1] List hardware | "
                    + "[2] Add hardware | "
                    + "[3] Search by title | "
                    + "[4] Search by type | "
                    + "[5] Search by location | "
                    + "[G] Create generic hardware list for testing purposes | "
                    + "[Q] Quit");
            System.out.print("Select action: ");
            String action = reader.nextLine();

            if (action.equals("1")) {
                System.out.println("Listing hardware:");
                System.out.println("");
                manager.listHardware();
                System.out.println("");
            }

            if (action.equals("2")) {
                System.out.print("Enter new hardware title: ");
                String title = reader.nextLine();
                System.out.print("Enter new hardware type: ");
                String type = reader.nextLine();
                System.out.print("Enter new hardware location: ");
                String location = reader.nextLine();

                manager.addHardware(new Hardware(title, type, location));
                System.out.println("Hardware added!");
            }
            
            if (action.equals("3")) {
                System.out.print("Enter title: ");
                String title = reader.nextLine();
                System.out.println("Displaying items containing title " + title + ": ");
                System.out.println("");
                manager.searchByTitle(title);
                System.out.println("");
            }
            
            if (action.equals("4")) {
                System.out.print("Enter type: ");
                String type = reader.nextLine();
                System.out.println("Displaying items containing type " + type + ": ");
                System.out.println("");
                manager.searchByType(type);
                System.out.println("");
            }
            
            if (action.equals("5")) {
                System.out.print("Enter location: ");
                String location = reader.nextLine();
                System.out.println("Displaying items on location containing " + location + ": ");
                System.out.println("");
                manager.searchByLocation(location);
                System.out.println("");
            }

            if (action.toLowerCase().equals("g")) {
                manager = crateGenericManager();
            }

            if (action.toLowerCase().equals("q")) {
                break;
            }

        }

    }

    public static Manager crateGenericManager() {
        Manager manager = new Manager();

        manager.addHardware(new Hardware("Asus TUF B550", "Motherboard", "Main machine"));
        manager.addHardware(new Hardware("Ryzen 7 3700x", "Processor", "Main machine"));
        manager.addHardware(new Hardware("Corsair LPX DDR4-3200, 32GB", "Memory", "Main machine"));
        manager.addHardware(new Hardware("MSI Geforce GTX 1070 8 GB", "GPU", "Main machine"));
        manager.addHardware(new Hardware("Samsung 970 Evo Plus 1 TB", "NVMe", "Main machine"));
        manager.addHardware(new Hardware("Noctua NH-D15S", "Cooler", "Main machine"));
        manager.addHardware(new Hardware("Fractal Design R5", "Case", "Main machine"));
        manager.addHardware(new Hardware("AOC 32 IPS", "Monitor", "Main desk"));
        manager.addHardware(new Hardware("Logitech MX Keys wireless", "Keyboard", "Main desk"));
        manager.addHardware(new Hardware("ASUS ROG Strix Carry wireless", "Mouse", "Main desk"));

        System.out.println("Generic hardware list created!");

        return manager;
    }

}
