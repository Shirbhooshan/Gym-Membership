
public class RegularMember extends GymMember
{
    //private attributes
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //constructor, also calling constructor values from parent class
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource)
    {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit=30;
        this.isEligibleForUpgrade=false;
        this.plan="Basic";
        this.price=6500.00;
        this.removalReason=""; //empty
        this.referralSource=referralSource; //call itself
    }
    
    //making getter methods for each of RegularMember
    
    public final int getAttendanceLimit()
    {
        return attendanceLimit;
    }
    
    public boolean getIsEligibleForUpgrade()
    {
        return isEligibleForUpgrade;
    }
    
    public String getRemovalReason()
    {
        return removalReason;
    }
    
    public String getReferralSource()
    {
        return referralSource;
    }
    
    public String getPlan()
    {
        return plan;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    //overriding markAttendance 
    @Override
    public void markAttendance()
    {
        attendance=attendance + 1; //increase by one everytime called
        loyaltyPoints = loyaltyPoints + 10; //increase by 10
        //eligibility criteria
        if (attendance>= attendanceLimit)
        {
            isEligibleForUpgrade=true;
        }
    }
    
    //making a getAttendance method
    public int getAttendance()
    {
        return attendance;
    }
    
    //method for retrieving price for given plan with switch case
    public double getPlanPrice(String plan)
    {
        switch (plan.toLowerCase()) //changes to lower case to make comparison easier
        {
            case "basic":
                return 6500.00;
            case "standard":
                return 12500.00;
            case "deluxe":
                return 18500.00;
            default:
                return -1.00;
        }
    }
    
    
    //method to upgrade plan of member
    public String upgradePlan()
    {
        if(this.attendance>=attendanceLimit)
        {
            this.isEligibleForUpgrade = true;
        }
        
        if (!isEligibleForUpgrade)
        {
            return "You are not eligible for the upgrade";
        }
        
        switch (plan.toLowerCase()) 
        {
            case "basic":
                plan = "Standard"; //if we're in basic it goes to standard
                price = getPlanPrice(plan);
                return "Plan upgraded from Basic to Standard.";
            case "standard":
                plan = "Deluxe"; //if in standard goes to deluxe
                price = getPlanPrice(plan);
                return "Plan upgraded from Standard to Deluxe.";
            case "deluxe": //no upgrade
                return "You are already on the highest plan.";
            default:
                return "Current plan is invalid.";
        }
    }
    
    /*
    public String upgradePlan(String plan)
    {
        if(this.attendance>=attendanceLimit)
        {
            this.isEligibleForUpgrade = true;
        }
        
        if (!isEligibleForUpgrade)
        {
            return "You are not eligible for the upgrade";
        }
        
        if (plan == this.plan)
        {
            return "You are already on this plan";
        }
        
        double price = getPlanPrice(plan);
        if (price == -1)
        {
            return "Invalid plan";
        }
        
        this.plan = plan;
        this.price = price;
        return "Plan has been upgraded successfully to "+plan;
    }
    */

    //method to convert to regular member
    public void revertRegularMember(String removalReason)
    {
        resetMember(); //to call method
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500.00;
        this.removalReason = removalReason;
    }
    
    //to "override" the display method
    @Override
    public void display()
    {
        super.display(); //calling from parent class
        System.out.println("Plan: "+plan); 
        System.out.println("Price: "+price);
        if (removalReason.isEmpty()) //isEmpty() is a method to check whether value is null
        {
            System.out.println("Removal Reason: "+removalReason);
        }
    }
    
    //we need this for not printing the display() error and also for just printing
    @Override
    public String toString() 
    {
        return "--------------------------\n"+
               "Regular Member\n" +
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
               "Referral Source: " + getReferralSource();
    }
}