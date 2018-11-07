package Board;

import Rooms.Room;

public class Board {

    private Room[][] board;

    public Board(Room[][] board)
    {
        this.board = board;
    }

    public Board(int x, int y)
    {
        this.board = new Room[x][y];
    }

    public void edit(Room replace, int row, int column)
    {
        board[row][column] = replace;
    }

    public void fill(Room str)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = str;
            }
        }
    }

    public String toString()
    {
        String boardstr = "";
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                boardstr += board[i][j];
            }
            boardstr += "\n";
        }
        return boardstr;
    }
}