package domain;

/**
 * Created by Pasha on 04.04.2017.
 */
public class Cooler extends Type {
    private boolean isCooler;

    public Cooler() {
        super("Наличие кулера");
    }

    @Override
    public void setValue(String value) {
        isCooler = Boolean.parseBoolean(value);

    }

    @Override
    public String getValue() {
        return (isCooler ? "есть": "нет");
    }
}
