import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMapTest {

    @Test
    public void testHashMapExample()
    {
        // Map people to office locations
        HashMap<String, String> offices = new HashMap<String, String>();

        // Associate this key with this value
        offices.put("Helen", "CIT219");
        offices.put("Sun", "CIT501");
        offices.put("Kathi", "B&H802");

        offices.get("Sun"); //

//        System.out.println("Helen".hashCode());
//        System.out.println("Sun".hashCode());

//        Customer c = new Customer("kathi", "cs200");
//        System.out.println(c.hashCode());
    }

    @Test
    public void testHashMapExample2() {
        // Map lab times to room numbers
        HashMap<String, String> labRooms = new HashMap<String, String>();

        // Associate this key with this value
        labRooms.put("Mon 4-6", "CIT219");
        labRooms.put("Tue 6-8", "CIT501");
        labRooms.put("Wed 8-10", "B&H802");

        // --------------------------------------
        // Iterating over a HashMap (one way)
        for (String key : labRooms.keySet()) {
            // key = "Mon 4-6, Wed 8-10, Tue 6-8, ...
        }

        // --------------------------------------

        // HashSet:  just the keys
        Set<String> labTimes = new HashSet<String>();
        labTimes.add("Mon 4-6");
        labTimes.add("Tue 8-10");

        if (labTimes.contains("Mon 4-6")) {
            // "Is there a lab from Monday 4-6?
        }

    }



}
