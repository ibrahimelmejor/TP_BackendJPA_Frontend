package test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

public class Home {

    private String name;
    private List<Heater> heaters = new ArrayList<Heater>();

    public String getName() {
        return name;
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public void addDevice(Heater heater)
    {
        this.heaters.add(heater);
    }
}
