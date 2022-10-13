package com.paypal.compliance.casemgmt.discipline.cerm.business.impl;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

        int[] input = {2,4,6,1,2,7,6,5,4,9,0};
        int target = 9;

        Set<Integer> set = new HashSet<>();
        List<Integer[]> result = new ArrayList<>();

        Arrays.sort(input);

        int left = 0;
        int right = input.length-1;

        while(left<right){

            if(left >0 && input[left] == input[left-1]){
                left++;
            }
            if(right+1 <input.length-1 && input[right] == input[right+1]){
                right--;
            }
            int sum = input[left] + input[right];
            if( sum==target ) {
                result.add(new Integer[]{input[left] ,input[right]});
                left++;
                right--;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }

        for(Integer[] res : result){
            System.out.println("pair : {"+res[0] + "," + res[1]+ "}" );
        }
    }
}
