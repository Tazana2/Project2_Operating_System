import kareltherobot.*;

public class RunnerRutas implements Directions {
    public static void main(String[] args) {
        String world = (args.length > 0) ? args[0] : "Trabajos/World2.kwld";
        int delay = (args.length > 1) ? Integer.parseInt(args[1]) : 25;

        if (world != null && !world.isEmpty()) {
            World.readWorld(world);
        }
        World.setVisible(true);
        World.asObject().setDelay(delay);

        RutaRobot rA = new RobotTipoA(2, 8, East, 0);
        RutaRobot rB = new RobotTipoB(11, 23, West, 0);
        // RutaRobot rC = new RobotTipoC(12, 23, South, 0);
        
        rA.start();
        RutaRobot rA2 = new RobotTipoA(2, 8, East, 0);
        rA2.start();
        rB.start();
        // rC.start();
    }
}
