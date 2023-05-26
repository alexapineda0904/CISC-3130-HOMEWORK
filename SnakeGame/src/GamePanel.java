import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class GamePanel extends JPanel implements ActionListener{

static final int SCREEN_WIDTH = 600;//Sets the width of the game screen//
static final int SCREEN_HEIGHT = 600;//Sets the height of the game screen//
static final int UNIT_SIZE = 25;//size of objects//
static final int GAME_UNITS = (SCREEN_WIDTH *SCREEN_HEIGHT)/UNIT_SIZE;//how many objects can fit on screen//
static final int DELAY = 150; //delay for timer//
final int x[] = new int[GAME_UNITS]; //holds coordinates for Snake body parts(horizontally)//
final int y[] = new int [GAME_UNITS];//holds coordinates for Snake body parts(vertically)//
int bodyParts = 6;//snakes body parts//
int applesEaten; //how many apples eaten//
int appleX;//where the apple is at horizontally//
int appleY;//where the apple is at vertically// 
char direction = 'R';// The direction in which the snakes begins to slither//
boolean running = false; //the game is running//
Timer timer;
Random random;


//Constructor that initializes variables and calls startGame method// 
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    //This method starts the game; populates new Apple & begins timer //
    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    //paints the snake and the apple//
    public void draw(Graphics g){
       if(running) {

           g.setColor(new Color(210,115,90));
           g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);

           g.setColor(Color.white);
           g.fillRect(x[0],y[0],UNIT_SIZE,UNIT_SIZE);

           for(int i = 1; i <bodyParts; i++){
               g.setColor(new Color(40,200,150));
               g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
           }
           g.setColor(Color.white);
           g.setFont(new Font("Sans serif",Font.ROMAN_BASELINE,25));
           FontMetrics metrics = getFontMetrics(g.getFont());
           g.drawString("Score:"+applesEaten,(SCREEN_WIDTH-metrics.stringWidth("Score:"+applesEaten))/2,
                   g.getFont().getSize());
       }
       else{
           gameOver(g);
       }
    }
    //populates apple onto board in random area//
    public void newApple(){
        appleX = random.nextInt((SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    

    }
    public void move(){
        for(int i = bodyParts; i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        switch (direction){
            case 'U':
                y[0]= y[0]- UNIT_SIZE;
                break;
            case 'D':
                y[0]= y[0]+ UNIT_SIZE;
                break;
            case 'L':
                x[0]= x[0]- UNIT_SIZE;
                break;
            case 'R':
                x[0]= x[0] + UNIT_SIZE;
                break;
        }
        }
    }
    //Checks if Apple is eaten by snake, Raises score and length of snake//
    public void checkApple(){
        if((x[0]==appleX)&&(y[0]==appleY)){
            bodyParts++;
            applesEaten++;
        }
    }
    //Checks if snake hits the end of the screen//
    public void checkCollisions(){
        for(int i = bodyParts; i > 0;i--){
            if((x[0]==x[i])&&(y[0]==y[i])){
                running = false;
            }
        }
        if(x[0]< 0){
            running = false;
        }
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        if(y[0]< 0){
            running = false;
        }
        if(y[0]> SCREEN_HEIGHT){
            running = false;
        }
        if(!running){
            timer.stop();
        }

    }
    //Creation of the Game over screen//
    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",(SCREEN_WIDTH- metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);

    }
    //Runs the game//
@Override
public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

}
//Overrides keyPressed method in order to letter user use the arrow keys on keyboard//
public class MyKeyAdapter extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if(direction!= 'L'){
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_LEFT:
                if(direction!= 'R'){
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_DOWN:
                if(direction!= 'U'){
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_UP:
                if(direction!= 'D'){
                    direction = 'U';
                }
                break;


        }
    }
}

}