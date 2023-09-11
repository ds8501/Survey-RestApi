package SpringBootApi.RestApi;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class jsonAssert {
    @Test
    void jsonAssert_learnBasic() throws JSONException {
        String expected= """
             {"id":"Question1","description":"Most Popular Cloud Platform Today",
             "option":["AWS","Azure","Google Cloud","Oracle Cloud"],
             "correctAnswer":"AWS"} 
             """;
        String actualREsponse= """
               {"id":"Question1","description":"Most Popular Cloud Platform Today",
             "option":["AWS","Azure","Google Cloud","Oracle Cloud"],
             "correctAnswer":"AWS"} 
             """;
        JSONAssert.assertEquals(expected,actualREsponse,true);
    }

}
