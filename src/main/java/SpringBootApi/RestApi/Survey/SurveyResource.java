package SpringBootApi.RestApi.Survey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class SurveyResource {
    SurveyService surveyService;
    private Question question;
    private String surveyId;

    public SurveyResource(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
@RequestMapping("/service")
    public List<SurveyBean> retrieveAllSurveys(){
        return surveyService.retrieveAllSurveys();
    }

   @RequestMapping("/service/{surveyId}")
    public SurveyBean retrieveSurveysById(@PathVariable String surveyId){
        SurveyBean survey= surveyService.retrieveAllById(surveyId);
        if(survey==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return survey;
    }

    @RequestMapping("/service/{surveyId}/{questions}")
    public List<Question> retrieveSurveyQuestions(@PathVariable String surveyId){
        List<Question> questions= surveyService.retrieveSurveyQuestion(surveyId);

        if(questions==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return questions;
    }

    @RequestMapping("/service/{surveyId}/{questions}/{questionId}")
    public Question retrieveSpecificQuestions(@PathVariable String surveyId,@PathVariable String questionId){
        Question questions= surveyService.retrieveSpecificQuestion(surveyId,questionId);

        if(questions==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return questions;
    }

    @RequestMapping(value = "/service/{surveyId}/{questions}",method = RequestMethod.POST)
    public ResponseEntity<Objects> addNewSurveyQuestion(@PathVariable String surveyId,
                                                        @RequestBody  Question question){

        String questionId=surveyService.addNewSurveyQuestion(surveyId,question);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{questionId}").buildAndExpand(questionId).toUri();

        return ResponseEntity.created(location).build();

    }

    @RequestMapping(value = "/service/{surveyId}/{questions}/{questionId}",method = RequestMethod.DELETE)
    public ResponseEntity<Objects> deleteSurveyQuestions(@PathVariable String surveyId,@PathVariable String questionId){
        surveyService.deleteSurveyQuestion(surveyId,questionId);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/service/{surveyId}/{questions}/{questionId}",method = RequestMethod.PUT)
    public ResponseEntity<Objects> updateSurveyQuestions(@PathVariable String surveyId,
                                                         @PathVariable String questionId,
                                                         @RequestBody Question question){
        surveyService.updateSurveyQuestion(surveyId,questionId,question);

        return ResponseEntity.noContent().build();
    }
}
