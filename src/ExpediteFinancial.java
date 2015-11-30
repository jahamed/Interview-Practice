import java.util.*;

public class ExpediteFinancial {
    /**
     * Parsing an API response
     * <p>
     * Suppose you are calling a JSON API that responds to requests using a nested
     * Map, where the values are either other Maps, or Strings, with no other
     * possible options.
     * <p>
     * Given a sequence of keys, write a method that traverses the Map to return
     * the String stored at the terminal key in the sequence.
     */

    public static String parse(Map<String, Object> hash, List<String> keys) {
        // Your Implementation here!
        String toReturn = "";
        String index = "";
        HashMap<String, Object> tempHash = null;

        for (int i = 0; i < keys.size(); i++) {
            index = keys.get(i);
            if (hash.get(index) instanceof String) {
                toReturn = hash.get(index).toString();
                break;
            } else if (tempHash != null) {
                if(tempHash.get(index) instanceof String) {
                    toReturn = tempHash.get(index).toString();
                    break;
                }else {
                    tempHash = (HashMap<String, Object>)tempHash.get(index);
                }
            } else {
                tempHash = (HashMap<String, Object>)hash.get(index);
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Map<String, Object> input = new HashMap<String, Object>() {
            {
                put("k1", "v1");
                put("k2", new HashMap<String, Object>() {
                    {
                        put("k21", "v21");
                        put("k22", new HashMap<String, Object>() {
                            {
                                put("k221", "v221");
                            }
                        });
                    }
                });
                put("k3", new HashMap<String, Object>() {
                    {
                        put("k31", "v31");
                    }
                });
            }
        };

        String output = parse(input, Arrays.asList("k2", "k22", "k221"));
        if (output.equals("v221")) {
            System.out.println("Success!");
        } else {
            System.out.format("Output \"%s\" did not match \"v221\"%n", output);
        }
    }
}