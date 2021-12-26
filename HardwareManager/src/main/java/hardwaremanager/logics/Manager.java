package hardwaremanager.logics;

import java.util.ArrayList;

/**
 * Ohjelmiston päätoiminnallisuuden ja komponenttikirjanpidon tarjoava luokka
 */
public class Manager {

    private ArrayList<Hardware> hwlist;
    private Fileoperator fileoperator;

    public Manager() {
        this.hwlist = new ArrayList<>();
        this.fileoperator = new Fileoperator();
    }

    /**
     * Lisää komponenttikirjanpitoon komponentin
     *
     * @param hardware lisättävä komponentti
     */
    public void addHardware(Hardware hardware) {
        this.hwlist.add(hardware);
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

    /**
     * Listaa komponentit, näyttää jokaisen komponentin edessä sen
     * järjestysnumeron
     */
    public void listHardware() {
        int i = 1;
        for (Hardware h : hwlist) {
            System.out.println(i + ". " + h.toString());
            i++;
        }
    }

    /**
     * Poistaa komponentin
     *
     * @param number poistaa annetun järjestysnumeron mukaisen komponentin,
     * jäjestysnumero vastaa listausmetodin näyttämää numeroa
     *
     * @return palauttaa true jos komponentti on poistettu, muuten false
     */
    public boolean removeHardware(int number) {
        if (hwlistNotEmpty() && number > 0 && number <= hwlist.size()) {
            hwlist.remove(number - 1);
            return true;
        }
        return false;
    }

    /**
     * Palauttaa listalta komponentin
     *
     * @param number numero jonka mukainen komponentti halutaan palauttaa
     * listalta
     * @return palauttaa komponentin jos se löytyy, muuten false
     */
    public Hardware getHardware(int number) {
        if (hwlistNotEmpty() && number > 0 && number <= hwlist.size()) {
            return hwlist.get(number - 1);
        }
        return null;
    }

    /**
     * Tarkistaa onko järjestelmässä komponentteja
     *
     * @return palauttaa true jos komponentteja on listassa, false jos lista on
     * tyhjä
     */
    public boolean hwlistNotEmpty() {
        return !hwlist.isEmpty();
    }

    public void saveHardwarelist(String filename) {
        fileoperator.saveList(filename, hwlist);
    }

    public void loadHardwarelist(String filename) {
        ArrayList loadlist = fileoperator.loadList(filename);
        if (loadlist != null && loadlist.size() > 0) {
            this.hwlist = loadlist;
        }
    }
}
