class TransactionDetails implements Cloneable{
    String schemeName;
    double amount;
    boolean sipTopUp;
    boolean euinDeclaration;

    public TransactionDetails() {
        schemeName="MCOG"; amount=12000.00;
        sipTopUp=false; euinDeclaration=false;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isSipTopUp() {
        return sipTopUp;
    }

    public void setSipTopUp(boolean sipTopUp) {
        this.sipTopUp = sipTopUp;
    }

    public boolean isEuinDeclaration() {
        return euinDeclaration;
    }

    public void setEuinDeclaration(boolean euinDeclaration) {
        this.euinDeclaration = euinDeclaration;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class Main {
    public static void main(String[] args)  {
        TransactionDetails t1 = new TransactionDetails();
        t1.setEuinDeclaration(true);
        try{
            TransactionDetails t2 = (TransactionDetails) t1.clone();
            t2.setAmount(100);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}