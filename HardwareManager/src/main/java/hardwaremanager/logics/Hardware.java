package hardwaremanager.logics;

/**
 * Tietokonekomponenttia tai oheislaitetta kuvaava luokka
 */

public class Hardware {

    private String title;
    private String type;
    private String location;

    /**
     * Uuden komponentin lisääminen
     * 
     * @param title komponentin nimi
     * @param type komponentin tyyppi
     * @param location komponentin sijainti
     */  
    public Hardware(String title, String type, String location) {
        this.title = title;
        this.type = type;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return title + " - " + type + " @ " + location + ".";
    }

}
