public class CorporateCustomer extends Customer {
    private String companyName;
    private String companyAddress;
    
    public CorporateCustomer(String customerId, String firstName, String surname, 
                           String address, String companyName, String companyAddress) {
        super(customerId, firstName, surname, address);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }
    
    // Getters
    public String getCompanyName() { return companyName; }
    public String getCompanyAddress() { return companyAddress; }
    
    @Override
    public String getCustomerType() {
        return "Corporate";
    }
}