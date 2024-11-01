package com.assignment.tictactoe.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Winner {

    private Piece winningPiece;
    private int col1;
    private int row1;
    private int col2;
    private int row2;
    private int col3;
    private int row3;

    public Winner(Piece winningPiece, int col1, int row1, int col2, int row2, int col3, int row3) {
        this.winningPiece = winningPiece;
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
        this.col3 = col3;
        this.row3 = row3;
    }
}