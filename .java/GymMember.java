
public abstract class GymMember
{
    //given attributes and protected modifier
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //adding constructors for each
    public GymMember(int id,String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate)
    {
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0.0; //because double
        this.activeStatus=false; //needs to be false
    }
    
    //for accessing them, we need get methods
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getDOB()
    {
        return DOB;
    }
    
    public String getMembershipStartDate()
    {
        return membershipStartDate;
    }
    
    public int getAttendance()
    {
        return attendance;
    }
    
    public double getLoyaltyPoints()
    {
        return loyaltyPoints;
    }
    
    public boolean isActive()
    {
        return activeStatus;
    }
    
    //a abstract method for mark attendance
    public abstract void markAttendance(); //doesn't have a body because abstract
    
    //method to change activeStatus to true
    public void activateMembership()
    {
        activeStatus= true;
    }
    
    //method to deactive the membership or change activeStatus to false
    public void deactivateMembership()
    {
        activeStatus= false;
    }
    
    //method reset
    public void resetMember()
    {
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0.0;
    }
    
    //display method
    public void display()
    {
        System.out.println("Gym Membership Details");
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Phone: "+phone);
        System.out.println("Email: "+email);
        System.out.println("Gender: "+gender);
        System.out.println("Date of Birth: "+DOB);
        System.out.println("Membership Start Date: "+membershipStartDate);
        System.out.println("Attendance: "+attendance);
        System.out.println("Loyalty Points: "+loyaltyPoints);
        System.out.println("Active Status: "+(activeStatus ? "Active":"Inactive"));
        //since we need active status to print active and inactive we use ternary operator
        //otherwise it will just print true and false.
    }
    
}
