/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 29/11/2020 -Nick created file
 * Description: Holds Date of Birth Info for users
 * ****************************************************************************************************************/
package ca.gbc.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class Dob {
    @Pattern(regexp = "^[0-9]*$", message = "Day must be a number")
    private Integer day;
    @Pattern(regexp = "^[0-9]*$", message = "Month must be a number")
    private Integer month;
    @Pattern(regexp = "^[0-9]*$", message = "Year must be a number")
    private Integer year;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
