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
    
    public void searchByTitle(String title) {
        hwlist.stream()
                .filter(h -> h.getTitle().toLowerCase().contains(title.toLowerCase()))
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
