/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package codhisattva;



import java.awt.*;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



/**

 *

 * @author lukem

 */

public class JavaTutorialGUI extends JFrame{



    /**

     * @param args the command line arguments

     */
    
    JPanel homePanel;
    Assessment assessmentPanel;
    InstructionModule instructionPanel;

    JPanel mainPanel, headerPanel, navPanel, titlePanel;

    JLabel instructionLink, assessmentLink;

    Color baseBlue = new Color(0,51,102);

    OptionText title, home, nav, next, previous, done;

    JTabbedPane navTabbedPane;

    String[] tutorialListArray = {"tutorial 1","tutorial 2","tutorial 3"};

    String[] assessmentListArray = {"Error ID", "Code Tracing", "Multiple Choice"};

    HomePanelMouseListener instructionLinkListener, assessmentLinkListener;

    public panelType panelSelect;
    
    HeaderPanelMouseListener homeListener, navListener, nextListener, 
            previousListener, doneListener;

    

    boolean navBool = false;

    enum panelType {

        homePanel, 

        instructionPanel, 

        assessmentPanel

    }

    public static void main(String[] args) {

        new JavaTutorialGUI();

    }

    

    JavaTutorialGUI(){

        initializeGUI();

    }

    

    public void makeContentPanels(){
        
        homePanel = new JPanel();
        
        instructionPanel = new InstructionModule(this);
        
        assessmentPanel = new Assessment();

        //create homePanel

        homePanel.setBackground(baseBlue);

        homePanel.setLayout(new GridLayout(1,2));

        

        instructionLink = new JLabel("Tutorials", SwingConstants.CENTER);

        instructionLink.setForeground(Color.WHITE);

        instructionLink.setName("instructionLink");

        

        instructionLinkListener = new HomePanelMouseListener(instructionLink);

        instructionLink.addMouseListener(instructionLinkListener);

        

        assessmentLink = new JLabel("Assessments",SwingConstants.CENTER);

        assessmentLink.setForeground(Color.WHITE);

        assessmentLink.setName("assessmentLink");

        

        homePanel.add(instructionLink);

        homePanel.add(assessmentLink);

        

        assessmentLinkListener = new HomePanelMouseListener(assessmentLink);

        assessmentLink.addMouseListener(assessmentLinkListener);

        

        //create tutorial

        /*JLabel tutorialText = new JLabel("Tutorial");

        tutorialText.setForeground(Color.WHITE);*/
        

        

        //create assessment

        /*assessmentPanel.setBackground(baseBlue);

        JLabel assessmentText = new JLabel("Assessment");

        assessmentText.setForeground(Color.WHITE);

        assessmentPanel.add(assessmentText);*/

        

    }

    

    JPanel makeHeaderPanel(){      

        //initialize titlePanel and OptionPanel

        titlePanel = new JPanel();

        titlePanel.setBackground(Color.BLACK);

        JPanel optionPanel = new JPanel();

        optionPanel.setBackground(Color.BLACK);

        

        //initialize headerPanel

        headerPanel = new JPanel();

        headerPanel.setBackground(Color.BLACK);

        headerPanel.setLayout(new BorderLayout());

        

        //initialize title and add to titlePanel

        title = new OptionText("Java Tutorials",Color.BLACK);

        titlePanel.add(title);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        

        //initialize home and nav and add to optionPanel

        home = new OptionText("home",Color.BLACK);

        home.setName("home");

        nav = new OptionText("nav",Color.BLACK);

        nav.setName("nav");
        
        next = new OptionText(">",Color.BLACK);
        
        next.setName("next");
        
        previous = new OptionText("<",Color.BLACK);
        
        previous.setName("previous");
        
        done = new OptionText("Done",Color.BLACK);
        
        done.setName("done");

        

         //initializing mouse listener

        homeListener = new HeaderPanelMouseListener(home, this);

        navListener = new HeaderPanelMouseListener(nav, this);

        nextListener = new HeaderPanelMouseListener(next, this);

        previousListener = new HeaderPanelMouseListener(previous, this);
        
        doneListener = new HeaderPanelMouseListener(done, this);
        //adding mouseListenre

        home.addMouseListener(homeListener);

        nav.addMouseListener(navListener);

        next.addMouseListener(nextListener);
        
        previous.addMouseListener(previousListener);
        
        done.addMouseListener(doneListener);

        optionPanel.add(home);

        optionPanel.add(nav);
        
        optionPanel.add(previous);

        optionPanel.add(next);
        
        optionPanel.add(done);

        optionPanel.setLayout(new GridLayout(1,5,5,5));

        headerPanel.add(optionPanel, BorderLayout.EAST);

        

        return headerPanel;

        

    }

    

    void initializeGUI(){

        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setSize(1000,600);

        

        makeContentPanels();

        createNavPanel();

        mainPanel = new JPanel();

        navBool = true;

        panelSelect = panelType.homePanel;

        

        this.add(makeHeaderPanel(),BorderLayout.NORTH);

        

        createMainPanel();

        

        this.setVisible(true);

    }

    

    JPanel createNavPanel(){


        navPanel = new JPanel();

        navPanel.setLayout(new GridLayout(1,1));

        

        

        JList tutorialList = new JList(tutorialListArray);
        JScrollPane tutorialScrollPane = new JScrollPane(tutorialList);
        
        JList assessmentList = new JList(assessmentListArray);
        JScrollPane assessmentScrollPane = new JScrollPane(assessmentList);

        navTabbedPane = new JTabbedPane();

        

        navTabbedPane.addTab("Tutorials",tutorialScrollPane);

        navTabbedPane.addTab("Assessments",assessmentScrollPane);

        

        navPanel.add(navTabbedPane);

        

        

        return navPanel;

    }

    public void createMainPanel(){

        mainPanel.removeAll();

        if (navBool == false){

            mainPanel.setLayout(new GridLayout(1,1));

            if(panelSelect.equals(panelType.homePanel)){

                titlePanel.revalidate();

                titlePanel.repaint();

                titlePanel.validate();

                

                mainPanel.add(homePanel);

                homePanel.revalidate();

                homePanel.repaint();

                homePanel.validate();

            }

            else if(panelSelect.equals(panelType.instructionPanel)){

                mainPanel.add(instructionPanel);

                instructionPanel.revalidate();

                instructionPanel.repaint();

                instructionPanel.validate();

            }else if(panelSelect.equals(panelType.assessmentPanel)){

                mainPanel.add(assessmentPanel);

                assessmentPanel.revalidate();

                assessmentPanel.repaint();

                assessmentPanel.validate();

            }

            

            mainPanel.revalidate();

            mainPanel.repaint();

            mainPanel.validate();

            

            this.revalidate();

            this.repaint();

            this.validate();

        }

        else if (navBool == true){

            mainPanel.setLayout(new GridLayout(1,2));

            if(panelSelect.equals(panelType.homePanel)){

                mainPanel.add(homePanel);

                homePanel.revalidate();

                homePanel.repaint();

                homePanel.validate();

            }

            else if(panelSelect.equals(panelType.instructionPanel)){

                mainPanel.add(instructionPanel);

                instructionPanel.revalidate();

                instructionPanel.repaint();

                instructionPanel.validate();

            }else if(panelSelect.equals(panelType.assessmentPanel)){

                mainPanel.add(assessmentPanel);

                assessmentPanel.revalidate();

                assessmentPanel.repaint();

                assessmentPanel.validate();

            }

            mainPanel.add(navPanel);

            navPanel.revalidate();

            navPanel.repaint();

            navPanel.validate();

            

            this.revalidate();

            this.repaint();

            this.validate();

        }

        

        this.add(mainPanel);

        mainPanel.revalidate();

        this.revalidate();

    }

    class HomePanelMouseListener implements MouseListener{

        JLabel _ot;

        HomePanelMouseListener(JLabel ot){

            _ot = ot;

        }

        @Override

        public void mouseClicked(MouseEvent me) {

            if(_ot.getName().equals("instructionLink")){

                panelSelect = panelType.instructionPanel;

                createMainPanel();

            }else if(_ot.getName().equals("assessmentLink")){

                panelSelect = panelType.assessmentPanel;

                createMainPanel();

            }

            _ot.setForeground(Color.WHITE);

        }



        @Override

        public void mousePressed(MouseEvent me) {

        }



        @Override

        public void mouseReleased(MouseEvent me) {

        }



        @Override

        public void mouseEntered(MouseEvent me) {

            _ot.setForeground(Color.YELLOW);

        }



        @Override

        public void mouseExited(MouseEvent me) {

            _ot.setForeground(Color.WHITE);

        }



    }

    public class HeaderPanelMouseListener implements MouseListener {



        OptionText _ot;
        JavaTutorialGUI _jTG;

        HeaderPanelMouseListener(OptionText ot, JavaTutorialGUI jTG){
            _jTG = jTG;
            _ot = ot;

        }

        @Override

        public void mouseClicked(MouseEvent me) {

            

            if(_ot.getName().equals("home")){

                panelSelect = panelType.homePanel;

                createMainPanel();

            }else if (_ot.getName().equals("nav")){

                navBool = !navBool;

                createMainPanel();

            }else if (_ot.getName().equals("next")){
                
                if(panelSelect.equals(panelType.instructionPanel)){       
                    
                    System.out.print("hello");
                    
                    instructionPanel.next();
                    
                }else if(panelSelect.equals(panelType.assessmentPanel)){
                    
                }
                
            }else if (_ot.getName().equals("previous")){
                
                if(panelSelect.equals(panelType.instructionPanel)){                   
                    
                    
                    
                }else if(panelSelect.equals(panelType.assessmentPanel)){
                    
                }
                
            }else if (_ot.getName().equals("done")){
                
                _jTG.panelSelect = panelType.homePanel;
                createMainPanel();
                
            }

            _ot.setColor(Color.WHITE);

        }

        @Override

        public void mousePressed(MouseEvent me) {

        }



        @Override

        public void mouseReleased(MouseEvent me) {

        }



        @Override

        public void mouseEntered(MouseEvent me) {

            _ot.setColor(Color.YELLOW);

        }



        @Override

        public void mouseExited(MouseEvent me) {

            _ot.setColor(Color.WHITE);

        }



    }



}

 class OptionText extends JPanel{

    private JLabel label;

        OptionText(String title, Color backGround){

            label = new JLabel(title);

            label.setForeground(Color.white);

            label.setFont(new Font("Serif", Font.PLAIN, 16));

            label.setAlignmentX(Component.LEFT_ALIGNMENT);

            this.add(label);

            this.setBackground(backGround);

        }

        public void setFontSize(int x){

            label.setFont(new Font("Serif", Font.PLAIN, x));

        }

        public void setColor(Color color){

            label.setForeground(color);

        }

        public void setText(String t){

            label.setText(t);

        }

}
