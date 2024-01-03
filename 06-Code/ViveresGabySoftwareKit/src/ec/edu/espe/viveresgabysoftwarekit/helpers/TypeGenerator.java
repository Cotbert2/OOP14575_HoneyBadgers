package ec.edu.espe.viveresgabysoftwarekit.helpers;

import java.lang.reflect.Type;

public class TypeGenerator {

    private final Type type;
    public TypeGenerator(Class<?> type){
        this.type = type;
    }

    public Type getRawType(){
        return type;
    }

}
