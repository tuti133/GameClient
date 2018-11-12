/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.model.response;

import gameclient.model.Question;
import gameclient.dto.ResponseDto;
import java.util.List;

/**
 *
 * @author Nobody
 */
public class GetRandomQuestionResponseDto extends ResponseDto{
    List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
}
