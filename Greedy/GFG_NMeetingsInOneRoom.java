// TC-> O(n + nlogn + n ) = (approx) O(n*logn)
// SC-> O(3*n)  : 3 vriables in each Meeting Object such 'n' object in array list "ls"
class Meeting{
    int start;
    int end;
    int meetingNum;
    Meeting(int start,int end,int meetingNum ){
        this.start = start;
        this.end = end;
        this.meetingNum = meetingNum;
    }
}
class GFG_NMeetingsInOneRoom {
    public int maxMeetings(int start[], int end[]) {
        ArrayList<Meeting> ls = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            ls.add(new Meeting(start[i],end[i],i+1));
        }
        ls.sort(Comparator.comparingInt(o -> o.end));
        // for(int i=0;i<ls.size();i++){
        //     System.out.print(ls.get(i).end+" ");
        // }
        int ans = 1;
        int prevEnd = ls.get(0).end;
        for(int i=1;i<ls.size();i++){
            if(ls.get(i).start > prevEnd){
                prevEnd = ls.get(i).end;
                ans++;
            }
        }
        return ans;    
    }
}
