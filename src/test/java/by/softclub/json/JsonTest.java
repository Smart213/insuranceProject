package by.softclub.json;

import by.softclub.entity.insuranceofstuff.CarInsurance;
import by.softclub.servise.factory.InsCarFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsonTest {

    @Test
    public void g() {

        ObjectMapper mapper = new ObjectMapper();
//        try {
//            System.out.println(mapper.writeValueAsString(new InsCarFactory().generate()));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        try {
            System.out.println(
            mapper.readValue(new File("john.json"), CarInsurance.class)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
