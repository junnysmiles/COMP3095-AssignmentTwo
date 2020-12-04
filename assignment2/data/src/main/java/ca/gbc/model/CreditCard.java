/*******************************************************************************************************************
 * Project: A Team
 * Assignment: 3
 * Author(s): Nicholas Chinsen, Joel Max Abramson, Jun-Yan Gan, Stefan Maric, Kevin Silva
 * Student Number: 101075596, 101165088, 101197834, 101208175, 101210892
 * Date: 28/11/2020 -Nick created file
 * Description: Users can have zero to many credit cards carddtype is an enum
 * ****************************************************************************************************************/
package ca.gbc.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private CardType cardType;

    @NotNull(message = "The Expiration month cannot be null")
    @Max(value = 12, message = "Expiration Month can't be higher than 12")
    @Min(value = 1, message = "Expiration Month can't be lower than 1")
    private Integer expirationMonth;

    @Max(value = 2030, message = "Expiration year must be less than 2030")
    @Min(value = 2020, message = "Expiration year can't be in the past")
    @NotNull(message = "The Expiration year cannot be null")
    private Integer expirationYear;

    @NotNull(message = "The Cardholder name cannot be null")
    private String cardholderName;

    @NotNull(message = "The Card Number cannot be null")
    private Long CCNumber;
    private Boolean defaultCC;

    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public Long getCCNumber() {
        return CCNumber;
    }

    public void setCCNumber(Long CCNumber) {
        this.CCNumber = CCNumber;
    }

    public Boolean getDefaultCC() {
        return defaultCC;
    }

    public void setDefaultCC(Boolean defaultCC) {
        this.defaultCC = defaultCC;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
