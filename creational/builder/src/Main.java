import java.time.LocalDate;

class TransactionSummary{
    private double sipAmount;
    private LocalDate sipStartDate;
    private LocalDate sipEndDate;
    private String schemeCd;
    private String brokerCode;
    private String investorName;
    private TransactionSummary (TransactionSummaryBuilder transactionSummaryBuilder){
        sipAmount=transactionSummaryBuilder.sipAmount;
        schemeCd=transactionSummaryBuilder.schemeCd;
        sipStartDate=transactionSummaryBuilder.sipStartDate;
        sipEndDate=transactionSummaryBuilder.sipEndDate;
        brokerCode=transactionSummaryBuilder.brokerCode;
        investorName=transactionSummaryBuilder.brokerCode;
    }
    public static class TransactionSummaryBuilder {

        private double sipAmount = 1000;
        private LocalDate sipStartDate = LocalDate.now();
        private LocalDate sipEndDate = LocalDate.now();
        private String schemeCd ="MCOG";
        private String brokerCode="ARN-11234";
        private String investorName="ARYAN-KOHLI";

        public TransactionSummaryBuilder SipAmount(double sipAmount) {
            this.sipAmount = sipAmount;
            return this;
        }

        public TransactionSummaryBuilder SipStartDate(LocalDate sipStartDate) {
            this.sipStartDate = sipStartDate;
            return this;
        }

        public TransactionSummaryBuilder SipEndDate(LocalDate sipEndDate) {
            this.sipEndDate = sipEndDate;
            return this;
        }

        public TransactionSummaryBuilder SchemeCd(String schemeCd) {
            this.schemeCd = schemeCd;
            return this;
        }

        public TransactionSummaryBuilder BrokerCode(String brokerCode) {
            this.brokerCode = brokerCode;
            return  this;
        }

        public TransactionSummaryBuilder InvestorName(String investorName) {
            this.investorName = investorName;
            return this;
        }

        public TransactionSummary build(){
            return new TransactionSummary(this);
        }
    }

    @Override
    public String toString() {
        return "TransactionSummary{" +
                "sipAmount=" + sipAmount +
                ", sipStartDate=" + sipStartDate +
                ", sipEndDate=" + sipEndDate +
                ", schemeCd='" + schemeCd + '\'' +
                ", brokerCode='" + brokerCode + '\'' +
                ", investorName='" + investorName + '\'' +
                '}';
    }
}
/*
Builder design pattern is used to solve the problems of making so many contructors,readibility, and immutablity.
* */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        TransactionSummary summary =
                new TransactionSummary.TransactionSummaryBuilder().SchemeCd("mySchme").build();
        System.out.println(summary);
        TransactionSummary summary2 =
                new TransactionSummary.TransactionSummaryBuilder().SchemeCd("mySchme2").SipAmount(10000).build();
        System.out.println(summary2);
        TransactionSummary summary3 =
                new TransactionSummary.TransactionSummaryBuilder().SchemeCd("mySchme").SipAmount(10021).InvestorName("Anshu Kohli").build();
        System.out.println(summary3);
    }
}