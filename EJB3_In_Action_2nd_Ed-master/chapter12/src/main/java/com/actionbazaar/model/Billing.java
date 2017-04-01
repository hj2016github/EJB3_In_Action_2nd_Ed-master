/**
 *  Billing.java
 *  EJB 3 in Action
 *  Book: http://manning.com/panda2/
 *  Code: http://code.google.com/p/action-bazaar/
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.actionbazaar.model;

import com.actionbazaar.account.Address;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Billing information
 */
@Entity
@Table(name="BILLING_INFO")
public class Billing implements Serializable {

    @Id
    @Column(name="BILLING_USER_ID")
    protected Long userId;
    

    /**
     * Account number
     */
    protected String accountNumber;

    /**
     * Expiration date on the account
     */
    protected String expiryDate;

    /**
     * Security code on the card
     */
    protected String secretCode;

    /**
     * Address associated with the card
     */
    protected Address address;

    /**
     * Returns the account number
     * @return account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the expiration date
     * @return expiration date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Returns the secret code
     * @return secret code
     */
    public String getSecretCode() {
        return secretCode;
    }

    /**
     * Returns the address
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the account number
     * @param accountNumber - account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Sets the expiration date
     * @param expiryDate - expiration date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Sets the secret code
     * @param secretCode - secret code
     */
    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * Sets the address
     * @param address - address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
