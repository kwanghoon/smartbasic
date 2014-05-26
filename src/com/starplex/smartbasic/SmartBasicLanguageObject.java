package com.starplex.smartbasic;

/**
 * Created by Влад on 25.05.2014.
 */
public class SmartBasicLanguageObject {
    public String name;

    public SmartBasicLanguageObjectMethod methods[];
    public SmartBasicLanguageObjectField fields[];
    public SmartBasicLanguageObjectEvent events[];

    public SmartBasicLanguageObject(String name, SmartBasicLanguageObjectMethod methods[], SmartBasicLanguageObjectField fields[], SmartBasicLanguageObjectEvent events[])
    {
        this.name = name;
        this.fields = fields;
        this.methods = methods;
        this.events = events;
    }
}

class SmartBasicLanguageObjectMethod {
    public String name;
    public int params_count;
    public boolean isFunction;
    public SmartBasicLanguageObject parent;

    public SmartBasicLanguageObjectMethod(String name, int params_count, boolean isFunction, SmartBasicLanguageObject parent)
    {
        this.name = name;
        this.params_count = params_count;
        this.isFunction = isFunction;
        this.parent = parent;
    }
}

class SmartBasicLanguageObjectField {
    public String name;
    public boolean isReadOnly;
    public SmartBasicLanguageObject parent;

    public SmartBasicLanguageObjectField(String name, boolean isReadOnly, SmartBasicLanguageObject parent)
    {
        this.name = name;
        this.isReadOnly = isReadOnly;
        this.parent = parent;
    }
}

class SmartBasicLanguageObjectEvent {
    public String name;
    public SmartBasicLanguageObject parent;

    public SmartBasicLanguageObjectEvent(String name, SmartBasicLanguageObject parent)
    {
        this.name = name;
        this.parent = parent;
    }
}
