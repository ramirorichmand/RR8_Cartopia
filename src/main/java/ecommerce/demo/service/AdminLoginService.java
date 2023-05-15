package ecommerce.demo.service;

import ecommerce.demo.exceptions.LoginException;
import ecommerce.demo.model.LoginDTO;

public interface AdminLoginService {

    public String logIntoAccount(LoginDTO dto)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;

}
