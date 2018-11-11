package component.validators;

import java.util.HashMap;
import java.util.Map;

public abstract class Validator<T> implements IValidator<T>{

    Map<String, String> errors = new HashMap<>();

    @Override
    public Map<String, String> getErrors() {
        return errors;
    }

    @Override
    public boolean isValid() {
        return errors.isEmpty();
    }

    @Override
    public void addErrors(String name, String message) {
        errors.put(name,message);
    }
}
