package com.sid.Fort.ForgotPassword.DTO;

public class ResetPassword {
    private String tocken;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    @Override
    public String toString() {
        return "resetpassword{" +
                "tocken='" + tocken + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
