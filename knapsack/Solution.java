public class Solution {

    private boolean[] data;
    private int length;

    public Solution (int size) {
        this.data = new boolean[size];
        for (int i = 0; i < this.data.length; i++) {
            setBit(i, false);
        }
        this.length = size;
    }

    public boolean setBit (int i, boolean value) {
        this.data[i] = value;
        return true;
    }

    public boolean valueAt (int i) {
        return this.data[i];
    }

    public int length () {
        return this.length;
    }

    public void tare () {
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = false;
        }
    }

    public void logicOR (Solution b) {
        if (b == null) return;
        if (this.length() != b.length()) {
            throw new IllegalArgumentException("Soln. size mis-match");
        }
        for (int i = 0; i < this.length(); i++) {
            this.data[i] = (this.valueAt(i) || b.valueAt(i));
        }
    }

    public String toString () {
        String result = "[";
        for (boolean b: data)
            result = result + ",";
        return result + "]";
    }

}