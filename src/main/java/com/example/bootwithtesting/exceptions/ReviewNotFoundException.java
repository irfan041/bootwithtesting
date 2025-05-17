package com.example.bootwithtesting.exceptions;

public class ReviewNotFoundException extends Exception{
    ReviewNotFoundException(String msg){
        super(msg);
    }
}
