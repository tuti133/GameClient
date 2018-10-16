/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.util;

import gameclient.model.Question;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SocketMessageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;
    private String msg;
    private int id;
    private int idWin;
    private String nickName;
    private int matchId;
    private int correctAnswer;
 
    private List<Question> questionList;

    public int getIdWin() {
        return idWin;
    }

    public void setIdWin(int idWin) {
        this.idWin = idWin;
    }

    
    public List<Question> getQuestionList() {
        return questionList;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
    
    public SocketMessageDto() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
