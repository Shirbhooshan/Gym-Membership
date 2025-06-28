

public class PremiumMember extends GymMember
{
    //attributes
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //constructor
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate,String personalTrainer)
    {
        super(id, name,location,phone,email,gender,DOB,membershipStartDate);
        this.premiumCharge = 50000.00;
        this.paidAmount = 0;
        this.isFullPayment = false;
        this.discountAmount = 0;
        this.personalTrainer=personalTrainer;
    }
    
    //getter methods
    public final double getPremiumCharge()
    {
        return premiumCharge;
    }
    
    public String getPersonalTrainer()
    {
        return personalTrainer;
    }
    
    public boolean getIsFullPayment()
    {
        return isFullPayment;
    }
    
    public double getPaidAmount()
    {
        return paidAmount;
    }
    
    public double getDiscountAmount()
    {
        return discountAmount;
    }
    
    //method to pay due amount
    public String payDueAmount(double paidAmount)
    {
        this.paidAmount=paidAmount+this.paidAmount;
        
        if (this.isFullPayment == true)
        {
            return "Payment is already full";
        }
        else if (this.paidAmount > premiumCharge)
        {
            return "Paid too much.";
        }
        else if (paidAmount == premiumCharge)
        {
            isFullPayment = true;
        }
        else if (paidAmount != premiumCharge)
        {
            isFullPayment = false;
        }
        
        double remainingAmount = premiumCharge - paidAmount;
        return "Payment was successful. Remaining amount to be paid "+remainingAmount;
    }
    
    //method for discount
    public void calculateDiscount()
    {
        if (isFullPayment == true)
        {
            discountAmount = 0.10 * premiumCharge;
        }
        else
        {
            discountAmount = 0;
        }
    }
    
    //method to revert premium member
    public void revertPremiumMember()
    {
        super.resetMember(); //calling parent class
        this.personalTrainer = " "; //keep trainer null
        this.isFullPayment = false;
        this.paidAmount = 0.00;
        this.discountAmount = 0;
    }
    
    //for mark attendance
    @Override
    public void markAttendance()
    {
        attendance=attendance + 1;
    }
    
    //for display, override
    @Override
    public void display()
    {
        super.display();
        System.out.println("Personal Trainer "+personalTrainer);
        System.out.println("Paid Amount "+paidAmount);
        System.out.println("Payment "+isFullPayment);
        
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Due Payment "+remainingAmount);
        
        if (isFullPayment == true)
        {
            System.out.println("Discount Amount "+discountAmount);
        }
    }
    
    //we need this again for premium to avoid that display error
    @Override
    public String toString() 
    {
            return "--------------------------\n"+
                   "Premium Member\n"+
                   "--------------------------\n"+
                   "ID: " + getId() + "\n" +
                   "Full Name: " + getName() + "\n" +
                   "Gender: " + getGender() + "\n" +
                   "DOB: " + getDOB() + "\n" +
                   "Location: " + getLocation() + "\n" +
                   "Phone: " + getPhone() + "\n" +
                   "Email: " + getEmail() + "\n" +
                   "Membership Date: " + getMembershipStartDate() + "\n" +
                   "Attendance: " + getAttendance() + "\n" +
                   "Trainer: " + getPersonalTrainer();
    }
}