package domain;

/**
 * Created by Pasha on 03.04.2017.
 */
public abstract class Type {
    private String name;

    public Type(String name) {
        this.name = name;
    }

    public abstract void setValue(String value);

    public abstract String getValue();

    public String getName() {
        return name;
    }

    public String toString(){
        return getValue();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();

    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
