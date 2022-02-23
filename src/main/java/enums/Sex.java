package enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Sex {
    MALE("男"), FEMALE("女");

    String japanese;

    Sex(String japanese) {
        this.japanese = japanese;
    }

    @JsonValue
    String getJapanese() {
        return this.japanese;
    }

    static Map<String, Sex> correspondenceTable =
            Arrays.stream(Sex.values()).collect(Collectors.toMap(Sex::getJapanese, Function.identity()));

    @JsonCreator
    static Sex getSex(String japanese){
        return correspondenceTable.get(japanese);
    }
}
