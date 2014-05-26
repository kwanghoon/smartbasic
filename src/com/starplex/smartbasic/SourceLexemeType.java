package com.starplex.smartbasic;

/**
 * Created by Влад on 23.05.2014.
 */
public enum SourceLexemeType {
    NONE,
    INVALID,

    FILE_END,
    LINE_END,

    IDENTIFIER,
    STRING,
    INTEGER_NUMBER,
    REAL_NUMBER,

    PLUS,
    MINUS,
    STAR,
    SLASH,

    EQUAL_SIGN,
    NOT_EQUAL,
    LESS_EQUAL,
    MORE_EQUAL,
    LESS,
    MORE,

    COMMA,
    DOT,
    COLON,

    LEFT_PAREN,
    RIGHT_PAREN,
    LEFT_BRACKET,
    RIGHT_BRACKET,

    // KEYWORDS

    OR,
    AND,

    IF,
    THEN,
    ELSEIF,
    ELSE,
    ENDIF,

    WHILE,
    ENDWHILE,

    FOR,
    TO,
    STEP,
    ENDFOR,

    SUB,
    ENDSUB,

    GOTO,
}
