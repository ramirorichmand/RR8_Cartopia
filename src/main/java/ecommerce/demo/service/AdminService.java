package ecommerce.demo.service;

import java.util.List;

import ecommerce.demo.exceptions.AdminException;

import ecommerce.demo.model.Admin;


public interface AdminService {
    public Admin createAdmin(Admin Admin)throws AdminException;

    public  Admin updateAdmin(Admin Admin,String key)throws AdminException;

    public String deleteAdmin(Integer adminId,String key) throws AdminException;

}
