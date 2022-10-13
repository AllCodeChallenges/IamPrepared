package com.paypal.compliance.casemgmt.discipline.cerm.business.impl;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

        int[] input = {2,2,2,2};
        int target = 4;

        Set<Integer> set = new HashSet<>();
        List<Integer[]> result = new ArrayList<>();

        for(int i =0;i<input.length;i++){
            int otherNum = target - input[i];
            if(set.contains(otherNum)){
                result.add(new Integer[]{input[i],otherNum});
            }
            set.add(input[i]);
        }

        for(Integer[] res : result){
            System.out.println("pair : {"+res[0] + "," + res[1]+ "}" );
        }
    }
}
