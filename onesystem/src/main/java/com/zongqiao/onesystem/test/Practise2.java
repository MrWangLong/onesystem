package com.zongqiao.onesystem.test;

import java.util.ArrayList;
import java.util.List;

import com.zongqiao.onesystem.domain.User;

public class Practise2 {
	public static void main(String[] args) { 
		
	User user1 = new User();
	user1.setUserId(1001);
	user1.setUserName("江可星");
	User user2 = new User();
	user2.setUserId(1002);
	user2.setUserName("王龙");
	User user3 = new User();
	user3.setUserId(1003);
	user3.setUserName("猪八戒");
    List<User> list=new ArrayList<>();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    List<String> nameList=new ArrayList<>();
    for(int i=0;i<list.size();i++){
    	nameList.add(list.get(i).getUserName());
	}
    
    for (int i = 0; i < nameList.size(); i++) {
	System.out.println(nameList.get(i));	
	}
    


}
}