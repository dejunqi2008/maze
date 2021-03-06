public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int row, col;
    public char[][] maze;
    public boolean[][] visited;

    public boolean[][] visible;

    private int entranceX, entranceY;
    private int exitX, exitY;

    public MazeData(int row, int col) {
        if (row % 2 == 0) {
            System.out.println("Converted row number to odd number.");
            row += 1;
        }
        if (col % 2 == 0) {
            System.out.println("Converted column number to odd number.");
            col += 1;
        }
        this.row = row;
        this.col = col;

        maze = new char[row][col];
        visited = new boolean[row][col];
        visible = new boolean[row][col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    maze[i][j] = ROAD;
                } else {
                    maze[i][j] = WALL;
                }
                visited[i][j] = false;
                visible[i][j] = false;
            }
        }

        entranceX = 1;
        entranceY = 0;
        exitX = row - 2;
        exitY = col - 1;

        maze[entranceX][entranceY] = ROAD;
        maze[exitX][exitY] = ROAD;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getEntranceX() {return entranceX;}
    public int getEntranceY() {return entranceY;}
    public int getExitX() {return exitX;}
    public int getExitY() {return exitY;}

    public boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }


    public void setVisible(int x, int y) {
        if (!inArea(x, y)) {
            throw new IllegalArgumentException("x, y index out of range");
        }

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (inArea(i, j)) {
                    visible[i][j] = true;
                }
            }
        }
    }


}

