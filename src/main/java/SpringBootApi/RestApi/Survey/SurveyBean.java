package SpringBootApi.RestApi.Survey;

import java.util.List;

public class SurveyBean {

    public SurveyBean() {
    }

    private String id;
    private String title;
    private String description;
    private List<Question> questions;

    public SurveyBean(String id, String title, String description, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "SurveyBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + questions +
                '}';
    }
}
