package model;

import java.util.Random;

public class Account {
    private String firstName;
    private String lastName;
    private String country;
    private String state;
    private String email;
    private String desiredPassword;
    private String confirmPassword;


    public Account(AccountBuilder accountBuilder) {
        this.firstName = accountBuilder.firstName;
        this.lastName = accountBuilder.lastName;
        this.country = accountBuilder.country;
        this.state = accountBuilder.state;
        this.email = accountBuilder.email;
        this.desiredPassword = accountBuilder.desiredPassword;
        this.confirmPassword = accountBuilder.confirmPassword;
    }

    public Account() {
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public String getDesiredPassword() {
        return desiredPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesiredPassword(String desiredPassword) {
        this.desiredPassword = desiredPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String changeMailIndex(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVW";
        String fullString = alphabet.toLowerCase() + "0123456789";
        //System.out.println(fullString);
        Random rn = new Random();
        String stringRandom = "";
        int length = 4;
        for (int i = 0; i < length-1; i++) {
            stringRandom = stringRandom + fullString.charAt(rn.nextInt(fullString.length()));
        }
        return stringRandom;
    }

    public static class AccountBuilder {
        private String firstName;
        private String lastName;
        private String country;
        private String state;
        private String email;
        private String desiredPassword;
        private String confirmPassword;

        public AccountBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AccountBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AccountBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AccountBuilder state(String state) {
            this.state = state;
            return this;
        }

        public AccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder desiredPassword(String desiredPassword) {
            this.desiredPassword = desiredPassword;
            return this;
        }

        public AccountBuilder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Account createAccount() {
            return new Account(this);
        }

    }
}
