
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 * In this program,user interaction is required.
 * First of all this program will create a canvas.
 * In which using for loop, starts will be generated 
 * of different size and at different location
 * User will be asked that how many points he want to create a constellation
 * user need to enter few points as Co-ordinates
 * and name of the Constellation
 * 
 * program will generate constellation using that user input
 * 
 * 
 * @author CHIRAG BARANDA 000759867
 * INSTRUCTOR: John Weber Course Code: COMP-10062-02
 * I, Chirag Baranda, student number 000759867, certify that all work submitted is my own work; 
 * that I have not copied it from any other source. 
 * I also certify that I have not allowed my work to be copied by others.
 */
public class Assignment1 extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        final int CANVAS_WIDTH = 1000;
        final int CANVAS_HEIGHT = 700;
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT); // Set canvas Size in Pixels
        stage.setTitle("Constellaton Drawing "); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Line line = new Line();

        // YOUR CODE STARTS HERE 
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT); //creating canvas
        gc.setFill(Color.WHITE);
        gc.fillOval(10, 10, 150, 150);
        //Image img = new Image("blue-planet-moon-png-28.png");

        //gc.drawImage(img, CANVAS_WIDTH, CANVAS_WIDTH);
        
        Random rand= new Random();
            
        //desiging stars 
        for (int i = 0; i < 1000; i++) {
            int randomSize = rand.nextInt(10);
            double x = Math.random() * CANVAS_WIDTH;
            double y = Math.random() * CANVAS_HEIGHT;
            gc.setFill(Color.WHITE);
            gc.fillOval(x, y, randomSize, randomSize);
        }
     //*** inputs usinng graphics
        int a = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter value for point x1 x- cordinate: "));
        a = checkValidNum(a); //Function to check number, wheather its in rquired range or not
        System.out.println(a);
        int b = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter value for point y1 y- cordinate: : "));
        b = checkValidNum(b);
        System.out.println(b);
        int TempA = a, TempB = b; //saving the sarting point value to temprory varibale so it can be used at a connecting point (last to first)
        int NumberOfPoints = Integer.parseInt(JOptionPane.showInputDialog(null, "how many poins you want to enter? "));
        System.out.println("NUmber of NumberOfPoints: " + NumberOfPoints);
        //*** processing + output
        for (int i = 0; i < NumberOfPoints; i++) {

            int c = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter value for point x2 x- cordinate: "));
            c = checkValidNum(c);
            int d = Integer.parseInt(JOptionPane.showInputDialog(null, " Enter value for point y2 y- cordinate: : "));
            d = checkValidNum(d);
            
            gc.setFill(Color.ORANGE);
            gc.fillOval(a, b, 9, 9);
            gc.fillOval(c, d, 9, 9);
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(2);
            gc.strokeLine(a + 0.5, b + 0.5, c + 0.5, d + 0.5);

            a = c;
            b = d;
        }
        //*** Output
        gc.setFill(Color.ORANGE);
        gc.fillOval(a, b, 9, 9);
        gc.fillOval(TempA, TempB, 9, 9);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.strokeLine(a + 0.5, b + 0.5, TempA + 0.5, TempB + 0.5);

        String ConstellationName = JOptionPane.showInputDialog(null, " Enter name for your Constellation : ");
        gc.setFont(Font.font("Times New Roman", 20));
        gc.setStroke(Color.ORANGE);
        gc.strokeText("Name of Constellation: " + ConstellationName, 400, 20);
        gc.strokeText("Name :  Chirag Baranda \nStudent number: 000759867", 750, 650);

        // YOUR CODE STOPS HERE
        stage.show();
    }

    //function to chec the number, whaere its in required rangeor not
    public int checkValidNum(int k) {
        System.out.println("inside check validnum funciton! ");
        int k1 = k;
        System.out.println("k1: " + k1);
        boolean flag = true;
        while (flag) {
            if (k1 <= 0 || k1 >= 700) {
                System.out.println("NUmber is not in range");
                k1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entered number is not in range, Please try again"));
            } else {
                System.out.println("number in range, go ahead");
                flag = false;
            }
        }

        return k1;
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused    
     */
    public static void main(String[] args) {
        launch(args);
    }
}
