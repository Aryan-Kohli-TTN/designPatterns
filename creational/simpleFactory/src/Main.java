import java.util.Scanner;

interface Vehicle{
    void start();
    void stop();
}
class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("Car Starts");
    }

    @Override
    public void stop() {
        System.out.println("Car Stops");
    }
}
class Bus implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bus Starts");
    }

    @Override
    public void stop() {
        System.out.println("Bus Stops");
    }
}
class VehicleFactory{
    public Vehicle createVehicle(String s){
        if(s.equalsIgnoreCase("car")){
            return new Car();
        }
        else if(s.equalsIgnoreCase("bus")){
            return new Bus();
        }
        else {
            throw new RuntimeException("Invalid vehicle type hai");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String vehicle = "";
//        vehicle=sc.next();
//        Vehicle v1 ;
        /*
        if i dont use factory design pattern then i need to do this
        if(vehicle.equals("car"))
        {
            v1= new Car();
        }
         */

        VehicleFactory factory = new VehicleFactory();

        int n;
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            vehicle=sc.next();
            try{
            Vehicle v2 = factory.createVehicle(vehicle);
            v2.start();}
            catch (Exception e){
                System.out.println("Invalid vehicle type");
            }
        }
    }
}