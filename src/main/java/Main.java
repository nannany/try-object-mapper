import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Sex;
import record.Human;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper normalObjectMapper = new ObjectMapper();

        var expected = new Human("翔平", "大谷", Sex.MALE);
        assertThat(normalObjectMapper.readValue(new File("src/main/resources/man.json"), Human.class))
                .isEqualTo(expected);
        System.out.println(expected);



    }
}
