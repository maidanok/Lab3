package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pasha on 03.04.2017.
 */
public class Device {
    private String identity;
    private String name;
    private String origin;
    private Integer price;
    private Boolean isCritical;
    private Set<Type> typeDevice=new HashSet<Type>();

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getCritical() {
        return isCritical;
    }

    public void setCritical(Boolean critical) {
        isCritical = critical;
    }

    public Set<Type> getTypeDevice() {
        return typeDevice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("ID: ").append(getIdentity()).append('\n');
        stringBuilder.append("Название комплектующего ").append(getName()).append('\n');
        stringBuilder.append("Страна производитель ").append(getOrigin()).append('\n');
        stringBuilder.append("Цена ").append(getPrice()).append('\n');
        stringBuilder.append("Критично ли наличие: ").append(getCritical() ? "критично":" не критично").append('\n');
        for (Type type: getTypeDevice()){
            stringBuilder.append(type.getName()).append(": ").append(type.getValue()).append('\n');
        }
        return stringBuilder.toString();
    }
}
