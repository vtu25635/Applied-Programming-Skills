import java.util.*;

class Solution {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.count = new int[n];
        int[] indices = new int[n];
        
        // Initialize indices to track the original position of each element
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, 0, n - 1);

        // Convert the primitive array to the required List<Integer> format
        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] indices, int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, left, mid);
        mergeSort(nums, indices, mid + 1, right);
        merge(nums, indices, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;      // Pointer for left half
        int j = mid + 1;   // Pointer for right half
        int k = 0;         // Pointer for temp array
        int rightSmallerCount = 0;

        while (i <= mid && j <= right) {
            // If the element in the right half is smaller
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                // Increment the count of smaller elements encountered on the right
                rightSmallerCount++;
            } else {
                // If element in left half is smaller or equal
                // Add the current total of smaller elements found in the right half
                count[indices[i]] += rightSmallerCount;
                temp[k++] = indices[i++];
            }
        }

        // Clean up remaining elements in left half
        while (i <= mid) {
            count[indices[i]] += rightSmallerCount;
            temp[k++] = indices[i++];
        }
        
        // Clean up remaining elements in right half
        while (j <= right) {
            temp[k++] = indices[j++];
        }

        // Copy the sorted indices back into the original tracking array
        System.arraycopy(temp, 0, indices, left, temp.length);
    }
}