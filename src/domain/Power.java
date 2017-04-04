package domain;

/**
 * Created by Admin on 03.04.2017.
 */
public class Power extends Type {
    private Integer power;

    public Power() {
        super("Мощьность");
    }

    @Override
    public void setValue(String value) {
        power=Integer.parseInt(value);

    }

    @Override
    public String getValue() {
        return power.toString();
    }
}
