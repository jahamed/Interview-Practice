package InterviewCake;

import java.util.HashMap;
import java.util.Map;

public class UniqueId {
    // #21


    public static Integer findUniqueId(int[] ids) {

        Map<Integer, Integer> idMap = new HashMap<Integer, Integer>();
        Integer uniqueId = null;

        for(int id : ids) {
            if(idMap.containsKey(id)) {
                idMap.put(id, idMap.get(id) + 1);
            }else {
                idMap.put(id, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : idMap.entrySet()) {
            if(entry.getValue() == 1){
                uniqueId = entry.getKey();
            }
        }

        return uniqueId;
    }

    public static int findUniqueIdXOR(int[] ids) {
        int uniqueId = 0;

        for (int i=0; i < ids.length; i++) {
            uniqueId ^= ids[i];
        }

        return uniqueId;
    }

    public static void main(String[] args) {
        int[] idTest = {1, 1, 2, 2, 3, 4, 4};
        //System.out.println(findUniqueId(idTest));
        System.out.println(findUniqueIdXOR(idTest));
    }
}
