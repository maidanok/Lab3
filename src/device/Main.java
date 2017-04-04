package device;

import domain.Device;
import xml.DeviceXmlReader;
import xml.DeviceXmlValidator;
import сomparator.SortByPrice;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        DeviceXmlValidator validator = new DeviceXmlValidator("devices.xml");
        if (validator.validate()) {
            DeviceXmlReader reader = new DeviceXmlReader();
            List<Device> devices = reader.read("devices.xml");
            devices.sort(new SortByPrice());
            for (Device device : devices) {
                System.out.println(device);
            }
        } else {
            System.out.println(validator.getError());
        }
    }
}
