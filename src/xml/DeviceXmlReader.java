package xml;

import domain.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 03.04.2017.
 */
public class DeviceXmlReader {
    public List<Device> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Device> devices = new ArrayList<Device>();
            Device device = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("device".equals(tagName)) {
                            device = new Device();
                            device.setIdentity(reader.getAttributeValue(null, "id"));
                        } else if ("name".equals(tagName)) {
                            device.setName(reader.getElementText());
                        } else if ("origin".equals(tagName)) {
                            device.setOrigin(reader.getElementText());
                        } else if ("price".equals(tagName)) {
                            device.setPrice(Integer.parseInt(reader.getElementText()));
                        } else if ("iscritical".equals(tagName)) {
                            device.setCritical(Boolean.parseBoolean(reader.getElementText()));
                        } else if ("port".equals(tagName)) {
                            Port port = new Port();
                            port.setValue(reader.getElementText());
                            device.getTypeDevice().add(port);//получаем ссылку на коллекцию и заносим в нее элемент
                        } else if ("function_type".equals(tagName)) {
                            Function function = new Function();
                            function.setValue(reader.getElementText());
                            device.getTypeDevice().add(function);
                        } else if ("power".equals(tagName)) {
                            Power power = new Power();
                            power.setValue(reader.getElementText());
                            device.getTypeDevice().add(power);
                        } else if ("cooler".equals(tagName)) {
                            Cooler cooler = new Cooler();
                            cooler.setValue(reader.getElementText());
                            device.getTypeDevice().add(cooler);
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("device".equals(tagName)) {
                            devices.add(device);
                        }
                        break;
                    }

                }
            }
            return devices;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}
