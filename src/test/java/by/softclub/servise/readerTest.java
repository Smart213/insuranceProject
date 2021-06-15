package by.softclub.servise;



import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readerTest {

    @Test
    public void readerTest() {
        String t = "ssaAhhahh";
        Matcher m = Pattern.compile("A.?+a").matcher(t);
        while (m.find()){
            System.out.println(t.substring(m.start(), m.end()));
        }
    }
}
