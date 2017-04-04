package сomparator;

import domain.Device;

import java.util.Comparator;

/**
 * Created by Admin on 04.04.2017.
 */
public class SortByPrice implements Comparator <Device> {

    @Override
    public int compare(Device device1, Device device2) {
        return device1.getPrice().compareTo(device2.getPrice());
    }
}
