public abstract class Customer {
    protected String customerId;
    protected String firstName;
    protected String surname;
    protected String address;
    
    public Customer(String customerId, String firstName, String surname, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }
    
    // Getters
    public String getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    
    public abstract String getCustomerType();
}