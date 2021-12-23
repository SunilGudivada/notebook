// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l =1, r = m*n,res=0;
        
        while(l<=r){
            int mid = ( l+r ) / 2, cnt =0;
            for(int i=1;i<=m;i++) cnt+=Math.min(mid/i,n);
            if(cnt >= k){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return res;
    }
}