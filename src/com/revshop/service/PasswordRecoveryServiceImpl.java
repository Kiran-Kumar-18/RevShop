package com.revshop.service;

import com.revshop.dao.IPasswordRecoveryDAO;
import com.revshop.dao.PasswordRecoveryDAOImpl;
import com.revshop.model.PasswordRecovery;

public class PasswordRecoveryServiceImpl
        implements IPasswordRecoveryService {

    private IPasswordRecoveryDAO dao = new PasswordRecoveryDAOImpl();

    @Override
    public boolean recoverPassword(String email) {
        return dao.recoverPassword(email);
    }

    @Override
    public String getSecurityQuestion(String email) {
        PasswordRecovery pr = dao.findByEmail(email);
        return (pr != null) ? pr.getSecurityQuestion() : null;
    }

    @Override
    public boolean validateAnswer(String email, String answer) {
        PasswordRecovery pr = dao.findByEmail(email);
        return pr != null && dao.verifySecurityAnswer(pr.getUserId(), answer);
    }

    @Override
    public boolean resetPassword(String email, String newPassword) {
        if (newPassword.length() < 6) return false;

        PasswordRecovery pr = dao.findByEmail(email);
        return pr != null && dao.resetPassword(pr.getUserId(), newPassword);
    }
}
