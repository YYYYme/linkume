package com.cn.linkume.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cn.linkume.pojo.User;
import com.cn.linkume.service.DemoService;

public class DemoServiceImpl implements DemoService {  
	  
    public String sayHello(String name) {  
        return "Hello " + name;  
    }  
  
    public List getUsers() {  
        List list = new ArrayList();  
        User u1 = new User();  
        u1.setUserName("hejingyuan");  
        u1.setAge(20);  
  
        User u2 = new User();  
        u2.setUserName("xvshu");  
        u2.setAge(21);  
  
          
        list.add(u1);  
        list.add(u2);  
          
        return list;  
    }  
}  