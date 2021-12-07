package hardwaremanager.logics;

import java.util.ArrayList;

public class Manager {
    
    private ArrayList<Hardware> hwlist;
    
    public Manager() {
        this.hwlist = new ArrayList<>();
    }
    
    public void addHardware(Hardware hardware) {
        this.hwlist.add(hardware);
    }
    
    public void listHardware() {
        hwlist.stream().forEach(System.out::println);
    }        
    
    public void searchByName(String name) {
        hwlist.stream()
                .filter(h -> h.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(System.out::println);
    }
    
    public void searchByType(String type) {
        hwlist.stream()
                .filter(h -> h.getType().toLowerCase().contains(type.toLowerCase()))
                .forEach(System.out::println);
    }
    
    public void searchByLocation(String location) {
        hwlist.stream()
                .filter(h -> h.getLocation().toLowerCase().contains(location.toLowerCase()))
                .forEach(System.out::println);
    }       
    
}
