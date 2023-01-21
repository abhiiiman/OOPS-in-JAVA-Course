// 8.13

public class IntegerSet {
    private boolean[] set;

    // no-argument constructor initializes the set to the "empty set"
    public IntegerSet() {
        set = new boolean[101];
    }

    // insert method adds an element to the set
    public void insert(int element) {
        if (element >= 0 && element <= 100) {
            set[element] = true;
        }
    }

    // delete method removes an element from the set
    public void delete(int element) {
        if (element >= 0 && element <= 100) {
            set[element] = false;
        }
    }

    // get method returns the element at a given index
    public boolean get(int element) {
        if (element >= 0 && element <= 100) {
            return set[element];
        }
        return false;
    }

    // union method returns a new set that is the union of the current set and another set
    public IntegerSet union(IntegerSet other) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i <= 100; i++) {
            if (this.get(i) || other.get(i)) {
                result.insert(i);
            }
        }
        return result;
    }

    // intersection method returns a new set that is the intersection of the current set and another set
    public IntegerSet intersection(IntegerSet other) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i <= 100; i++) {
            if (this.get(i) && other.get(i)) {
                result.insert(i);
            }
        }
        return result;
    }

    // toString method returns a string representation of the set
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i <= 100; i++) {
            if (set[i]) {
                sb.append(i + ",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.insert(1);
        set1.insert(2);
        set1.insert(3);
        System.out.println("Set 1: " + set1);

        IntegerSet set2 = new IntegerSet();
        set2.insert(2);
        set2.insert(3);
        set2.insert(4);
        System.out.println("Set 2: " + set2);

        IntegerSet union = set1.union(set2);
        System.out.println("Union: " + union);

        IntegerSet intersection = set1.intersection(set2);
        System.out.println("Intersection: " + intersection);
    }
}
