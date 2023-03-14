public class GameModel {
    private final String configuration;
    private final int dimension;
    private final boolean[][] board;
    private final int[][] rowValues;
    private final int[][] colValues;

    public GameModel(String configuration) {
        this.configuration = configuration;
        String[] configParts = configuration.split(",");
        this.dimension = configParts.length;
        this.board = new boolean[dimension][dimension];
        this.rowValues = new int[dimension][];
        this.colValues = new int[dimension][];

        for (int i = 0; i < dimension; i++) {
            String rowConfig = configParts[i];
            this.rowValues[i] = parseValues(rowConfig);
            for (int j = 0; j < dimension; j++) {
                this.board[i][j] = rowConfig.charAt(j) == '1';
                if (i == 0) {
                    String colConfig = "";
                    for (int k = 0; k < dimension; k++) {
                        colConfig += configParts[k].charAt(j);
                    }
                    this.colValues[j] = parseValues(colConfig);
                }
            }
        }
    }

    public String getConfiguration() {
        return configuration;
    }

    public int getDimension() {
        return dimension;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public int[] getRowValues(int rowIndex) {
        return rowValues[rowIndex];
    }

    public int[] getColValues(int colIndex) {
        return colValues[colIndex];
    }

    private int[] parseValues(String config) {
        String[] parts = config.split("(?<=0)(?=1)|(?<=1)(?=0)");
        int count = 0;
        int[] values = new int[parts.length];
        for (String part : parts) {
            if (part.contains("1")) {
                values[count] = Integer.parseInt(part);
                count++;
            }
        }
        return Arrays.copyOf(values, count);
    }
}
