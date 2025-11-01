/*
in simple factory i made car and bus using a factory method
let's suppose in future i have 2 companies which make car and bus in their own way so what would i do

i make separet factory for both of them
like honda factory and bmw factory

* */
interface Vehicle{
    void start();
    void stop();
}
class Car implements  Vehicle{

    String carEngine;
    String carTyre;

    public Car(String carEngine, String carTyre) {
        this.carEngine = carEngine;
        this.carTyre = carTyre;
    }

    @Override
    public void start() {
        System.out.println("car Start");
    }
    @Override
    public void stop() {
        System.out.println("car stop");
    }
    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarTyre() {
        return carTyre;
    }

    public void setCarTyre(String carTyre) {
        this.carTyre = carTyre;
    }
}
class Bus implements  Vehicle{
    String busEngine;
     String busTyre;

    public Bus(String busEngine, String busTyre) {
        this.busEngine = busEngine;
        this.busTyre = busTyre;
    }

    @Override
    public void start() {
        System.out.println("bus Start");
    }
    @Override
    public void stop() {
        System.out.println("bus stop");
    }

    public String getBusEngine() {
        return busEngine;
    }

    public void setBusEngine(String busEngine) {
        this.busEngine = busEngine;
    }

    public String getBusTyre() {
        return busTyre;
    }

    public void setBusTyre(String busTyre) {
        this.busTyre = busTyre;
    }
}
interface VehicleFactory{
    Vehicle createVehicle(String vehicleType);
}
class BmwFactory implements  VehicleFactory{
    @Override
    public Vehicle createVehicle(String vehicleType) {
        if(vehicleType.equals("car")){
            return new Car("bmw-enginer-carrrrr","bmw-tyre-small");
        }
        else{
            return new Bus("bus-engine-bmw","bus-tyre-bmw");
        }
    }
}
class HondaFactory implements  VehicleFactory{
    @Override
    public Vehicle createVehicle(String vehicleType) {
        if(vehicleType.equals("car")){
            return new Car("honda-enginer-carrrrr","honda-tyre-small");
        }
        else{
            return new Bus("bus-engine-honda","bus-tyre-honda");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        VehicleFactory bmwFactory = new BmwFactory();
        VehicleFactory hondaFactory = new HondaFactory();

        Vehicle v1 = bmwFactory.createVehicle("car");
        Vehicle v2 = hondaFactory.createVehicle("bus");
        v1.start();
        v2.stop();
    }
}