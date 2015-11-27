package com.iitms.rfcampuscommon;

import java.util.Collections;
import java.util.List;

public class CheckUnique {

    public  static boolean equalLists(List<Integer> one, List<Integer> two){     
        if (one == null && two == null){
            return true;
        }

        if((one == null && two != null) 
          || one != null && two == null
          || one.size() != two.size()){
            return false;
        }

        //to avoid messing the order of the lists we will use a copy
        //as noted in comments by A. R. S.
           

        Collections.sort(one);
        Collections.sort(two);      
        return one.equals(two);
    }
}
