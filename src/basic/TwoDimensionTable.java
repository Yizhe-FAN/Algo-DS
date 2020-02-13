package basic;

public class TwoDimensionTable {

    private int[][] table;
    private int lineNumber;
    private int columnNumber;
    Integer d;

    public TwoDimensionTable(int lineNumber, int columnNumber) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        int count = 0;

        //must give the size when new, below is wrong.
        //int[] a = new int[];
        table = new int[lineNumber][];
        for (int i = 0; i < lineNumber; i++) {
            table[i] = new int[columnNumber];
            for (int j = 0; j < columnNumber; j++) {
                table[i][j] = ++count;
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                System.out.print(table[i][j]);
                if (j != columnNumber - 1) {
                    System.out.print(",");
                }
            }
            if (i != lineNumber - 1) {
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        TwoDimensionTable twoDimensionTable = new TwoDimensionTable(3, 4);
        twoDimensionTable.printTable();
    }


}
