class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Inbuilt sort function O(nlogn)
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int k=0;k<n;k++){
            // k fixes first element 
            // apply two pointer approach in array after kth element
            
             // removing adjacent duplicates
            if(k>0 && nums[k-1]==nums[k]){
                continue;
            }
            int target = -nums[k];
            int i = k+1;
            int j = n-1;
            while(i<j){
               
                if(i>k+1 && nums[i-1]==nums[i]){
                    i++;continue;
                }
                 // removing adjacent duplicates
                if(j<n-1 && nums[j]==nums[j+1]){
                    j--;continue;
                }
                int sum = nums[i] + nums[j];
                if(sum == target){
                    // got the triplet, nums[k],nums[i],nums[j]
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    ans.add(temp);
                    i++;j--;
                }
                else if(sum<target){
                    i++;
                }
                else if(sum>target){
                    j--;
                }
            }
        }
        return ans;
    }
}
