public class Main {

    public static void main(String[] args) {

        OffsetIndex obj = new OffsetIndex();

        // Sparse Index Entries
        obj.addEntry(100, 0);
        obj.addEntry(200, 500);
        obj.addEntry(300, 1000);
        obj.addEntry(400, 1500);
        obj.addEntry(500, 2000);

        // Display Index
        obj.displayIndex();

        // Lookup
        obj.lookup(250);
    }
}