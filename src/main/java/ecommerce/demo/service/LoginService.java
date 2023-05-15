package ecommerce.demo.service;

import ecommerce.demo.exceptions.LoginException;
import ecommerce.demo.model.LoginDTO;
public interface LoginService {

    public String logIntoAccount(LoginDTO dto)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;

}
