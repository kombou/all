package component.validators;

import java.util.Map;

public interface IValidator<T> {
    Map<String,String> getErrors();

    void validate(T obj);

    boolean isValid();

    void addErrors(String name, String message);
}
