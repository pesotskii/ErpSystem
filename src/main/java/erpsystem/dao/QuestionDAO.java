package erpsystem.dao;



import erpsystem.entity.Question;

import java.util.List;

public interface QuestionDAO {

    void addQuestion(Question question);

    void updateQuestion(Question question);

    void deleteQuestion(Question question);

    Question getQuestionById(int id);

    Question getQuestionByName(String name);

    List<Question> getQuestionList();

}
