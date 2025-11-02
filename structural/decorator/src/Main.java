interface Coffee{
    String getDescription();
    double amount();
}
class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double amount() {
        return 100;
    }
}
abstract class DecoratedCoffee implements Coffee{
    Coffee coffee;
    public DecoratedCoffee(Coffee coffee){
        this.coffee=coffee;
    }
}
class MilkCoffee extends DecoratedCoffee{
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+", Milk ";
    }

    @Override
    public double amount() {
        return coffee.amount()+50;
    }
}
class IceCoffee extends DecoratedCoffee{
    public IceCoffee(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription()+", Ice ";
    }

    @Override
    public double amount() {
        return coffee.amount()+3;
    }
}
class CreamCoffee extends DecoratedCoffee{
    public CreamCoffee(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
        return coffee.getDescription()+", Cream ";
    }

    @Override
    public double amount() {
        return coffee.amount()+30;
    }
}
public class Main {
    public static void main(String[] args) {
        Coffee coffee =new SimpleCoffee();
        System.out.println(coffee.getDescription()+" "+coffee.amount());

        Coffee milkCoffee = new MilkCoffee(coffee);
        System.out.println(milkCoffee.getDescription()+" "+milkCoffee.amount());

        Coffee creamMikCoffee = new CreamCoffee(milkCoffee);
        System.out.println(creamMikCoffee.getDescription()+" "+creamMikCoffee.amount());

        Coffee iceCoffee = new IceCoffee(coffee);
        System.out.println(iceCoffee.getDescription()+" "+iceCoffee.amount());



    }
}