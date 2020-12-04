/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 25/11/2020 -Nick created file
 * Description: User entity according to ERM uses java validation
 * ****************************************************************************************************************/
package ca.gbc.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @Pattern(regexp="[A-Za-z]+$", message="First Name must contain letters")
    @NotNull(message = "First Name cannot be empty")
    private String firstName;
    @Pattern(regexp="[A-Za-z]+$", message="Last Name must contain letters")
    @NotNull(message = "Last Name cannot be empty")
    private String lastName;
    @Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,128}$",
    message = "Password must be between 6-12 chars and contain 1 uppercase letter and 1 special character")
    private String password;
    private LocalDate lastLogin;
    private LocalDate lastUpdate;
    private LocalDate accountCreated;

    //DOB information
    @NotBlank(message = "Day cannot be empty")
    private String day;
    @NotBlank(message = "Month cannot be empty")
    private String month;
    @NotBlank(message = "Year cannot be empty")
    private String year;

    //address information
    @NotBlank(message = "Street cannot be empty")
    private String streetName;
    @Pattern(regexp = "^[A-Za-z]+$", message = "City can only contain letters")
    private String city;
    @Pattern(regexp = "[A-Za-z]+$", message = "Country can only contain letters")
    private String country;
    @NotBlank(message = "Postal cannot be empty")
    private String postal;

    @ManyToMany
    private Set<Ticket> tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDate getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(LocalDate accountCreated) {
        this.accountCreated = accountCreated;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

}

