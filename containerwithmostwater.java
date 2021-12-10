class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int n=height.length;
        int area=0,ans=0;
        int j=n-1;
        while(i<j)
        {
            if(height[i]<=height[j])
            {
                area=height[i]*(j-i);
            }
            else{
                area=height[j]*(j-i);
            }
            if(ans<area)
            {
                ans=area;
            }
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return ans;
    }
}
