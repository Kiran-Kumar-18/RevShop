package com.revshop.service;

import com.revshop.dao.IPasswordRecoveryDAOImpl;
import com.revshop.model.PasswordRecovery;

public class PasswordRecoveryService
        implements IPasswordRecoveryServiceImpl {

    private final IPasswordRecoveryDAOImpl dao =
            new PasswordRecoveryDAO();

    @Override
    public String getSecurityQuestion(String email) {

        PasswordRecovery pr = dao.findByEmail(email);

        if (pr == null) {
            return null;
        }

        return pr.getSecurityQuestion();
    }

    @Override
    public boolean validateAnswer(String email, String answer) {

        PasswordRecovery pr = dao.findByEmail(email);

        if (pr == null) {
            return false;
        }

        return dao.verifySecurityAnswer(pr.getUserId(), answer);
    }
    @Override
    public boolean resetPassword(String email, String newPassword) {

        if (!isStrongPassword(newPassword)) {
            return false;
        }

        PasswordRecovery pr = dao.findByEmail(email);
        if (pr == null) return false;

        return dao.resetPassword(pr.getUserId(), newPassword);
    }

    private boolean isStrongPassword(String password) {
        return password.length() >= 6;
    }


}
