package com.exam.examserver.helper;

public class UserFoundException extends Exception{
    public UserFoundException(){
        super("User is found in the db");
    }
    public UserFoundException(String msg){
        super(msg);
    }
}
