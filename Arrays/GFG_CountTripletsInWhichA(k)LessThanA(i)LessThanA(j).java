// Optimal : TC ->O(n^2)
int CountTriplets(int a[], int n){
    int ans = 0;
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = i + 1; j < n; j++) {
           // If a[j] > a[i] then increment cnt
            if (a[j] > a[i]) cnt++;
            // If a[j] < a[i], then
            // it mean we have found a[k]
            // such that a[k] < a[i] < a[j]
            else
                ans += cnt;
        }
    }
    return ans;
}



