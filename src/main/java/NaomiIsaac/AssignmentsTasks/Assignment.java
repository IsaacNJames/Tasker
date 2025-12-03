package NaomiIsaac.AssignmentsTasks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignments")
public class Assignment {

    //pkey
    @Id
    @GeneratedValue
    @Column(name = "pkey")
    private Integer primaryKey; //Primary key for our database, generated dy h2

    @Column(name = "aname")
    private String aname;

    @Column(name = "cname")
    private String cname;

    @Column(name = "desc")
    private String desc;

    @Column(name="ddate")
    private String ddate;

    @Column(name="priority")
    private String priority;

    @Column(name="completed")
    private boolean completed = false;


    //Getters and setters
    
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDdate() {
        return ddate;
    }
    public void setDdate(String ddate) { 
        this.ddate = ddate;
    }

    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString(){ // This is more for debugging then anything else, end user does not see it
        return "Assignment: " + aname + "\nClass:" + cname + "\nDescription :" + desc + "\nDue Date: " + ddate + "\nPriority :" + priority;
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }
}
