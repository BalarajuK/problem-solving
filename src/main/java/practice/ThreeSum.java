package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        for(List<Integer> list : new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4})){
            for(int num :list){
                System.out.print(num +" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i< nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>>  matches = getMatches(nums, -nums[i], i+1);
            for(List<Integer> list : matches){
                list.add(nums[i]);
            }
            res.addAll(matches);
        }
        return res;

    }

    private List<List<Integer>>  getMatches(int[] nums, int target, int start){

        List<List<Integer>> res = new ArrayList<>();

        int i = start;
        int j = nums.length-1;

        while(i<j){
            int sum = nums[i]+nums[j];
            if( sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                res.add(list);

                int val = nums[i];
                while(i<=j && nums[i]==val){
                    i++;
                }

                val = nums[j];
                while(j>=i && nums[j]==val){
                    j--;
                }
                continue;
            }

            if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
}
