package ecommerce.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecommerce.demo.exceptions.LoginException;
import ecommerce.demo.model.Admin;
import ecommerce.demo.model.CurrentUserSession;
import ecommerce.demo.model.LoginDTO;
import ecommerce.demo.repository.AdminDao;
import ecommerce.demo.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

    @Autowired
    private AdminDao aDao;

    @Autowired
    private SessionDao sDao;

    @Override
    public String logIntoAccount(LoginDTO dto)throws LoginException{
        Admin existingAdmin= aDao.findByMobileNumber(dto.getMobileNumber());
        if(existingAdmin == null) {
            throw new LoginException("Please Enter a valid mobile number");
        }
        Optional<CurrentUserSession> validAdminSessionOpt =  sDao.findById(existingAdmin.getAdminId());
        if(validAdminSessionOpt.isPresent()) {
            throw new LoginException("User already Logged In with this number");
        }
        if(existingAdmin.getPassword().equals(dto.getPassword())) {
            String key= RandomString.make(6);
            CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
            sDao.save(currentUserSession);
            return currentUserSession.toString();
        }
        else
            throw new LoginException("Please Enter a valid password");
    }

    @Override
    public String logOutFromAccount(String key)throws LoginException {
        CurrentUserSession validDriverSession = sDao.findByUuid(key);
        if(validDriverSession == null) {
            throw new LoginException("User Not Logged In with this number");
        }
        sDao.delete(validDriverSession);
        return "Logged Out !";
    }
}
