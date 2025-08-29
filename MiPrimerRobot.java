import kareltherobot.*;
import java.awt.Color;

class Racer extends Robot implements Runnable {
    Thread thr;

    public Racer(int Street, int Avenue, Direction direction, int beeps, Color color) {
        super(Street, Avenue, direction, beeps, color);
        World.setupThread(this);
        thr = new Thread(this);
    }

    public void race() {
        while(!nextToABeeper() && frontIsClear()) {
            move();
        }
        if (nextToABeeper()) {
            pickBeeper();
        }
        turnOff();
    }

    @Override
    public void run() {
        race();
    }

    public void start() {
        thr.start();
    }
}

public class MiPrimerRobot implements Directions
{
    public static void main(String [] args)
    {
        // Usamos el archivo que creamos del mundo
        World.readWorld("Mundo2.kwld");
        World.setVisible(true);
        
        Racer rojo = new Racer(2, 1, East, 0, Color.red);
        Racer azul = new Racer(3, 1, East, 0, Color.blue);

        rojo.start();
        azul.start();
    }
}