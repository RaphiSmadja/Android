package com.raphaelsmadja.tpperssistance;

/**
 * Created by raphi on 23/10/2017.
 */

public class Student {
    public static final String TABLE_NAME="STUDENT";
    public static final String COL_ID="_ID";
    public static final String COL_LAST_NAME="LAST_NAME";
    public static final String COL_FIRST_NAME="FIRST_NAME";
    public static final String CREATE_TABLE="CREATE TABLE"+TABLE_NAME
            +" ( "+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_LAST_NAME+ " VARCHAR, "
            + COL_FIRST_NAME+ " VARCHAR )";


    private long id;
    private String firstName;
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
