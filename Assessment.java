/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package codhisattva;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;




/*

* File: Assessment.java

* Author: Daniel John

* Date: June 28, 2018

* Purpose: This class contains the functionality to store the various question

* types and to hold the data that will be used to create the various tests.

*/



/**

 * Revision History

 * 28 June 2019 - Initial Assessment file created by Daniel with test arrays to 

 * test the various method calls against fake data

 * 10 July 2018 Luke Markwordt added GUI components

 */

public class Assessment extends JPanel{

    

    /* 

    * Notes to self: 

    * 1. Does this need a constructor built at some point?

    * 2. Do the index values for questions need to start at 0 when initialized?

    */

    // Create arrays to store the various question types using class objects
    
    private CodeTracingQuestion[] codeTracingQuestions = new CodeTracingQuestion[25];

    private ErrorIDQuestion[] errorIDQuestions;

    Color baseBlue = new Color(0,51,102);
    
    //private MultipleChoiceQuestion[] multipleChoiceQuestions;

    public Assessment(){
          
        this.add(createMultipleChoicePanel());
        this.setLayout(new GridLayout(1,1)); 
        
    }
    

    /*

    * Theoretical method used to fill each appropriate test.  Will likely

    * change as progress on the program continues.

    */

    public void fillTest()

    {

        String[] feedbackQuestionOne = {"Incorrect", "Correct"};

        CodeTracingQuestion codeTracingQuestion1 = new CodeTracingQuestion(

                "what would you do for a Klondike bar?", 0,0,feedbackQuestionOne);

        codeTracingQuestions[0] = codeTracingQuestion1;

    }

    

   // Variables local to this class to track the question number a user is on

    private int codeTracingQuestionIndex, errorIDQuestionIndex, 

            multipleChoiceQuestionIndex = 0;

    

    /**

     * Method to display code tracing questions and increment the index once a

     * question has been completed

     */

    public void displayCodeTracingQuestions() 

    {

        codeTracingQuestions[codeTracingQuestionIndex].display();

        codeTracingQuestionIndex++;

    }

    

    /**

     * Method to display error ID questions and increment the index once a

     * question has been completed

     */

    public void displayErrorIdQuestions() 

    {

    //    errorIDQuestions[errorIDQuestionIndex].display();

        errorIDQuestionIndex++;

    }

    

    /**

     * Method to display multiple choice questions and increment the index once a

     * question has been completed

     */

    public void displayMultipleChoiceQuestions() 

    {

    //    multipleChoiceQuestions[multipleChoiceQuestionIndex].display();

        multipleChoiceQuestionIndex++;

    }

    public JPanel createCodeTracingPanel(){
        
    String[] arr= {
        "Hello", "you", "are", "special"
    };
        
        return new CodeTracingQuestion("question 1234", 1,4,arr);
        
    }
    
    public JPanel createMultipleChoicePanel(){
        
        String question = "what is the meaning of life";
        String[] choices = {"Choice A","Choice B","Choice C", "Choice D"};
        int answer = 1;
        String[] feedback = {"That","Was","A","Good","Choice"};
        
        return new MultipleChoiceQuestion(question,choices,answer,feedback);
        
    }
    public ErrorIDQuestion createErrorIDPanel(){
        
        String[] arr= {
        "Hello", "you", "are", "special"      
        };
        
        int[] in = {
        1,2,3,4
        };
        
        String[] feed = {
          "this","is","feedback"  
        };
        
        return new ErrorIDQuestion(arr,in,4, feed);
    }

}
