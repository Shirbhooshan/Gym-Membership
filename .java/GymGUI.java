import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class GymGUI extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel left_panel,
                   right_panel;
    private JLabel Title,
                   Personal_details,
                   GymMembership_details,
                   AlreadyMembership_details_1,
                   AlreadyMembership_details_2,
                   de_activate_details,
                   statusChange_details,
                   attendance_details,
                   price_details,
                   ID_1,
                   ID_2,
                   Firstname,
                   Lastname,
                   Fullname,
                   Location,
                   Phone,
                   Email,
                   Gender,
                   DOB,
                   Membership,
                   Referralsource_1,
                   Referralsource_2,
                   Paidamount,
                   Removalreason,
                   Trainer,
                   Plan,
                   Price,
                   imageLabel;
    private JTextField ID_1_field,
                       ID_2_field,
                       Firstname_field,
                       Lastname_field,
                       Fullname_field,
                       Location_field,
                       Phone_field,
                       Email_field,
                       Referralsource_1_field,
                       Referralsource_2_field,
                       Paidamount_field,
                       Price_field,
                       Discount_field,
                       Removalreason_field,
                       Trainer_field;
    private JComboBox<String> DOB_year,
                              DOB_month,
                              DOB_day,
                              Membership_year,
                              Membership_month,
                              Membership_day,
                              Plan_box;
    private JButton activateMembership,
                    deactivateMembership,
                    markAttendance,
                    regularMember,
                    premiumMember,
                    revertRegularMember,
                    revertPremiumMember,
                    display,
                    clear,
                    addRegular,
                    addPremium,
                    upgradePlan,
                    payDue,
                    save,
                    open,
                    discountButton;
    private JRadioButton maleButton,
                         femaleButton;
    private ButtonGroup genderGroup;
    private ImageIcon image;
    
    // private JScrollPane scroll;
    
    //arraylist
    private ArrayList<GymMember> members;
    
    public static void main(String[]args)
    {
        ArrayList <GymMember> members = new ArrayList<GymMember>();
    
        SwingUtilities.invokeLater(() -> new GymGUI()); //we need this to run
    }
    
    
    public GymGUI()
    {
        //arraylist
        members = new ArrayList<GymMember>();
        
        //initialize frame and panel
        frame = new JFrame("Gym Membership");
        frame.setTitle("Gym Membership");
        frame.setLayout(null); // no layout set
        
        left_panel = new JPanel();
        left_panel.setBackground(Color.WHITE);
        left_panel.setLayout(null);
        left_panel.setBounds(0, 0, 915, 800);
        
        right_panel = new JPanel();
        right_panel.setBackground(new Color(0x4D7D5B));
        right_panel.setLayout(null);
        right_panel.setBounds(915, 0, 525, 800);
                
        //adding left_panel labels

        Title = new JLabel("Gym Membership");
        Title.setBounds(216,44,464,62);
        Title.setFont(new Font("Segoe UI", Font.BOLD,48));
        
        Personal_details = new JLabel("PERSONAL DETAILS");
        Personal_details.setBounds(69,123,184,27);
        Personal_details.setFont(new Font("Segoe UI", Font.PLAIN,13));
        
        GymMembership_details = new JLabel("GYM MEMBERSHIP DETAILS");
        GymMembership_details.setBounds(69,436,184,27);
        GymMembership_details.setFont(new Font("Segoe UI", Font.PLAIN,13));
        
        ID_1 = new JLabel("ID:");
        ID_1.setBounds(86,478,43,35);
        ID_1.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Firstname = new JLabel("First Name:");
        Firstname.setBounds(86,164,123,34);
        Firstname.setFont(new Font("Segoe UI", Font.PLAIN,20));
                
        Lastname = new JLabel("Last Name:");
        Lastname.setBounds(86,207,121,36);
        Lastname.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Location = new JLabel("Location:");
        Location.setBounds(481,209,150,34);
        Location.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        DOB = new JLabel("Date of Birth:");
        DOB.setBounds(481,166,150,34);
        DOB.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Gender = new JLabel("Gender:");
        Gender.setBounds(86,253,90,28);
        Gender.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Phone = new JLabel("Phone:");
        Phone.setBounds(86,300,90,35);
        Phone.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Email = new JLabel("Email:");
        Email.setBounds(86,341,76,36);
        Email.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Referralsource_1 = new JLabel("Referral Source:");
        Referralsource_1.setBounds(86,383,167,38);
        Referralsource_1.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Membership = new JLabel("Membership Start Date:");
        Membership.setBounds(406,475,239,30);
        Membership.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Trainer = new JLabel("Trainer's Name:");
        Trainer.setBounds(84,566,175,30);
        Trainer.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Referralsource_2 = new JLabel("Referral Source:");
        Referralsource_2.setBounds(86,602,163,38);
        Referralsource_2.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Removalreason = new JLabel("Removal Reason:"); 
        Removalreason.setBounds(86,649,170,30);
        Removalreason.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Plan = new JLabel("Plan:");
        Plan.setBounds(86,522,55,35);
        Plan.setFont(new Font("Segoe UI", Font.PLAIN,20));
        
        Price = new JLabel("Price:");
        Price.setBounds(406,522,55,35);
        Price.setFont(new Font("Segoe UI", Font.PLAIN,20));
                
        //adding left_panel textfields
        ID_1_field = new JTextField();
        ID_1_field.setBounds(122,478,237,34);
        ID_1_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Firstname_field = new JTextField();
        Firstname_field.setBounds(206,166,237,34);
        Firstname_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Lastname_field = new JTextField();
        Lastname_field.setBounds(206,211,237,34);
        Lastname_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Location_field = new JTextField();
        Location_field.setBounds(574,211,277,34); 
        Location_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Phone_field = new JTextField();
        Phone_field.setBounds(162,302,237,34);
        Phone_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Email_field = new JTextField();
        Email_field.setBounds(162,345,237,34);
        Email_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Referralsource_1_field = new JTextField();
        Referralsource_1_field.setBounds(248,387,237,34);
        Referralsource_1_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Trainer_field = new JTextField();
        Trainer_field.setBounds(236,565,283,34);
        Trainer_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Referralsource_2_field = new JTextField();
        Referralsource_2_field.setBounds(244,606,237,34);
        Referralsource_2_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Removalreason_field = new JTextField();
        Removalreason_field.setBounds(254,650,227,34);
        Removalreason_field.setFont(new Font("Arial", Font.PLAIN, 18));
        
        Price_field = new JTextField();
        Price_field.setBounds(465,522,93,34);
        Price_field.setEditable(false); //non-editable
        Price_field.setFont(new Font("Arial",Font.BOLD,16));
        
        //adding left_panel comboboxes
        DOB_day = new JComboBox<>(new String[]{" ",
                                               "1",
                                               "2",
                                               "3",
                                               "4",
                                               "5",
                                               "6",
                                               "7",
                                               "8",
                                               "9",
                                               "10",
                                               "11",
                                               "12",
                                               "13",
                                               "14",
                                               "15",
                                               "16",
                                               "17",
                                               "18",
                                               "19",
                                               "20",
                                               "21",
                                               "22",
                                               "23",
                                               "24",
                                               "25",
                                               "26",
                                               "27",
                                               "28",
                                               "29",
                                               "30",
                                               "31"});
        DOB_day.setBounds(614,166,66,34);
        DOB_day.setBackground(Color.WHITE);
        DOB_day.setFont(new Font("Segoe UI", Font.PLAIN,16));
        
        DOB_month = new JComboBox<>(new String[]{" ",
                                                 "January",
                                                 "February",
                                                 "March",
                                                 "April",
                                                 "May",
                                                 "June",
                                                 "July",
                                                 "August",
                                                 "September",
                                                 "October",
                                                 "November",
                                                 "December"});
        DOB_month.setBounds(688,166,89,34);
        DOB_month.setBackground(Color.WHITE);
        DOB_month.setFont(new Font("Segoe UI", Font.PLAIN,16));
        
        DOB_year = new JComboBox<>(new String[]{" ",
                                                "1995",
                                                "1996",
                                                "1997",
                                                "1998",
                                                "1999",
                                                "2000",
                                                "2001",
                                                "2002",
                                                "2003",
                                                "2004",
                                                "2005",
                                                "2006",
                                                "2007",
                                                "2008",
                                                "2009",
                                                "2010"});
        DOB_year.setBounds(785,166,66,34);
        DOB_year.setBackground(Color.WHITE);
        DOB_year.setFont(new Font("Segoe UI", Font.PLAIN,16));
        
        Membership_day = new JComboBox<>(new String[]{" ",
                                               "1",
                                               "2",
                                               "3",
                                               "4",
                                               "5",
                                               "6",
                                               "7",
                                               "8",
                                               "9",
                                               "10",
                                               "11",
                                               "12",
                                               "13",
                                               "14",
                                               "15",
                                               "16",
                                               "17",
                                               "18",
                                               "19",
                                               "20",
                                               "21",
                                               "22",
                                               "23",
                                               "24",
                                               "25",
                                               "26",
                                               "27",
                                               "28",
                                               "29",
                                               "30",
                                               "31"});
        Membership_day.setBounds(642,476,46,34); 
        Membership_day.setBackground(Color.WHITE);
        Membership_day.setFont(new Font("Segoe UI", Font.PLAIN,16));
        
        Membership_month = new JComboBox<>(new String[]{" ",
                                                 "January",
                                                 "February",
                                                 "March",
                                                 "April",
                                                 "May",
                                                 "June",
                                                 "July",
                                                 "August",
                                                 "September",
                                                 "October",
                                                 "November",
                                                 "December"});
        Membership_month.setBounds(697,476,96,34);
        Membership_month.setBackground(Color.WHITE);
        Membership_month.setFont(new Font("Segoe UI", Font.PLAIN,16));
        
        Membership_year = new JComboBox<>(new String[]{" ",
                                                "1995",
                                                "1996",
                                                "1997",
                                                "1998",
                                                "1999",
                                                "2000",
                                                "2001",
                                                "2002",
                                                "2003",
                                                "2004",
                                                "2005",
                                                "2006",
                                                "2007",
                                                "2008",
                                                "2009",
                                                "2010"});
        Membership_year.setBounds(802,476,62,34);
        Membership_year.setBackground(Color.WHITE);
        Membership_year.setFont(new Font("Segoe UI", Font.PLAIN,16));
        
        Plan_box = new JComboBox<>(new String[]{" ",
                                                "Basic",
                                                "Standard",
                                                "Deluxe",
                                                "Premium Member"
                                                });
        Plan_box.setBounds(141,521,218,34);
        Plan_box.setBackground(Color.WHITE);
        Plan_box.setFont(new Font("Segoe UI", Font.PLAIN,16));
        Plan_box.addActionListener(this); 
        
        //adding left_panel radiobuttons
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(207,256,98,24);
        maleButton.setFont(new Font("Segoe UI", Font.PLAIN,20));
        maleButton.setBackground(Color.WHITE);
        
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(345,256,98,24);
        femaleButton.setFont(new Font("Segoe UI", Font.PLAIN,20));
        femaleButton.setBackground(Color.WHITE);
        
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        //adding buttons to left_panel
        
        display = new JButton("Display");
        display.setBounds(697,695,122,51);
        display.setFont(new Font("Segoe UI", Font.BOLD, 16));
        display.setBackground(Color.WHITE);
        display.setForeground(new Color(0x4D7D5B)); //changing text color
        display.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        display.setBorder(BorderFactory.createLineBorder(new Color(0x4D7D5B), 2, true)); //creates a border slightly rounded
        display.addActionListener(this);
        display.setFocusable(false);
        
        clear = new JButton("Clear");
        clear.setBounds(558,695,122,51);
        clear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        clear.setBackground(new Color(0xec4535));
        clear.setForeground(Color.WHITE);
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR)); //cursor change to hand
        clear.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        clear.addActionListener(this);
        clear.setFocusable(false);    
                
        addRegular = new JButton("Add Regular");
        addRegular.setBounds(88,695,150,51);
        addRegular.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addRegular.setBackground(new Color(0x4D7D5B));
        addRegular.setForeground(Color.WHITE);
        addRegular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addRegular.addActionListener(this);
        addRegular.setFocusable(false);
        
        addPremium = new JButton("Add to Premium");
        addPremium.setBounds(230,695,160,51);
        addPremium.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addPremium.setBackground(new Color(0x4D7D5B));
        addPremium.setForeground(Color.WHITE);
        addPremium.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPremium.addActionListener(this);
        addPremium.setFocusable(false);  
        
        save = new JButton("Save");
        save.setBounds(696,636,122,51);
        save.setFont(new Font("Segoe UI", Font.BOLD, 16));
        save.setBackground(Color.WHITE);
        save.setForeground(new Color(0x4D7D5B)); //changing text color
        save.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        save.setBorder(BorderFactory.createLineBorder(new Color(0x4D7D5B), 2, true)); //creates a border slightly rounded
        save.addActionListener(this);
        save.setFocusable(false);
        
        open = new JButton("Open");
        open.setBounds(557,636,122,51);
        open.setFont(new Font("Segoe UI", Font.BOLD, 16));
        open.setBackground(new Color(0x4D7D5B));
        open.setForeground(Color.WHITE); //changing text color
        open.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        open.setBorder(BorderFactory.createLineBorder(new Color(0x4D7D5B), 2, true)); //creates a border slightly rounded
        open.addActionListener(this);
        open.setFocusable(false);
        
        //adding to left_panel
        left_panel.add(Title);
        left_panel.add(Personal_details);
        left_panel.add(Firstname);
        left_panel.add(Firstname_field);
        left_panel.add(Lastname);
        left_panel.add(Lastname_field);
        left_panel.add(DOB);
        left_panel.add(DOB_day);
        left_panel.add(DOB_month);
        left_panel.add(DOB_year);
        left_panel.add(Location);
        left_panel.add(Location_field);
        left_panel.add(Gender);
        left_panel.add(maleButton);
        left_panel.add(femaleButton);
        left_panel.add(Phone);
        left_panel.add(Phone_field);
        left_panel.add(Email);
        left_panel.add(Email_field);
        left_panel.add(Referralsource_1);
        left_panel.add(Referralsource_1_field);
        
        left_panel.add(GymMembership_details);
        left_panel.add(ID_1);
        left_panel.add(ID_1_field);
        left_panel.add(Plan);
        left_panel.add(Plan_box);
        left_panel.add(Membership);
        left_panel.add(Membership_day);
        left_panel.add(Membership_month);
        left_panel.add(Membership_year);
        left_panel.add(Trainer);
        left_panel.add(Trainer_field);
        left_panel.add(Price);
        left_panel.add(Price_field);;
        left_panel.add(Referralsource_2);
        left_panel.add(Referralsource_2_field);
        left_panel.add(Removalreason);
        left_panel.add(Removalreason_field);
        
        left_panel.add(display);
        left_panel.add(clear);
        left_panel.add(addRegular);
        left_panel.add(addPremium);
        left_panel.add(save);
        left_panel.add(open);
        
        //RIGHT_PANEL
        
        //adding image
        
        image = new ImageIcon("../images/logo (1).jpg");
        
        //adding labels to right_panel
        
        imageLabel = new JLabel(image);
        imageLabel.setBounds(311,20,181,191);
        
        AlreadyMembership_details_1 = new JLabel("Have a Membership?");
        AlreadyMembership_details_1.setBounds(28,120,202,23);
        AlreadyMembership_details_1.setFont(new Font("Segoe UI",Font.BOLD,20));
        AlreadyMembership_details_1.setForeground(new Color(0xf2c957));
        
        AlreadyMembership_details_2 = new JLabel("Edit details here.");
        AlreadyMembership_details_2.setBounds(28,143,202,23);
        AlreadyMembership_details_2.setFont(new Font("Segoe UI",Font.BOLD,20));
        AlreadyMembership_details_2.setForeground(Color.WHITE);
        
        Fullname = new JLabel("Name:");
        Fullname.setBounds(53,180,130,34);
        Fullname.setFont(new Font("Segoe UI",Font.PLAIN,25));
        Fullname.setForeground(Color.WHITE);
        
        ID_2 = new JLabel("ID:");
        ID_2.setBounds(97,232,43,35);
        ID_2.setFont(new Font("Segoe UI",Font.PLAIN,25));
        ID_2.setForeground(Color.WHITE);
        
        Paidamount = new JLabel("Paid Amount:");
        Paidamount.setBounds(28,280,155,35);
        Paidamount.setFont(new Font("Segoe UI", Font.PLAIN,25));
        Paidamount.setForeground(Color.WHITE);
            
        de_activate_details = new JLabel("DE/ACTIVATE YOUR MEMBERSHIP");
        de_activate_details.setBounds(25,330,221,17);
        de_activate_details.setFont(new Font("Segoe UI",Font.BOLD,13));
        de_activate_details.setForeground(Color.WHITE);
        
        statusChange_details = new JLabel("CHANGE STATUS");
        statusChange_details.setBounds(25,442,277,19);
        statusChange_details.setFont(new Font("Segoe UI",Font.BOLD,13));
        statusChange_details.setForeground(Color.WHITE);
        
        attendance_details = new JLabel("ATTENDANCE");
        attendance_details.setBounds(25,542,277,19); 
        attendance_details.setFont(new Font("Segoe UI",Font.BOLD,13));
        attendance_details.setForeground(Color.WHITE);
        
        price_details = new JLabel("PRICE");
        price_details.setBounds(28,649,277,19); 
        price_details.setFont(new Font("Segoe UI",Font.BOLD,13));
        price_details.setForeground(Color.WHITE);
        
        //adding text fields to right_panel
        
        Fullname_field = new JTextField();
        Fullname_field.setBounds(133,182,197,29);
        
        ID_2_field = new JTextField();
        ID_2_field.setBounds(133,232,197,34);
        
        Paidamount_field = new JTextField();
        Paidamount_field.setBounds(192,280,139,34);
        Paidamount_field.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        
        //adding buttons to right_panel
        
        activateMembership = new JButton("Activate\n Membership");
        activateMembership.setBounds(49,361,181,60);
        activateMembership.setFont(new Font("Segoe UI", Font.BOLD, 16));
        activateMembership.setBackground(new Color(0x7DB581));
        activateMembership.setForeground(Color.WHITE); //changing text color
        activateMembership.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        activateMembership.setBorder(BorderFactory.createLineBorder(new Color(0x508053), 2, true));
        activateMembership.setFocusable(false);
        activateMembership.addActionListener(this);
        
        deactivateMembership = new JButton("Deactivate Membership");
        deactivateMembership.setBounds(259,361,191,60);
        deactivateMembership.setFont(new Font("Segoe UI", Font.BOLD, 16));
        deactivateMembership.setBackground(new Color(0xec4535));
        deactivateMembership.setForeground(Color.WHITE); //changing text color
        deactivateMembership.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        deactivateMembership.setBorder(BorderFactory.createLineBorder(new Color(0x4D7D5B), 2, true));
        deactivateMembership.setFocusable(false);
        deactivateMembership.addActionListener(this);

        //upgrade
        upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBounds(49,465,181,60);
        upgradePlan.setFont(new Font("Segoe UI", Font.BOLD, 16));
        upgradePlan.setBackground(new Color(0x7DB581));
        upgradePlan.setForeground(Color.WHITE); //changing text color
        upgradePlan.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        upgradePlan.setBorder(BorderFactory.createLineBorder(new Color(0x508053), 2, true));
        upgradePlan.setFocusable(false);
        upgradePlan.addActionListener(this);
        
        revertRegularMember = new JButton("Revert Regular");
        revertRegularMember.setBounds(259,465,181,60);
        revertRegularMember.setFont(new Font("Segoe UI", Font.BOLD, 16));
        revertRegularMember.setBackground(new Color(0xec4535));
        revertRegularMember.setForeground(Color.WHITE); //changing text color
        revertRegularMember.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        revertRegularMember.setBorder(BorderFactory.createLineBorder(new Color(0x508053), 2, true));
        revertRegularMember.setFocusable(false);
        revertRegularMember.addActionListener(this);
        
        revertPremiumMember = new JButton("Revert Premium");
        revertPremiumMember.setBounds(259,572,181,60);
        revertPremiumMember.setFont(new Font("Segoe UI", Font.BOLD, 16));
        revertPremiumMember.setBackground(new Color(0xec4535));
        revertPremiumMember.setForeground(Color.WHITE); //changing text color
        revertPremiumMember.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        revertPremiumMember.setBorder(BorderFactory.createLineBorder(new Color(0x508053), 2, true));
        revertPremiumMember.setFocusable(false);
        revertPremiumMember.addActionListener(this);
        
        markAttendance = new JButton("Mark Attendance");
        markAttendance.setBounds(49,571,181,60);
        markAttendance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        markAttendance.setBackground(new Color(0xec4535));
        markAttendance.setForeground(Color.WHITE); //changing text color
        markAttendance.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        markAttendance.setBorder(BorderFactory.createLineBorder(new Color(0x508053), 2, true));
        markAttendance.setFocusable(false);
        markAttendance.addActionListener(this);
        
        payDue = new JButton("Pay Due Amount");
        payDue.setBounds(49,678,181,60);
        payDue.setFont(new Font("Segoe UI", Font.BOLD, 16));
        payDue.setBackground(new Color(0xec4535));
        payDue.setForeground(Color.WHITE); //changing text color
        payDue.setCursor(new Cursor(Cursor.HAND_CURSOR)); //makes so cursor changes to hand on hover
        payDue.setBorder(BorderFactory.createLineBorder(new Color(0x508053), 2, true));
        payDue.setFocusable(false);
        payDue.addActionListener(this);
        
        discountButton = new JButton("Discount");
        discountButton.setBounds(259,678,181,60);
        discountButton.setFont(new Font("Segoe UI", Font.BOLD,16));
        discountButton.setBackground(new Color(0xec4535));
        discountButton.setForeground(Color.WHITE);
        discountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        discountButton.addActionListener(this);
        discountButton.setFocusable(false);   
        
        //adding to right_panel
        
        right_panel.add(AlreadyMembership_details_1);
        right_panel.add(AlreadyMembership_details_2);
        right_panel.add(Fullname);
        right_panel.add(Fullname_field);
        right_panel.add(ID_2);
        right_panel.add(ID_2_field);
        right_panel.add(Paidamount);
        right_panel.add(Paidamount_field);
        right_panel.add(de_activate_details);
        right_panel.add(activateMembership);
        right_panel.add(deactivateMembership);
        right_panel.add(statusChange_details);
        right_panel.add(upgradePlan);
        right_panel.add(revertRegularMember);
        right_panel.add(revertPremiumMember);
        right_panel.add(attendance_details);
        right_panel.add(markAttendance);
        right_panel.add(imageLabel);  
        right_panel.add(price_details);
        right_panel.add(payDue);
        right_panel.add(discountButton);
        
        //adding panel->frame
        frame.add(left_panel);
        frame.add(right_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //these should be in order for it to work
        frame.setSize(1440,800);
        frame.setLocationRelativeTo(null); //on running it centers it
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    //overriding for the actionlistener
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //for plan,price,discount 
        String selectedPlan = (String) Plan_box.getSelectedItem(); //gets the item from planbox
        
        switch (selectedPlan)
        {
            case "Basic":
                Price_field.setText("6500");
                break;
            case "Standard":
                Price_field.setText("12500");
                break;
            case "Deluxe":
                Price_field.setText("18500");
                break;
            case "Premium Member":
                Price_field.setText("50000");
                break;
            default:
                Price_field.setText("");  // Clear Price_field if no plan is selected or invalid option
                break;
        }
        
        //defining for submit, regular and premium
        String idtext1 = ID_1_field.getText(); //for new member creations
        String idtext2 = ID_2_field.getText(); //for the buttons
        String firstname = Firstname_field.getText();
        String lastname = Lastname_field.getText();
        String fullname = firstname +" "+ lastname; //combiging to one
            
        String gender="";
        if (maleButton.isSelected())
        {
            gender = "Male";
        }
        else if (femaleButton.isSelected())
        {
            gender = "Female";
        }
            
        String location = Location_field.getText();
        String phone = Phone_field.getText();
        String email = Email_field.getText();
        String DOB = DOB_day.getSelectedItem() +"/"+ DOB_month.getSelectedItem() +"/"+ DOB_year.getSelectedItem();
        String startdate = Membership_day.getSelectedItem() +"/"+ Membership_month.getSelectedItem() +"/"+ Membership_year.getSelectedItem();
        
        //in default, setting found as false and defining membershipID
        boolean found = false;
        String removal_reason = Removalreason_field.getText();
        String membership_type = (String) Plan_box.getSelectedItem(); //gets the string "Regular" or "Premium"
        
        int id = 0; //by default 0
        int membershipId= -1; //we're setting it as -1 so that it skips a block and it doesn;t collide with other try catches
        
        //adding a numberformat exception
        try{
            if(!idtext1.isEmpty())
            {
                id = Integer.parseInt(idtext1);
            }
            
            if(!idtext2.isEmpty())
            {
                membershipId = Integer.parseInt(idtext2);
            }
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(frame,"Please enter a valid ID.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
                
        //for adding to regular 
        if (e.getSource() == addRegular)
        {
            if(Firstname_field.getText().isEmpty() || Lastname_field.getText().isEmpty() ||
            Phone_field.getText().isEmpty() || Email_field.getText().isEmpty() ||
            DOB_day.getSelectedIndex() == 0 || DOB_month.getSelectedIndex() == 0)
            {
                JOptionPane.showMessageDialog(frame, "Please fill all personal details");
                return;
            }
            
            boolean exists = false; //declearing a new bool var
            for(GymMember m: members)
            {
                if(m.getId() == id)
                {
                    exists = true;
                    break;
                }
            }
            
            if(!exists)
            {
                //since regular member needs referral in constructor
                String referral = Referralsource_1_field.getText();
                
                RegularMember r = new RegularMember(id, fullname, location, phone, email, gender, DOB, startdate, referral);
                //RegularMember r = new RegularMember(id, gender, gender, fullname, email, location, DOB, startdate, referral);
                members.add(r); //adding that instance object to members list
                JOptionPane.showMessageDialog(frame, "Regular Member Added.");
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Member's ID already exists.");
            }
        }
        
        //same for the add to premium button
        
        if(e.getSource() == addPremium)
        {
            if(Firstname_field.getText().isEmpty() || Lastname_field.getText().isEmpty() ||
            Phone_field.getText().isEmpty() || Email_field.getText().isEmpty() ||
            DOB_day.getSelectedIndex() == 0 || DOB_month.getSelectedIndex() == 0 || Trainer_field.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frame, "Please fill all personal and trainer details.");
                return;
            }
            
            boolean exists = false;
            
            for(GymMember m: members)
            {
                if(m.getId() == id)
                {
                    exists = true;
                    break;
                }
            }
            
            if(!exists)
            {
                //trainer is mandatory for premium
                String trainer = Trainer_field.getText();
                PremiumMember p = new PremiumMember(id, fullname, location, phone, email, gender, DOB, startdate, trainer);
                members.add(p); //added premium member to arraylist
                JOptionPane.showMessageDialog(frame, "Premium Member added.");
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Members ID already exists");
            }
        }
        
        //for the upgrade button
        
        if(e.getSource() == upgradePlan)
        {
            for(GymMember m: members)
            {
                if(m.getId() == membershipId)
                {
                    found = true;
                    if(m instanceof RegularMember && m.isActive())
                    {
                        RegularMember r = (RegularMember) m; //casting of regular member to the member list
                        //String selectedPlanToUpgrade = (String) Plan_box.getSelectedItem();
                        //String message = r.upgradePlan(selectedPlanToUpgrade);
                        
                        String message = r.upgradePlan();
                        JOptionPane.showMessageDialog(frame, message);
                        return; //gets out after upgrade
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"Only active members can upgrade");
                        return; 
                    }
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }
        
        if(e.getSource() == discountButton)
        {
            for(GymMember m: members)
            {
                if(m.getId() == membershipId && m instanceof PremiumMember || m instanceof RegularMember)
                {
                    found = true;
                    PremiumMember p = (PremiumMember) m; //letting p access premium member's classes
                    p.calculateDiscount();
                    
                    //for the if conditions, declaring a discount
                    double discount = p.getDiscountAmount();                    
                    if(discount > 0)
                    {
                        JOptionPane.showMessageDialog(frame, "Discount applied: "+discount);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "There are no discounts available for you. Please pay the membership fee first.");
                    }
                    
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Member not eligible for discounts.");
                    return;
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }
        
        //for revert buttons
        
        if(e.getSource() == revertRegularMember)
        {
            for (GymMember m: members)
            {
                if(m.getId() == membershipId && m instanceof RegularMember)
                {
                    found = true;
                    //we first need to remove that id from premium and add to regular
                    String reason = Removalreason_field.getText();
                    if(reason.isEmpty()== true)
                    {
                        JOptionPane.showMessageDialog(frame,"Enter a proper removal reason.");
                        return;
                    }
                    else{
                        RegularMember r = (RegularMember) m;
                        r.revertRegularMember(reason);
                        
                        JOptionPane.showMessageDialog(frame, "Reverted to Regular Member");
                    }
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }
        
        if(e.getSource() == revertPremiumMember)
        {
            for (GymMember m: members)
            {
                if(m.getId() == membershipId && m instanceof PremiumMember)
                {
                    found = true;
                    PremiumMember p = (PremiumMember) m;
                    p.revertPremiumMember();
                    JOptionPane.showMessageDialog(frame,"Reverted to Premium Member");
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }
        
        //for clear button
        if (e.getSource() == clear)
        {
            //for labels
            
            Firstname_field.setText("");
            Lastname_field.setText("");
            Location_field.setText("");
            Phone_field.setText("");
            Email_field.setText("");
            Referralsource_1_field.setText("");
            ID_1_field.setText("");
            Paidamount_field.setText("");
            Referralsource_2_field.setText("");
            Removalreason_field.setText("");
            Trainer_field.setText("");
            
            //for radiobuttons
            genderGroup.clearSelection();
            
            //for comboboxes
            DOB_day.setSelectedIndex(0);
            DOB_month.setSelectedIndex(0);
            DOB_year.setSelectedIndex(0);
            Membership_day.setSelectedIndex(0);
            Membership_month.setSelectedIndex(0);
            Membership_year.setSelectedIndex(0);
            Plan_box.setSelectedIndex(0);
        }
        
        //for display button
        if(e.getSource() == display)
        {
            JFrame displayframe = new JFrame("Member details");
            displayframe.setSize(600,500);
            displayframe.setLocationRelativeTo(null); //keeps it centered
            displayframe.setLayout(null);
            displayframe.getContentPane().setBackground(new Color(0x4D7D5B)); //background color
            displayframe.setResizable(false);
            
            //adding a white panel
            JPanel whitepanel = new JPanel();
            whitepanel.setBackground(Color.WHITE);
            whitepanel.setLayout(null);
            whitepanel.setBounds(62,51,477,398);
            
            //the title
            JLabel displaytitle = new JLabel("Member Details");
            displaytitle.setFont(new Font("Arial", Font.BOLD,24));
            displaytitle.setForeground(Color.WHITE);
            displaytitle.setBounds(195,5,212,54);

            displayframe.add(displaytitle); //adding the title to frame
            
            //textarea to print eveerything
            JTextArea displayarea = new JTextArea();
            displayarea.setEditable(false); //no changes can be made
            displayarea.setFont(new Font("Arial",Font.PLAIN,18));
            displayarea.setForeground(Color.BLACK);
            
            //adding a loop to go through everything and print inside textarea
            String allMembers = "";
            for(GymMember member : members)
            {
                allMembers = allMembers + member + "\n";
            }
            displayarea.setText(allMembers); //adding to textarea
            
            //setting a scroll 
            JScrollPane scroll = new JScrollPane(displayarea); //for textarea
            scroll.setBounds(10,10,457,320);
            whitepanel.add(scroll); //adding to whitepanel
            
            displayframe.add(whitepanel);
            displayframe.setVisible(true); //can see
        }
        
        //for the activate Membership button
        if(e.getSource() == activateMembership)
        {   
            for(GymMember member:members) //runs through all the arraylist
            {
                if(membershipId == member.getId()) //checks if ids are equal from arraylist and textfield
                {
                    found = true;
                    member.activateMembership();
                    boolean activate_status = true;
                    JOptionPane.showMessageDialog(frame,"Membership activated successfully.");
                    
                    if(activate_status)
                    {
                        deactivateMembership.setEnabled(true); 
                        revertRegularMember.setEnabled(true);
                        revertPremiumMember.setEnabled(true);
                        markAttendance.setEnabled(true);
                    }
                }
                else{
                    System.out.println("That membership ID does not exist");
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }   
    
        
        //for deactivating membership
        if(e.getSource()==deactivateMembership)
        {
            boolean deactivate_state=false; //defining it false for it to be used later
            
            for(GymMember member:members)
            {
                if(membershipId == member.getId())
                {
                    found = true;
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(frame,"Membership deactivated successfully");
                    deactivate_state = true;
                    
                    if(deactivate_state == true) //once it's true we're disabling every other button because membership deactivated
                    {
                        deactivateMembership.setEnabled(false); 
                        revertRegularMember.setEnabled(false);
                        revertPremiumMember.setEnabled(false);
                        markAttendance.setEnabled(false);
                    }
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }
        
        //paying due amount
        
        if(e.getSource() == payDue)
        {
            for(GymMember m: members)
            {
                if(m.getId() == membershipId && (m instanceof PremiumMember || m instanceof RegularMember))
                {
                    found = true;
                    PremiumMember p = (PremiumMember) m;
                    
                    //to handle number exception in paid amount
                    try
                    {
                        //same as Integer.parseInterger(); to change into Int
                        double amount = Double.parseDouble(Paidamount_field.getText());
                        
                        String message = p.payDueAmount(amount);
                        JOptionPane.showMessageDialog(frame, message);
                        return;
                    }
                    catch(NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(frame,"Please enter a valid amount.");
                        return;
                    }
                }
            }
            if (!found)
            {
                JOptionPane.showMessageDialog(frame, "Member not found");
            }
        }
                        
        if(e.getSource() == save)
        {
            try{
                FileWriter f = new FileWriter("MembershipDetails.txt",true);
                /*
                f.write(String.format("%-5s %-25s %-12s %-12s %-20s %-20s %-17s %-12s %-11s %-13s %-11s %-15s %-17s %-15s\n",
                                        "ID", "Name", "Location", "Phone", "Email", "Start Date", "Plan", "Price",
                                        "Attendance", "LoyaltyPts", "Status", "FullPayment", "DiscountAmt", "AmountPaid"));
                
                f.write("ID: \n");
                f.write("Name: \n");
                f.write("Location: \n");
                f.write("Phone: \n");
                f.write("Email: \n");
                f.write("Start Date: \n");
                f.write("Plan: \n");
                f.write("Price: \n");
                f.write("Attendance: \n");
                f.write("Loyalty Points: \n");
                f.write("Status: \n");
                f.write("FullPayment: \n");
                f.write("Discount Amount: \n");
                f.write("Amount paid: \n");
                 */
                String active_status;
                
                if (isActive() == true)
                {
                    active_status= "Enabled";
                }
                else
                {
                    active_status = "Disabled";
                }
                
                for(GymMember m: members)
                {
                    if (m instanceof RegularMember)
                    {
                        RegularMember r = (RegularMember) m;
                        f.write("ID: " + r.getId() + "\n");
                        f.write("Name: " + r.getName() + "\n");
                        f.write("Location: " + r.getLocation() + "\n");
                        f.write("Phone: "+ r.getPhone() + "\n");
                        f.write("Email: " + r.getEmail() + "\n");
                        f.write("Start Date: " + r.getMembershipStartDate() + "\n");
                        f.write("Plan: " + r.getPlan() + "\n");
                        f.write("Price: " + r.getPrice() + "\n");
                        f.write("Attendance: " + r.getAttendance() + "\n");
                        f.write("Loyalty Points: " + r.getLoyaltyPoints() + "\n");
                        f.write("Status: " + active_status + "\n");
                        f.write("FullPayment: " + "N/A" + "\n");
                        f.write("Discount Amount: " + "N/A" + "\n");
                        f.write("Amount paid: " + "N/A" + "\n");
                    }
                    else if(m instanceof PremiumMember)
                    {
                        PremiumMember p = (PremiumMember) m;
                        /*
                        f.write(String.format("%-5d %-25s %-12s %-12s %-20s %-20s %-17s %-12.2f %-11d %-13.1f %-11s %-15.2f %-17.2f %-15.2f\n",
                                              p.getId(),p.getName(),p.getLocation(),p.getPhone(),p.getEmail(),p.getMembershipStartDate(),"Premium Member","Rs.50,000",p.getAttendance(),p.getLoyaltyPoints(),p.isActive(),p.getIsFullPayment(),p.getDiscountAmount(),"N/A"));
                        */
                       
                        f.write("ID: " + p.getId() + "\n");
                        f.write("Name: " + p.getName() + "\n");
                        f.write("Location: " + p.getLocation() + "\n");
                        f.write("Phone: "+ p.getPhone() + "\n");
                        f.write("Email: " + p.getEmail() + "\n");
                        f.write("Start Date: " + p.getMembershipStartDate() + "\n");
                        f.write("Plan: " + "Premium" + "\n");
                        f.write("Price: " + "Rs.50,000" + "\n");
                        f.write("Attendance: " + p.getAttendance() + "\n");
                        f.write("Loyalty Points: " + p.getLoyaltyPoints() + "\n");
                        f.write("Status: " + active_status + "\n");
                        f.write("FullPayment: " + p.getIsFullPayment() + "\n");
                        f.write("Discount Amount: " + p.getDiscountAmount() + "\n");
                        f.write("Amount paid: " + p.getPaidAmount() + "\n");
                    }   
                }
                
                f.close();
                JOptionPane.showMessageDialog(frame, "File saved successfully.");
            }
            catch (IOException ex) //just basic Input output exception
            {
                JOptionPane.showMessageDialog(frame,"File couldn't be saved.");
            }
        }     
        
        //for open
        if(e.getSource() == open)
        {
            JFrame displayframe = new JFrame("Member details");
            displayframe.setSize(600,500);
            displayframe.setLocationRelativeTo(null); //keeps it centered
            displayframe.setLayout(null);
            displayframe.getContentPane().setBackground(new Color(0x4D7D5B)); //background color
            displayframe.setResizable(false);
            
            //adding a white panel
            JPanel whitepanel = new JPanel();
            whitepanel.setBackground(Color.WHITE);
            whitepanel.setLayout(null);
            whitepanel.setBounds(62,51,477,398);
            
            //the title
            JLabel displaytitle = new JLabel("Member Details");
            displaytitle.setFont(new Font("Arial", Font.BOLD,24));
            displaytitle.setForeground(Color.WHITE);
            displaytitle.setBounds(195,5,212,54);

            displayframe.add(displaytitle); //adding the title to frame
            
            //textarea to print eveerything
            JTextArea displayarea = new JTextArea();
            displayarea.setEditable(false); //no changes can be made
            displayarea.setFont(new Font("Monospace",Font.PLAIN,18));
            displayarea.setForeground(Color.BLACK);
            
            //reading now
            
            try
            {
                FileReader reader = new FileReader("MembershipDetails.txt");
                String readdata = "";
                int ch;
                
                while((ch = reader.read()) != -1) // goes to the end of file
                {
                    readdata = readdata + (char) ch; //changes to character again and add to "" of readdata
                }
                
                reader.close();
                displayarea.setText(readdata); //add to text area
            }
            catch(IOException ex)
            {
                displayarea.setText("Error reading the file.");
            }
            
            //setting a scroll 
            JScrollPane scroll = new JScrollPane(displayarea); //for textarea
            scroll.setBounds(10,10,457,320);
            whitepanel.add(scroll); //adding to whitepanel
            
            displayframe.add(whitepanel);
            displayframe.setVisible(true); //can see
        }
        
        
        //for mark attendance button
        if (e.getSource() == markAttendance)
        {
            for(GymMember m: members)
            {
                if(m.getId() == membershipId)
                {
                    found = true;
                    if (m.isActive() == false)
                    {
                        JOptionPane.showMessageDialog(frame, "Membership is not active, please activate first and then mark attendance.");
                        return;
                    }
                    else
                    {
                        m.markAttendance();
                        JOptionPane.showMessageDialog(frame,"Attendance has been marked.");
                        break;
                    }
                }
                
                if(found == false)
                {
                    JOptionPane.showMessageDialog(frame,"There is no member with that ID");
                }
            }
        }
    }
}