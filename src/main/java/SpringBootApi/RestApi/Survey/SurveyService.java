package SpringBootApi.RestApi.Survey;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Predicate;

@Service
public class SurveyService {
    private static List<SurveyBean> surveys=new ArrayList<>();
    static {
        Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");

        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");

        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        SurveyBean survey = new SurveyBean("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }

    public List<SurveyBean> retrieveAllSurveys() {
        return surveys;
    }

    public SurveyBean retrieveAllById(String surveyId) {
        Predicate<? super SurveyBean> predicate =
                surveyBean -> Objects.equals(surveyBean.getId(), surveyId);

        Optional<SurveyBean> optionalSurvey=
                surveys.stream().filter(predicate).findFirst();

        if(optionalSurvey.isEmpty())
            return null;

        return optionalSurvey.get();
    }

    public List<Question> retrieveSurveyQuestion(String surveyId) {
        SurveyBean survey=retrieveAllById(surveyId);
        if(survey==null) return null;
        return survey.getQuestions();
    }

    public Question retrieveSpecificQuestion(String surveyId, String questionId) {
        List<Question> surveyquestion=retrieveSurveyQuestion(surveyId);
         if(surveyquestion==null) return null;

    Optional<Question> optionalQuestion= surveyquestion.stream().filter(q->q.getId().equals(questionId)).findFirst();

    if(optionalQuestion.isEmpty()) return null;

    return optionalQuestion.get();
    }

    public String addNewSurveyQuestion(String surveyId, Question question) {
       List<Question> questions= retrieveSurveyQuestion(surveyId);
        SecureRandom secureRandom=new SecureRandom();
        String randomId= new BigInteger(32,secureRandom).toString();
        question.setId(randomId);
       questions.add(question);
       return question.getId();
    }

    public String deleteSurveyQuestion(String surveyId, String questionId) {

        List<Question> surveyQuestions = retrieveSurveyQuestion(surveyId);

        if (surveyQuestions == null)
            return null;


        Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
        boolean removed = surveyQuestions.removeIf(predicate);

        if(!removed) return null;

        return questionId;
    }

    public void updateSurveyQuestion(String surveyId, String questionId,Question question) {
        List<Question> questions=retrieveSurveyQuestion(surveyId);
        questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));

        questions.add(question);
    }
}
