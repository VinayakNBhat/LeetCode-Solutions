class Solution {
public:
//method 1: simple solution using STL sort 
//TC:O((m+n)log(m+n))
//SC:O(1)
    
    
//     void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        
//         for(int i=m; i<m+n; i++)
//             nums1[i]+=nums2[i-m];
    
//         sort(nums1.begin(), nums1.end());
//     }
    
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        
//method 2: simple solution using the fact that two given arrays are sorted.
//TC: O(m+n)
//SC: O(1)
        
        int i=m-1, j=n-1, end=m+n-1;
        
        while(end>=0)
        {
            if(i==-1)
                nums1[end]=nums2[j--];
            else if(j==-1)
                nums1[end]==nums1[i--];
            else if(nums1[i]>nums2[j])
                nums1[end]=nums1[i--];
            else
                nums1[end]=nums2[j--];
            end--;
        }
        
    }
};
