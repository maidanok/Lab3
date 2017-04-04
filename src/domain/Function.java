package domain;

import domain.enumerations.FunctionType;

/**
 * Created by Admin on 03.04.2017.
 */
public class Function extends Type {
    private FunctionType functionType;
    public Function() {
        super("Группа комплектующих");
    }

    @Override
    public void setValue(String value) {
        functionType=FunctionType.valueOf(value);
    }

    @Override
    public String getValue() {
        return functionType.toString();
    }
}
