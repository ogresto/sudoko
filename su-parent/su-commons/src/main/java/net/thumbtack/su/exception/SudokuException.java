package net.thumbtack.su.exception;

public class SudokuException extends Exception{
    private static final long serialVersionUID = -1L;
    private final String message;

    public SudokuException(final String message){
        this.message = message;
    }

    public String toString(){
        return "Error : "+ message;
    }
}
