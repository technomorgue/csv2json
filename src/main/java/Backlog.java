import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Backlog {
    private String project_code;
    private String project_name;
    private String[] year;
    private String project_start_date;
    private String project_end_date;
    private String company;
    private String du_name;
    private String customer;
    private String account_type;
    private String delivery_partner;
    private String project_manager;
    private String business_type;
    private String domain;
    private HashSet<Revenue> revenue = new HashSet<>(); // Using hashset to ensure no duplicates

    public Backlog(HashMap<String, String> map) {
        this.project_code = map.get("Project Code");
        this.project_name= map.get("Project Name");
        this.year= map.get("Year").split("-");
        this.project_start_date= map.get("Project Start Date");
        this.project_end_date= map.get("Project End Date");
        this.company= map.get("Company");
        this.du_name= map.get("DU Name");
        this.customer= map.get("Customer");
        this.account_type= map.get("Account Type");
        this.delivery_partner = map.get("Delivery Partner");
        this.project_manager= map.get("Project Manager");
        this.business_type= map.get("Business Type");
        this.domain= map.get("Domain");

        String[] calendarMonths = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};

        for(String revMonth: calendarMonths){
            String[] nextYearMonths = {"January", "February", "March"};
            String revYear = Arrays.asList(nextYearMonths).contains(revMonth) ? "20"+(year[1]) : year[0];
            String bookedValue = map.get(revMonth+" Booked Revenue");
            String recognizedValue = map.get(revMonth+" Recognized Revenue");

            float booked_amount = Objects.equals(bookedValue, "") ? 0 : Float.parseFloat(bookedValue);
            float recognized_amount = Objects.equals(recognizedValue, "") ? 0 : Float.parseFloat(recognizedValue);

            Revenue revenueRecord = new Revenue(revMonth, revYear,booked_amount, recognized_amount,"USD",false,
                    false);

            // Add revenue record to Revenue HashSet
            revenue.add(revenueRecord);
        }
    }
}

class Revenue {
    private String year;
    private String month;
    private float booked_amount;
    private float recognized_amount;
    private String currency;
    private boolean invoiced;
    private boolean recognized;

    public Revenue(String month, String year, float booked_amount, float recognized_amount, String currency,
                   boolean invoiced, boolean recognized){
        this.year = year;
        this.month = month;
        this.booked_amount = booked_amount;
        this.recognized_amount = recognized_amount;
        this.currency = currency;
        this.invoiced = invoiced;
        this.recognized = recognized;
    }
}

