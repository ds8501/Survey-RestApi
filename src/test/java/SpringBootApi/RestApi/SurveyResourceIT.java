package SpringBootApi.RestApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

    String str= """
           {"id":"Question1","description":"Most Popular Cloud Platform Today",
           "option":["AWS","Azure","Google Cloud","Oracle Cloud"],
           "correctAnswer":"AWS"} 
            """;
    private static String specific_question_url="/service/Survey1/questions/Question1";
   @Autowired
   private TestRestTemplate template;
    @Test
   void retrieveSpecificQuestions_basicScenario(){
        ResponseEntity<String> responseEntity=template.getForEntity(specific_question_url,String.class);
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getHeaders());
    }

}
