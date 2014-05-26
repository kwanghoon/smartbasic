package com.starplex.smartbasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

/**
 * Created by Влад on 24.05.2014.
 */
public final class LexicalAnalyzer {
    public SourceLexemeType currentLexeme = SourceLexemeType.NONE;
    public long currentInteger;
    public double currentReal;
    public String currentString;

    public boolean initializationSuccessful;

    private FileInputStream inputFile;
    private String inputFileName;
    private long position = 1, line = 1;
    private int curSym = 0;
    private char prevSym = 0;

    public long errorsCount = 0;

    private HashMap<String, SourceLexemeType> keywords;

    public LexicalAnalyzer(String inputFileName)
    {
        keywords = new HashMap<String, SourceLexemeType>();

        keywords.put("OR", SourceLexemeType.OR);
        keywords.put("AND", SourceLexemeType.AND);
        
        keywords.put("IF", SourceLexemeType.IF);
        keywords.put("THEN", SourceLexemeType.THEN);
        keywords.put("ELSEIF", SourceLexemeType.ELSEIF);
        keywords.put("ELSE", SourceLexemeType.ELSE);
        keywords.put("ENDIF", SourceLexemeType.ENDIF);

        keywords.put("WHILE", SourceLexemeType.WHILE);
        keywords.put("ENDWHILE", SourceLexemeType.ENDWHILE);
        
        keywords.put("FOR", SourceLexemeType.FOR);
        keywords.put("TO", SourceLexemeType.TO);
        keywords.put("STEP", SourceLexemeType.STEP);
        keywords.put("ENDFOR", SourceLexemeType.ENDFOR);

        keywords.put("SUB", SourceLexemeType.SUB);
        keywords.put("ENDSUB", SourceLexemeType.ENDSUB);

        keywords.put("GOTO", SourceLexemeType.GOTO);

        this.inputFileName = inputFileName;
        try {
            inputFile = new FileInputStream(inputFileName);

            initializationSuccessful = true;
        } catch (FileNotFoundException e) {
            System.out.println("Error: cannot open input file " + inputFileName);
            initializationSuccessful = false;
        }
    }

    public long getLineNumber()
    {
        return line;
    }

    public long getPosition()
    {
        return position;
    }

    private void getSym()
    {
        try {
            prevSym = (char)curSym;
            curSym = inputFile.read();
            if ((curSym == '\r') || (curSym == '\n')) {
                if ((curSym == '\n') && (prevSym == '\r')) {
                    getSym();
                } else {
                    line++;
                    position = 1;
                }
            } else {
                position++;
            }
        } catch (IOException e) {
            System.out.println("Error: file reading error(" + inputFileName + ")");
            e.printStackTrace();
        }
    }

    private boolean readNext = true;

    public void getNextLexeme()
    {
        if (readNext) {
            getSym();
        } else {
            readNext = true;
        }

        while ((curSym == ' ') || (curSym == '\t')) { // skipping whitespaces
            getSym();
        }
        if (curSym == '\'') { // skipping comments
            getSym();
            while ((curSym != -1) && (curSym != '\r') && (curSym != '\n')) {
                getSym();
            }
        }

        if (curSym == -1) {
            currentLexeme = SourceLexemeType.FILE_END;
        } else if ((curSym == '\r') || (curSym == '\n')) {
            currentLexeme = SourceLexemeType.LINE_END;
        } else if (curSym == '+') {
            currentLexeme = SourceLexemeType.PLUS;
        } else if (curSym == '-') {
            currentLexeme = SourceLexemeType.MINUS;
        } else if (curSym == '*') {
            currentLexeme = SourceLexemeType.STAR;
        } else if (curSym == '/') {
            currentLexeme = SourceLexemeType.SLASH;
        } else if (curSym == '=') {
            currentLexeme = SourceLexemeType.EQUAL_SIGN;
        } else if (curSym == '<') {
            getSym();
            if (curSym == '>') {
                currentLexeme = SourceLexemeType.NOT_EQUAL;
            } else if (curSym == '=') {
                currentLexeme = SourceLexemeType.LESS_EQUAL;
            } else {
                currentLexeme = SourceLexemeType.LESS;
                readNext = false;
            }
        } else if (curSym == '>') {
            getSym();
            if (curSym == '=') {
                currentLexeme = SourceLexemeType.MORE_EQUAL;
            } else {
                currentLexeme = SourceLexemeType.MORE;
                readNext = false;
            }
        } else if (curSym == ',') {
            currentLexeme = SourceLexemeType.COMMA;
        } else if (curSym == '.') {
            currentLexeme = SourceLexemeType.DOT;
        } else if (curSym == ':') {
            currentLexeme = SourceLexemeType.COLON;
        } else if (curSym == '(') {
            currentLexeme = SourceLexemeType.LEFT_PAREN;
        } else if (curSym == ')') {
            currentLexeme = SourceLexemeType.RIGHT_PAREN;
        } else if (curSym == '[') {
            currentLexeme = SourceLexemeType.LEFT_BRACKET;
        } else if (curSym == ']') {
            currentLexeme = SourceLexemeType.RIGHT_BRACKET;
        } else if (isDigit(curSym)) {
            currentInteger = 0;
            while (isDigit(curSym)) {
                currentInteger = currentInteger * 10 + (curSym - '0');
                getSym();
            }
            readNext = false;
            if (curSym == '.') {
                currentReal = currentInteger;
                long divisor = 10;
                getSym();
                while (isDigit(curSym)) {
                    currentReal = currentReal + (double)(curSym-'0')/divisor;
                    divisor *= 10;
                    getSym();
                }
                currentLexeme = SourceLexemeType.REAL_NUMBER;
            } else {
                currentLexeme = SourceLexemeType.INTEGER_NUMBER;
            }
        } else if (curSym == '\"') {
            getSym();
            StringBuilder sb = new StringBuilder("");
            while ((curSym != '\"') && (curSym != '\r') && (curSym != '\n') && (curSym != -1)) {
                sb.append((char)curSym);
                getSym();
            }
            if ((curSym == '\r') || (curSym == '\n') || (curSym == -1)) {
                showErrorMessage("invalid string");
                currentLexeme = SourceLexemeType.INVALID;
                readNext = false;
                return;
            }
            getSym();
            currentLexeme = SourceLexemeType.STRING;
            currentString = sb.toString();
            readNext = false;
        } else if (isAlphabetic(curSym)) {
            StringBuilder id = new StringBuilder("");
            while (isAlphabetic(curSym) || isDigit(curSym) || (curSym == '_')) {
                id.append((char)curSym);

                getSym();
            }
            readNext = false;
            String sid = id.toString();
            sid = sid.toUpperCase();
            if (keywords.containsKey(sid)) {
                currentLexeme = keywords.get(sid);
            } else {
                currentLexeme = SourceLexemeType.IDENTIFIER;
                currentString = sid;
            }
        } else {
            currentLexeme = SourceLexemeType.INVALID;
        }
    }

    public boolean isEndingLexeme()
    {
        if ((currentLexeme == SourceLexemeType.LINE_END) || (currentLexeme == SourceLexemeType.FILE_END)) {
            return true;
        } else {
            return false;
        }
    }

    public void skipAllToTheEndOfLine()
    {
        while (!isEndingLexeme()) {
            getNextLexeme();
        }
    }

    public void showErrorMessage(String message)
    {
        showErrorMessage(getLineNumber(), getPosition(), inputFileName, message);
    }

    public void showErrorMessage(long line, long position, String fileName, String message)
    {
        System.out.println("Error(" + fileName + ":" + ((Long)line).toString() + ":" + ((Long)position).toString() +
                            "): " + message);
        ++errorsCount;
    }
}
