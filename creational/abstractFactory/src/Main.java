/*
it will be same as simple factory example but here i will give spareparts also
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
interface SpareParts{
    void working();
}
class SteeringWheel implements SpareParts{
    double size;

    public SteeringWheel(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public void working() {
        System.out.println("SteeringWheel is working");
    }
}
class CarCamera implements SpareParts{
    int quality;

    public CarCamera(int quality) {
        this.quality = quality;
    }

    @Override
    public void working() {
        System.out.println("CarCamera is working");
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
interface AutoMobileFactory{
    Vehicle createVehicle(String vehicleType);
    SpareParts createSpareParts(String partName);
}
class BmwFactory implements  AutoMobileFactory{
    @Override
    public Vehicle createVehicle(String vehicleType) {
        if(vehicleType.equals("car")){
            return new Car("bmw-enginer-carrrrr","bmw-tyre-small");
        }
        else{
            return new Bus("bus-engine-bmw","bus-tyre-bmw");
        }
    }

    @Override
    public SpareParts createSpareParts(String partName) {
        if(partName.equals("steering")){
            return new SteeringWheel(10);
        }
        else {
            return new CarCamera(3);
        }
    }
}
class HondaFactory implements  AutoMobileFactory{
    @Override
    public Vehicle createVehicle(String vehicleType) {
        if(vehicleType.equals("car")){
            return new Car("honda-enginer-carrrrr","honda-tyre-small");
        }
        else{
            return new Bus("bus-engine-honda","bus-tyre-honda");
        }
    }
    @Override
    public SpareParts createSpareParts(String partName) {
        if(partName.equals("steering")){
            return new SteeringWheel(11);
        }
        else {
            return new CarCamera(7);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        AutoMobileFactory bmwFactory = new BmwFactory();
        SpareParts part1= bmwFactory.createSpareParts("camera");
        Vehicle v1 = bmwFactory.createVehicle("car");
        part1.working();
        v1.start();
        v1.stop();
    }
}