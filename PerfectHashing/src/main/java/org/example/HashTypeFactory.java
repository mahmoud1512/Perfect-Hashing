package org.example;

public class HashTypeFactory {
    public Hash<?> factory(String type){
        return switch (type) {
//            case "Long" -> new LongHash();
            case "Integer" -> new IntegerHash<>(32);
//            case "Double" -> new DoubleHash();
//            case "Float" -> new FloatHash();
//            case "String" -> new StringHash();
            default -> null;
        };
    }
}
