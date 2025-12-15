
class Solution {
    int[] getId(String str){
        String[] parts = str.split(" ");
        int[] ids = new int[parts.length];
        for(int i=0;i<parts.length;i++){
            ids[i]= Integer.parseInt(parts[i].replace("id",""));
        }
        return ids;
    }
    void sortList(List<List<String>> data) {
        data.sort((list1, list2) -> {
            int secondCompare = Integer.compare(Integer.parseInt(list1.get(1)), Integer.parseInt(list2.get(1)));
            if (secondCompare != 0) return secondCompare;
            return list1.get(0).equals("OFFLINE") ? -1 : 1;
        });
        
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];
        
        sortList(events);
        
        for(int x=0;x<events.size();x++){
            List<String> event = events.get(x);
            
            if(event.get(0).equals("MESSAGE")){
                String mentionsString = event.get(2);
                if(mentionsString.equals("ALL")){
                    for(int i=0;i<numberOfUsers;i++){
                        mentions[i]++;
                    } 
                }
                else if(mentionsString.equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        if(offlineTime[i]==0) mentions[i]++;
                        else{
                            if((Integer.valueOf(event.get(1)) - offlineTime[i]) >= 60) mentions[i]++;
                        }
                    }
                }
                else{
                    int[] Ids = getId(mentionsString);
                
                    for(int i=0;i<Ids.length;i++){
                        mentions[Ids[i]]++;
                    }
                    
                }
            }
            else{
                int time = Integer.valueOf(event.get(1));
                offlineTime[Integer.valueOf(event.get(2))] = time;
                
            }
            
        }
        return mentions;
    }
}