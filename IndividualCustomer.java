public class IndividualCustomer extends Customer {
    public IndividualCustomer(String customerId, String firstName, String surname, String address) {
        super(customerId, firstName, surname, address);
    }
    
    @Override
    public String getCustomerType() {
        return "Individual";
    }
}