// TC->O(n*logn), SC->O(n)
class Pair{
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        if(n==0) return 0;
        ArrayList<Pair> ls = new ArrayList<>();
        for(int i =0;i<n;i++){
            ls.add(new Pair(start[i], end[i]));
        }
        Collections.sort(ls,(x,y)->x.end-y.end);
        int cnt = 1;
        int prevEnd =  ls.get(0).end;
        for(int i=1;i<n;i++){
            int curStart = ls.get(i).start;
            if(curStart > prevEnd){
                cnt++;
                prevEnd = ls.get(i).end;
            }
            
        }
        return cnt;
    }
}
