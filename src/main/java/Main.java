import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import enums.Sex;
import records.Human;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper normalObjectMapper = new ObjectMapper();
        ObjectMapper disableFailOnUnknownPropertiesObjectMapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        var expected = new Human("翔平", "大谷", Sex.MALE);
        assertThat(normalObjectMapper.readValue(new File("src/main/resources/man.json"), Human.class))
                .isEqualTo(expected);

        // 余計なkey-valueが入っている
        // 特別な設定をしていないObjectMapper
        assertThatThrownBy(() -> normalObjectMapper.readValue(new File("src/main/resources/has-unknown.json"), Human.class))
                .isExactlyInstanceOf(UnrecognizedPropertyException.class);

        // 余計なkey-valueが入っている
        assertThat(disableFailOnUnknownPropertiesObjectMapper.readValue(new File("src/main/resources/has-unknown.json"), Human.class))
                .isEqualTo(expected);

   }
}
