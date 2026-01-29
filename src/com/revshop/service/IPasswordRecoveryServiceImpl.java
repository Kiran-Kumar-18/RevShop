package com.revshop.service;

public interface IPasswordRecoveryServiceImpl {

    String getSecurityQuestion(String email);

    boolean validateAnswer(String email, String answer);
    boolean resetPassword(String email, String newPassword);

}
