import kareltherobot.*;
import java.awt.Color;

abstract class RutaRobot extends Robot implements Runnable {
    private final Thread thr;

    public RutaRobot(int street, int avenue, Direction dir, int beepers, Color color) {
        super(street, avenue, dir, beepers, color);
        World.setupThread(this);
        this.thr = new Thread(this);
    }

    @Override
    public final void run() {
        try {
            ejecutarRuta();
        } finally {
            // Intenta apagar al final para no dejar hilos vivos
            try { turnOff(); } catch (Throwable ignored) {}
        }
    }

    public void start() { thr.start(); }

    protected void avanzar() { move(); }

    protected void avanzarN(int n) {
        for (int i = 0; i < n; i++) move();
    }

    protected void turnRight() { turnLeft(); turnLeft(); turnLeft(); }

    protected void girarDerecha() { turnRight(); }

    protected void girarIzquierda() { turnLeft(); }

    protected void girar180() { turnLeft(); turnLeft(); }

    protected void recogerSiHayZumbador() {
        if (nextToABeeper()) pickBeeper();
    }

    protected void dejarSiTiene() {
        if (anyBeepersInBeeperBag()) putBeeper();
    }

    protected void avanzarHastaPared() {
        while (frontIsClear()) move();
    }

    protected abstract void ejecutarRuta();
}

class RobotTipoA extends RutaRobot {
    public RobotTipoA(int street, int avenue, Direction dir, int beepers) {
        super(street, avenue, dir, beepers, Color.red);
    }

    @Override
    protected void ejecutarRuta() {
        avanzarN(3);
        girarIzquierda();
        avanzarN(9);
        girarIzquierda();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarIzquierda();
        avanzarN(2);
    }
}

class RobotTipoB extends RutaRobot {
    public RobotTipoB(int street, int avenue, Direction dir, int beepers) {
        super(street, avenue, dir, beepers, Color.blue);
    }

    @Override
    protected void ejecutarRuta() {
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarIzquierda();
        avanzarHastaPared();
        girarDerecha();
        avanzarHastaPared();
    }
}

// class RobotTipoC extends RutaRobot {
//     public RobotTipoC(int street, int avenue, Direction dir, int beepers) {
//         super(street, avenue, dir, beepers, Color.green);
//     }

//     @Override
//     protected void ejecutarRuta() {
//     }
// }