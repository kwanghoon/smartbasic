package com.starplex.smartbasic;

import java.util.TreeMap;

/**
 * Created by Влад on 25.05.2014.
 */
public final class SmartBasicProgram {
    public static final String MAIN_SUBROUTINE_NAME = "?main";

    public TreeMap<String, SmartBasicVariable> variables = new TreeMap<String, SmartBasicVariable>();
    public TreeMap<String, SmartBasicSubroutine> subroutines = new TreeMap<String, SmartBasicSubroutine>();

    private SmartBasicLanguageObject environment[] = new SmartBasicLanguageObject[20];

    public SmartBasicProgram()
    {
        environment[0] = new SmartBasicLanguageObject("ARRAY", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[0].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("CONTAINSINDEX", 2, true, environment[0]),
                new SmartBasicLanguageObjectMethod("CONTAINSVALUE", 2, true, environment[0]),
                new SmartBasicLanguageObjectMethod("GETALLINDICES", 1, true, environment[0]),
                new SmartBasicLanguageObjectMethod("GETITEMCOUNT", 1, true, environment[0]),
                new SmartBasicLanguageObjectMethod("GETVALUE", 2, true, environment[0]),
                new SmartBasicLanguageObjectMethod("ISARRAY", 1, true, environment[0]),
                new SmartBasicLanguageObjectMethod("REMOVEVALUE", 2, false, environment[0]),
                new SmartBasicLanguageObjectMethod("SETVALUE", 3, false, environment[0]),
        };
        environment[1] = new SmartBasicLanguageObject("CLOCK", new SmartBasicLanguageObjectMethod[0], null, new SmartBasicLanguageObjectEvent[0]);
        environment[1].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("DATE", true, environment[1]),
               new SmartBasicLanguageObjectField("DAY", true, environment[1]),
               new SmartBasicLanguageObjectField("ELAPSEDMILLISECONDS", true, environment[1]),
               new SmartBasicLanguageObjectField("HOUR", true, environment[1]),
               new SmartBasicLanguageObjectField("MILLISECOND", true, environment[1]),
               new SmartBasicLanguageObjectField("MINUTE", true, environment[1]),
               new SmartBasicLanguageObjectField("MONTH", true, environment[1]),
               new SmartBasicLanguageObjectField("SECOND", true, environment[1]),
               new SmartBasicLanguageObjectField("TIME", true, environment[1]),
               new SmartBasicLanguageObjectField("WEEKDAY", true, environment[1]),
               new SmartBasicLanguageObjectField("YEAR", true, environment[1]),
        };
        environment[2] = new SmartBasicLanguageObject("CONTROLS", null, null, null);
        environment[2].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("ADDBUTTON", 3, true, environment[2]),
                new SmartBasicLanguageObjectMethod("ADDMULTILINETEXTBOX", 2, true, environment[2]),
                new SmartBasicLanguageObjectMethod("ADDTEXTBOX", 2, true, environment[2]),
                new SmartBasicLanguageObjectMethod("GETBUTTONCAPTION", 1, true, environment[2]),
                new SmartBasicLanguageObjectMethod("GETTEXTBOXTEXT", 1, true, environment[2]),
                new SmartBasicLanguageObjectMethod("HIDECONTROL", 1, false, environment[2]),
                new SmartBasicLanguageObjectMethod("MOVE", 3, false, environment[2]),
                new SmartBasicLanguageObjectMethod("REMOVE", 1, false, environment[2]),
                new SmartBasicLanguageObjectMethod("SETBUTTONCAPTION", 2, false, environment[2]),
                new SmartBasicLanguageObjectMethod("SETSIZE", 3, false, environment[2]),
                new SmartBasicLanguageObjectMethod("SETTEXTBOXTEXT", 2, false, environment[2])
        };
        environment[2].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("LASTCLICKEDBUTTON", true, environment[2]),
               new SmartBasicLanguageObjectField("LASTTYPEDTEXTBOX", true, environment[2])
        };
        environment[2].events = new SmartBasicLanguageObjectEvent[] {
               new SmartBasicLanguageObjectEvent("BUTTONCLICKED", environment[2]),
               new SmartBasicLanguageObjectEvent("TEXTTYPED", environment[2]),
        };
        environment[3] = new SmartBasicLanguageObject("DESKTOP", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[3].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("SETWALLPAPER", 1, false, environment[3])
        };
        environment[3].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("WIDTH", true, environment[3]),
               new SmartBasicLanguageObjectField("HEIGHT", true, environment[3])
        };
        environment[4] = new SmartBasicLanguageObject("DICTIONARY", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[4].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("GETDEFINITION", 1, true, environment[4]),
                new SmartBasicLanguageObjectMethod("GETDEFINITIONFRENCH", 1, true, environment[4])
        };
        environment[5] = new SmartBasicLanguageObject("FILE", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[5].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("APPENDCONTENTS", 2, true, environment[5]),
                new SmartBasicLanguageObjectMethod("COPYFILE", 2, true, environment[5]),
                new SmartBasicLanguageObjectMethod("CREATEDIRECTORY", 1, true, environment[5]),
                new SmartBasicLanguageObjectMethod("DELETEDIRECTORY", 1, true, environment[5]),
                new SmartBasicLanguageObjectMethod("DELETEFILE", 1, true, environment[5]),
                new SmartBasicLanguageObjectMethod("GETDIRECTORIES", 1, true, environment[5]),
                new SmartBasicLanguageObjectMethod("GETFILES", 1, true, environment[5]),
                new SmartBasicLanguageObjectMethod("GETSETTINGSFILEPATH", 0, false, environment[5]),
                new SmartBasicLanguageObjectMethod("GETTEMPORARYFILEPATH", 0, false, environment[5]),
                new SmartBasicLanguageObjectMethod("INSERTLINE", 3, true, environment[5]),
                new SmartBasicLanguageObjectMethod("READCONTENTS", 1, true, environment[5]),
                new SmartBasicLanguageObjectMethod("READLINE", 2, true, environment[5]),
                new SmartBasicLanguageObjectMethod("WRITECONTENTS", 2, true, environment[5]),
                new SmartBasicLanguageObjectMethod("WRITELINE", 3, true, environment[5]),
        };
        environment[5].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("LASTERROR", false, environment[5])
        };
        environment[6] = new SmartBasicLanguageObject("FLICKR", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[6].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("GETPICTUREOFMOMENT", 0, true, environment[6]),
                new SmartBasicLanguageObjectMethod("GETRANDOMPICTURE", 1, true, environment[6])
        };
        environment[7] = new SmartBasicLanguageObject("GRAPHICSWINDOW", null, null, null);
        environment[7].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("SHOW", 0, false, environment[7]),
                new SmartBasicLanguageObjectMethod("HIDE", 0, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWRECTANGLE", 4, false, environment[7]),
                new SmartBasicLanguageObjectMethod("FILLRECTANGLE", 4, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWELLPISE", 4, false, environment[7]),
                new SmartBasicLanguageObjectMethod("FILLELLIPSE", 4, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWTRIANGLE", 6, false, environment[7]),
                new SmartBasicLanguageObjectMethod("FILLTRIANGLE", 6, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWLINE", 4, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWTEXT", 3, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWBOUNDTEXT", 4, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWRESIZEDIMAGE", 5, false, environment[7]),
                new SmartBasicLanguageObjectMethod("DRAWIMAGE", 3, false, environment[7]),
                new SmartBasicLanguageObjectMethod("SETPIXEL", 3, false, environment[7]),
                new SmartBasicLanguageObjectMethod("GETPIXEL", 2, true, environment[7]),
                new SmartBasicLanguageObjectMethod("GETRANDOMCOLOR", 0, true, environment[7]),
                new SmartBasicLanguageObjectMethod("GETCOLORFROMRGB", 3, true, environment[7]),
                new SmartBasicLanguageObjectMethod("CLEAR", 0, false, environment[7]),
                new SmartBasicLanguageObjectMethod("SHOWMESSAGE", 2, false, environment[7])
        };
        environment[7].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("BACKGROUNDCOLOR", false, environment[7]),
               new SmartBasicLanguageObjectField("BRUSHCOLOR", false, environment[7]),
               new SmartBasicLanguageObjectField("CANRESIZE", false, environment[7]),
               new SmartBasicLanguageObjectField("FONTBOLD", false, environment[7]),
               new SmartBasicLanguageObjectField("FONTITALIC", false, environment[7]),
               new SmartBasicLanguageObjectField("FONTNAME", false, environment[7]),
               new SmartBasicLanguageObjectField("FONTSIZE", false, environment[7]),
               new SmartBasicLanguageObjectField("HEIGHT", false, environment[7]),
               new SmartBasicLanguageObjectField("LASTKEY", true, environment[7]),
               new SmartBasicLanguageObjectField("LASTTEXT", true, environment[7]),
               new SmartBasicLanguageObjectField("LEFT", false, environment[7]),
               new SmartBasicLanguageObjectField("MOUSEX", true, environment[7]),
               new SmartBasicLanguageObjectField("MOUSEY", true, environment[7]),
               new SmartBasicLanguageObjectField("PENCOLOR", false, environment[7]),
               new SmartBasicLanguageObjectField("PENWIDTH", false, environment[7]),
               new SmartBasicLanguageObjectField("TITLE", false, environment[7]),
               new SmartBasicLanguageObjectField("TOP", false, environment[7]),
               new SmartBasicLanguageObjectField("WIDTH", false, environment[7])
        };
        environment[7].events = new SmartBasicLanguageObjectEvent[] {
                new SmartBasicLanguageObjectEvent("KEYDOWN", environment[7]),
                new SmartBasicLanguageObjectEvent("KEYUP", environment[7]),
                new SmartBasicLanguageObjectEvent("MOUSEDOWN", environment[7]),
                new SmartBasicLanguageObjectEvent("MOUSEMOVE", environment[7]),
                new SmartBasicLanguageObjectEvent("MOUSEUP", environment[7]),
                new SmartBasicLanguageObjectEvent("TEXTINPUT", environment[7])
        };
        environment[8] = new SmartBasicLanguageObject("IMAGELIST", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[8].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("GETHEIGHTOFIMAGE", 1, true, environment[8]),
                new SmartBasicLanguageObjectMethod("GETWIDTHOFIMAGE", 1, true, environment[8]),
                new SmartBasicLanguageObjectMethod("LOADIMAGE", 1, true, environment[8])
        };
        environment[9] = new SmartBasicLanguageObject("MATH", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[9].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("ABS", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("ARCCOS", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("ARCSIN", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("ARCTAN", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("CEILING", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("COS", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("FLOOR", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("GETDEGREES", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("GETRADIANS", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("GETRANDOMNUMBER", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("LOG", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("MAX", 2, true, environment[9]),
                new SmartBasicLanguageObjectMethod("MIN", 2, true, environment[9]),
                new SmartBasicLanguageObjectMethod("NATURALLOG", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("POWER", 2, true, environment[9]),
                new SmartBasicLanguageObjectMethod("REMAINDER", 2, true, environment[9]),
                new SmartBasicLanguageObjectMethod("ROUND", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("SIN", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("SQUAREROOT", 1, true, environment[9]),
                new SmartBasicLanguageObjectMethod("TAN", 1, true, environment[9]),
        };
        environment[9].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("PI", true, environment[9])
        };
        environment[10] = new SmartBasicLanguageObject("MOUSE", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[10].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("HIDECURSOR", 0, false, environment[10]),
                new SmartBasicLanguageObjectMethod("SHOWCURSOR", 0, false, environment[10])
        };
        environment[10].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("ISLEFTBUTTONDOWN", true, environment[10]),
               new SmartBasicLanguageObjectField("ISRIGHTBUTTONDOWN", true, environment[10]),
               new SmartBasicLanguageObjectField("MOUSEX", false, environment[10]),
               new SmartBasicLanguageObjectField("MOUSEY", false, environment[10])
        };
        environment[11] = new SmartBasicLanguageObject("NETWORK", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[11].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("DOWNLOADFILE", 1, true, environment[11]),
                new SmartBasicLanguageObjectMethod("GETWEBPAGECONTENTS", 1, true, environment[11])
        };
        environment[12] = new SmartBasicLanguageObject("PROGRAM", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[12].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("DELAY", 1, false, environment[12]),
                new SmartBasicLanguageObjectMethod("END", 0, false, environment[12]),
                new SmartBasicLanguageObjectMethod("GETARGUMENT", 1, true, environment[12])
        };
        environment[12].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("ARGUMENTCOUNT", true, environment[12]),
               new SmartBasicLanguageObjectField("DIRECTORY", true, environment[12])
        };
        environment[13] = new SmartBasicLanguageObject("SHAPES", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[13].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("ADDELLIPSE", 2, true, environment[13]),
                new SmartBasicLanguageObjectMethod("ADDIMAGE", 1, true, environment[13]),
                new SmartBasicLanguageObjectMethod("ADDLINE", 4, true, environment[13]),
                new SmartBasicLanguageObjectMethod("ADDRECTANGLE", 2, true, environment[13]),
                new SmartBasicLanguageObjectMethod("ADDTEXT", 1, true, environment[13]),
                new SmartBasicLanguageObjectMethod("ADDTRIANGLE", 6, true, environment[13]),
                new SmartBasicLanguageObjectMethod("ANIMATE", 4, false, environment[13]),
                new SmartBasicLanguageObjectMethod("GETLEFT", 1, true, environment[13]),
                new SmartBasicLanguageObjectMethod("GETOPACITY", 1, true, environment[13]),
                new SmartBasicLanguageObjectMethod("GETTOP", 1, true, environment[13]),
                new SmartBasicLanguageObjectMethod("HIDESHAPE", 1, false, environment[13]),
                new SmartBasicLanguageObjectMethod("MOVE", 3, false, environment[13]),
                new SmartBasicLanguageObjectMethod("REMOVE", 1, false, environment[13]),
                new SmartBasicLanguageObjectMethod("ROTATE", 2, false, environment[13]),
                new SmartBasicLanguageObjectMethod("SETOPACITY", 2, false, environment[13]),
                new SmartBasicLanguageObjectMethod("SETTEXT", 2, false, environment[13]),
                new SmartBasicLanguageObjectMethod("SHOWSHAPE", 1, false, environment[13]),
                new SmartBasicLanguageObjectMethod("ZOOM", 3, false, environment[13])
        };
        environment[14] = new SmartBasicLanguageObject("SOUND", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[14].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("PAUSE", 1, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAY", 1, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYANDWAIT", 1, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYBELLRING", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYBELLRINGANDWAIT", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYCHIME", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYCHIMEANDWAIT", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYCHIMES", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYCHIMESANDWAIT", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYCLICK", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYCLICKANDWAIT", 0, false, environment[14]),
                new SmartBasicLanguageObjectMethod("PLAYMUSIC", 1, false, environment[14]),
                new SmartBasicLanguageObjectMethod("STOP", 1, false, environment[14])
        };
        environment[15] = new SmartBasicLanguageObject("STACK", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[15].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("GETCOUNT", 1, true, environment[15]),
                new SmartBasicLanguageObjectMethod("POPVALUE", 1, true, environment[15]),
                new SmartBasicLanguageObjectMethod("PUSHVALUE", 2, false, environment[15])
        };
        environment[16] = new SmartBasicLanguageObject("TEXT", null, new SmartBasicLanguageObjectField[0], new SmartBasicLanguageObjectEvent[0]);
        environment[16].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("APPEND", 2, true, environment[16]),
                new SmartBasicLanguageObjectMethod("CONVERTTOLOWERCASE", 1, true, environment[16]),
                new SmartBasicLanguageObjectMethod("CONVERTTOUPPERCASE", 1, true, environment[16]),
                new SmartBasicLanguageObjectMethod("ENDSWITH", 2, true, environment[16]),
                new SmartBasicLanguageObjectMethod("GETCHARACTER", 1, true, environment[16]),
                new SmartBasicLanguageObjectMethod("GETCHARACTERCODE", 1, true, environment[16]),
                new SmartBasicLanguageObjectMethod("GETINDEXOF", 2, true, environment[16]),
                new SmartBasicLanguageObjectMethod("GETLENGTH", 1, true, environment[16]),
                new SmartBasicLanguageObjectMethod("GETSUBTEXT", 3, true, environment[16]),
                new SmartBasicLanguageObjectMethod("GETSUBTEXTTOEND", 2, true, environment[16]),
                new SmartBasicLanguageObjectMethod("ISSUBTEXT", 2, true, environment[16]),
                new SmartBasicLanguageObjectMethod("STARTSWITH", 2, true, environment[16])
        };
        environment[17] = new SmartBasicLanguageObject("TEXTWINDOW", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[17].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("CLEAR", 0, false, environment[17]),
                new SmartBasicLanguageObjectMethod("HIDE", 0, false, environment[17]),
                new SmartBasicLanguageObjectMethod("PAUSE", 0, false, environment[17]),
                new SmartBasicLanguageObjectMethod("PAUSEIFVISIBLE", 0, false, environment[17]),
                new SmartBasicLanguageObjectMethod("PAUSEWITHOUTMESSAGE", 0, false, environment[17]),
                new SmartBasicLanguageObjectMethod("READ", 0, true, environment[17]),
                new SmartBasicLanguageObjectMethod("READNUMBER", 0, true, environment[17]),
                new SmartBasicLanguageObjectMethod("SHOW", 0, false, environment[17]),
                new SmartBasicLanguageObjectMethod("WRITE", 1, false, environment[17]),
                new SmartBasicLanguageObjectMethod("WRITELINE", 1, false, environment[17])
        };
        environment[17].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("BACKGROUNDCOLOR", false, environment[17]),
               new SmartBasicLanguageObjectField("CURSORLEFT", false, environment[17]),
               new SmartBasicLanguageObjectField("CURSORTOP", false, environment[17]),
               new SmartBasicLanguageObjectField("FOREGROUNDCOLOR", false, environment[17]),
               new SmartBasicLanguageObjectField("LEFT", false, environment[17]),
               new SmartBasicLanguageObjectField("TITLE", false, environment[17]),
               new SmartBasicLanguageObjectField("TOP", false, environment[17]),
        };
        environment[18] = new SmartBasicLanguageObject("TIMER", null, null, null);
        environment[18].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("PAUSE", 0, false, environment[18]),
                new SmartBasicLanguageObjectMethod("RESUME", 0, false, environment[18])
        };
        environment[18].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("INTERVAL", false, environment[18])
        };
        environment[18].events = new SmartBasicLanguageObjectEvent[] {
               new SmartBasicLanguageObjectEvent("TICK", environment[18])
        };
        environment[19] = new SmartBasicLanguageObject("TURTLE", null, null, new SmartBasicLanguageObjectEvent[0]);
        environment[19].methods = new SmartBasicLanguageObjectMethod[] {
                new SmartBasicLanguageObjectMethod("HIDE", 0, false, environment[19]),
                new SmartBasicLanguageObjectMethod("MOVE", 1, false, environment[19]),
                new SmartBasicLanguageObjectMethod("MOVETO", 2, false, environment[19]),
                new SmartBasicLanguageObjectMethod("PENDOWN", 0, false, environment[19]),
                new SmartBasicLanguageObjectMethod("PENUP", 0, false, environment[19]),
                new SmartBasicLanguageObjectMethod("SHOW", 0, false, environment[19]),
                new SmartBasicLanguageObjectMethod("TURN", 1, false, environment[19]),
                new SmartBasicLanguageObjectMethod("TURNLEFT", 0, false, environment[19]),
                new SmartBasicLanguageObjectMethod("TURNRIGHT", 0, false, environment[19])
        };
        environment[19].fields = new SmartBasicLanguageObjectField[] {
               new SmartBasicLanguageObjectField("ANGLE", false, environment[19]),
               new SmartBasicLanguageObjectField("SPEED", false, environment[19]),
               new SmartBasicLanguageObjectField("X", false, environment[19]),
               new SmartBasicLanguageObjectField("Y", false, environment[19]),
        };

        SmartBasicSubroutine main = new SmartBasicSubroutine();
        main.name = MAIN_SUBROUTINE_NAME;
        subroutines.put(MAIN_SUBROUTINE_NAME, main);
    }

    public boolean parse(String fileName)
    {
        ProgramParser parser = new ProgramParser(this, fileName);

        return parser.parsingSuccessful;
    }
}

class ProgramParser {
    public boolean parsingSuccessful;

    private SmartBasicProgram program;
    private LexicalAnalyzer scanner;

    //TODO: create methods for processing expressions

   private void program(SmartBasicSubroutine subroutine) throws Exception {
       while (scanner.currentLexeme != SourceLexemeType.FILE_END) {
           if (scanner.currentLexeme == SourceLexemeType.ENDSUB) {
               scanner.getNextLexeme();
               if (subroutine.name.equals(SmartBasicProgram.MAIN_SUBROUTINE_NAME)) {
                   scanner.showErrorMessage("unexpected lexeme");
                   scanner.getNextLexeme();
               } else {
                   if (!scanner.isEndingLexeme()) {
                       scanner.showErrorMessage("need end of line");
                   } else {
                       scanner.getNextLexeme();
                   }
                   return;
               }
           }
           if (scanner.currentLexeme == SourceLexemeType.SUB) {
               scanner.getNextLexeme();
               if (scanner.currentLexeme != SourceLexemeType.IDENTIFIER) {
                   scanner.showErrorMessage("need subroutine name");
                   scanner.skipAllToTheEndOfLine();
               } else {
                   String subName = scanner.currentString;
                   scanner.getNextLexeme();
                   if (!scanner.isEndingLexeme()) {
                       scanner.showErrorMessage("need end of line");
                   } else {
                       scanner.getNextLexeme();
                   }
                   SmartBasicSubroutine sub = new SmartBasicSubroutine();
                   sub.name = subName;
                   if (program.subroutines.containsKey(subName)) {
                       scanner.showErrorMessage("such subroutine already exists");
                   } else {
                       program.subroutines.put(subName, sub);
                   }
                   program(sub);
               }
           }
           // TODO: if you have created methods for processing expressions then create methods for processing operators
       }
       if (!subroutine.name.equals(SmartBasicProgram.MAIN_SUBROUTINE_NAME)) {
           scanner.showErrorMessage("unexpected end of file");
           throw new Exception("fileend");
       }
   }

    public ProgramParser(SmartBasicProgram program, String fileName) {
        scanner = new LexicalAnalyzer(fileName);
        if (!scanner.initializationSuccessful) {
            parsingSuccessful = false;
            return;
        }

        try {
            scanner.getNextLexeme();
            program(program.subroutines.get(SmartBasicProgram.MAIN_SUBROUTINE_NAME));
        } catch (Exception e) {
        }

        if (scanner.errorsCount > 0) {
            parsingSuccessful = false;
        } else {
            parsingSuccessful = true;
        }
    }
}