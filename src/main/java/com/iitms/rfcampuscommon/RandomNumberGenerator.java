package com.iitms.rfcampuscommon;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator {

    private Random random = new Random(Long.MAX_VALUE);
    
    public int getRandomNumber(){
        return random.nextInt();
    }
}
