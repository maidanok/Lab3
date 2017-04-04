package domain;

import domain.enumerations.PortType;

/**
 * Created by Admin on 03.04.2017.
 */
public class Port extends Type {
    private PortType portType;

    public Port() {
        super("Используемый тип порта");
    }

    @Override
    public void setValue(String value) {
        portType = PortType.valueOf(value);

    }

    @Override
    public String getValue() {
        return portType.toString();
    }
}
