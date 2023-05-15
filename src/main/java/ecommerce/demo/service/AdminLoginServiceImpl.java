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

public class AdminLoginServiceImpl {
}
