void main() {
    // Instance of this class
    CarController cc = new CarController();

    // DONE uncomment, and adapt if necessary
    cc.cars.add(new Volvo240());
    Saab95 coolSaab = new Saab95();
    coolSaab.setCoords(20, 20);
    cc.cars.add(coolSaab);

    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.startTimer();
}