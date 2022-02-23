import com.fasterxml.jackson.databind.ObjectMapper;
import record.Human;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper normalObjectMapper = new ObjectMapper();

        var otani = normalObjectMapper.readValue(new File("src/main/resources/man.json"), Human.class);
        System.out.println(otani);


    }
}
