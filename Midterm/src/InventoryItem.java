public class InventoryItem {
        String type;
        int weight;
        String name;
        int count; // 1 if a single item; more if multiple

        public InventoryItem(String t, int w, String n, int countOfItems) {
                type = t;
                weight = w;
                name = n;
                count = countOfItems;
        }

        public String getName() { return name;}
        public String getType() { return type;}
        public int getWeight() {return weight;}
        public int getCount() {return count;}

        @Override
        public String toString() {
                String ret  = name + " type (" + type + "), wt: " + weight;
                // Changed this so I wouldn't have to write an extra test
                // to make sure it correctly handles count < 1
                ret += ", there are " + count + " left";
                return name;

        }

}
