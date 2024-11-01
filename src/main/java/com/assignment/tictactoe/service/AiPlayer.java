package com.assignment.tictactoe.service;

public class AiPlayer extends Player {

    public AiPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void move(int row, int col) {

        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                if (board.isLegalMove(i, j)) {
                    board.updateMove(i, j, Piece.O);
                    int score = minimax(board.getPieces(), 0, false);
                    board.updateMove(i, j, Piece.EMPTY);

                    if (score > maxScore) {
                        row = i;
                        col = j;
                        maxScore = score;
                    }
                }
            }
        }
        System.out.println("row and col : " + row + " " + col);
        if (row != -1 && col != -1) {
            System.out.println("row and col : " +row + " " + col);
            board.updateMove(row, col, Piece.O);
            board.getBoardUI().update(row, col, Piece.O);

        }
    }



    private int minimax(Piece[][] pieces, int depth, boolean isMaximizing) {

        Winner winner = board.checkWinner();

        if (winner != null) {
            if (winner.getWinningPiece() == Piece.O) {
                return 10 - depth;
            } else if (winner.getWinningPiece() == Piece.X) {
                return depth - 10;
            }
        }

        if (board.isBoardFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestValue = Integer.MIN_VALUE;
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.O;
                        bestValue = Math.max(bestValue, minimax(pieces, depth + 1, false));
                        pieces[i][j] = Piece.EMPTY;
                    }
                }
            }
            return bestValue;
        } else {
            int bestValue = Integer.MAX_VALUE;
            for (int i = 0; i < pieces.length; i++) {
                for (int j = 0; j < pieces[i].length; j++) {
                    if (pieces[i][j] == Piece.EMPTY) {
                        pieces[i][j] = Piece.X;
                        bestValue = Math.min(bestValue, minimax(pieces, depth + 1, true));
                        pieces[i][j] = Piece.EMPTY;
                    }
                }
            }
            return bestValue;
        }
    }
}
