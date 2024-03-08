import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class CityVertex {
    public LinkedList<CityVertex> toCities;
    public String name;

    public CityVertex(String nm) {
        this.name = nm;
        this.toCities = new LinkedList<CityVertex>();
    }

    public void addEdge(CityVertex toVertex) {
        this.toCities.add(toVertex);
    }

    // simple recursive can-reach that ignores already-visited nodes
    public boolean canReachBroken(CityVertex dest) {
        if (this == dest) {
            return true;
        }

        for (CityVertex neighbor : this.toCities) {
            if (neighbor.canReachBroken(dest)) {
                return true; // We can reach neighbor, we can reach dest
            }
        }
        return false;
    }

    // recursive helper for canReach with visited set
    private boolean canReachVisit(CityVertex dest, HashSet<CityVertex> visited) {
        if (this == dest) {
            return true;
        }

        for (CityVertex neighbor : this.toCities) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                if (neighbor.canReachVisit(dest, visited)) {
                    return true; // We can reach neighbor, we can reach dest
                }
            }
        }
        return false;
    }

    // canReach that initializes the visited set
    public boolean canReach(CityVertex dest) {
        return this.canReachVisit(dest, new HashSet<CityVertex>());
    }

    // different approach to canReach -- we make the call stack explicit
    public boolean canReachStack(CityVertex dest) {
        HashSet<CityVertex> visited = new HashSet<CityVertex>();
        Stack<CityVertex> toCheck = new Stack<CityVertex>();

        // put the start node into the toCheck Stack
        toCheck.push(this);

        // as long as we have unvisited nodes to check, keep processing them
        while (!toCheck.isEmpty()) {
            CityVertex check = toCheck.pop();
            visited.add(check);
            if (check == dest) {
                // found a solution! Cancel the while loop and return
                return true;
            } else {
                // add each unvisited node to the stack
                for (CityVertex neighbor : check.toCities) {
                    if (!visited.contains(neighbor))
                        toCheck.push(neighbor);
                }
            }
        }
        return false;
    }

    public String toString() {
        String retstring = "City " + this.name + " goes to { ";
        for (CityVertex toCity : this.toCities) {
            retstring += toCity.name + " ";
        }
        retstring += "}";
        return retstring;
    }
}
