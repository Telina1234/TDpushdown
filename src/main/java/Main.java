public class Main {

    public static void main(String[] args) throws Exception {

        DataRetriever dr = new DataRetriever();

        dr.findInvoiceTotals()
                .forEach(i -> System.out.println(
                        i.id + " " + i.customer + " " + i.total
                ));

        System.out.println(dr.computeWeightedTurnover());
        System.out.println(dr.computeWeightedTurnoverTtc());
    }
}
