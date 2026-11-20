import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // DONE A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    public void startTimer() {
        this.timer.start();
    }

    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images. DONE Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { 
            int count = 0;
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getCoords()[0]);
                int y = (int) Math.round(car.getCoords()[1]);

                if (car.getDirection().equals("r") && car.getCoords()[0] >= 700) {
                    car.turnLeft();
                    car.turnLeft();
                }

                if (car.getDirection().equals("u") && car.getCoords()[1] <= 0) {
                    car.turnLeft();
                    car.turnLeft();
                }

                if (car.getDirection().equals("l") && car.getCoords()[0] <= 0) {
                    car.turnLeft();
                    car.turnLeft();
                }

                if (car.getDirection().equals("d") && car.getCoords()[1] >= 300) {
                    car.turnLeft();
                    car.turnLeft();
                }

                String cartype = car.getModelName();
                frame.drawPanel.moveit(x, y, cartype, count);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.revalidate();
                frame.drawPanel.repaint();
                count++;
            }
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turnLeft() {
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    void turnRight() {
        for (Car car : cars) {
            car.turnRight();
        }
    }

    void startEngines() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngines() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car.getModelName().equals("Saab95")) {
                Saab95 temp = (Saab95) car;
                temp.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car.getModelName().equals("Saab95")) {
                Saab95 temp = (Saab95) car;
                temp.setTurboOff();
            }
        }
    }
}
