import java.util.*;

class OffsetIndex {

    ArrayList<Integer> offsets;
    ArrayList<Integer> positions;

    OffsetIndex() {

        offsets = new ArrayList<>();
        positions = new ArrayList<>();
    }

    // Add sparse index entry
    void addEntry(int offset, int position) {

        offsets.add(offset);
        positions.add(position);
    }

    // Display index
    void displayIndex() {

        System.out.println("Sparse Offset Index:\n");

        for (int i = 0; i < offsets.size(); i++) {

            System.out.println(
                    offsets.get(i)
                    + " -> "
                    + positions.get(i));
        }
    }

    // Binary Search
    int binarySearch(int targetOffset) {

        int low = 0;
        int high = offsets.size() - 1;

        int result = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (offsets.get(mid) == targetOffset) {

                return mid;
            }

            else if (offsets.get(mid) < targetOffset) {

                result = mid;
                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }

        return result;
    }

    // Lookup offset
    void lookup(int targetOffset) {

        int index = binarySearch(targetOffset);

        if (index == -1) {

            System.out.println("Offset not found.");
            return;
        }

        System.out.println("\nTarget Offset: " + targetOffset);

        System.out.println(
                "Nearest Sparse Index Entry: "
                + offsets.get(index)
                + " -> "
                + positions.get(index));

        System.out.println(
                "Sequential scan forward from physical position "
                + positions.get(index));
    }
}