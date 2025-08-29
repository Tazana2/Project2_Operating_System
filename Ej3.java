import redtherobot.*;
import java.awt.Color;
public class Ej3 implements Directions
{
    public static void main(String [] args)
    {
        // Usamos el archivo que creamos del mundo
        World.readWorld("Mundo.kwld");
        World.setVisible(true);
        // Coloca el robot en la posición inicial del mundo (1,1),
        // mirando al Este, sin ninguna sirena.
        Robot red = new Robot(1, 1, East, 0, Color.red);
        Robot blue = new Robot(1, 1, East, 0, Color.blue);
        
        // Mover el robot 4 pasos
        red.move();
        red.move();
        red.move();
        red.move();
        // Recoger los 5 beepers
        red.pickBeeper();
        red.pickBeeper();
        red.pickBeeper();
        red.pickBeeper();
        red.pickBeeper();
        // Girar a la izquierda y salir de los muros
        red.turnLeft();
        red.move();
        red.move();
        // Poner los beepers fuera de los muros
        red.putBeeper();
        red.putBeeper();
        red.putBeeper();
        red.putBeeper();
        red.putBeeper();
        // Ponerse en otra posición y apagar el robot
        red.move();
        red.turnOff();

        // Mover el robot 4 pasos
        blue.move();
        blue.move();
        blue.move();
        blue.move();
        // Recoger los 5 beepers
        blue.pickBeeper();
        blue.pickBeeper();
        blue.pickBeeper();
        blue.pickBeeper();
        blue.pickBeeper();
        // Girar a la izquierda y salir de los muros
        blue.turnLeft();
        blue.move();
        blue.move();
        // Poner los beepers fuera de los muros
        blue.putBeeper();
        blue.putBeeper();
        blue.putBeeper();
        blue.putBeeper();
        blue.putBeeper();
        // Ponerse en otra posición y apagar el robot
        blue.move();
        blue.turnOff();
    }
}