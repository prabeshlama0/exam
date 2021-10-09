package com.exam.examserver.helper;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("User is not found in the db");
    }
    public UserNotFoundException(String msg){
        super(msg);
    }
}
