/*
 * Create public inner class named Iterator inside NameList class.
 */

/**
 * @author Bogdan Kurchak 
 */
class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {
        private int counter = 0;

        private Iterator() { }

        public boolean hasNext() {
            return names.length != counter;
        }

        public String next() {
            String next = names[counter];
            if (hasNext()) {
                counter++;
            }
            return next;
        }
    }
}
