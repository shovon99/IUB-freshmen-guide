package com.hasib.drawer.navigationdrawermikepenz;

/**
 * Created by hasib on 11/29/17.
 */

public class Courses {
    String courseID;
    double gpa;
    int credit;


    public Courses ()
    {

    }

    public Courses(String id, double GPA, int cr)
    {
        this.courseID=id;
        this.gpa = GPA;
        this.credit = cr;
    }
}
