package com.starplex.smartbasic;

import java.util.LinkedList;

/**
 * Created by Влад on 25.05.2014.
 */
public class SmartBasicSubroutine {
    public String name;

    LinkedList<SmartBasicOperator> operators = new LinkedList<SmartBasicOperator>();
    LinkedList<SmartBasicLabel> labels = new LinkedList<SmartBasicLabel>(); // points to position of next operator
}

class SmartBasicLabel {
    public long followingOperator;
    public String name;
}

enum SmartBasicOperatorType {
    NONE,
    SUBROUTINE_CALL,
    METHOD_CALL,
    ASSIGNMENT,
    CONDITION,
    LOOP,
    FOR_LOOP,
    GO_TO
}

class SmartBasicOperator {
    SmartBasicOperatorType type = SmartBasicOperatorType.NONE;

    // TODO: Add attribute fields to class
}

enum SmartBasicOperationType {
    NONE,
    NUMBER_INTEGER,
    NUMBER_DOUBLE,
    STRING,
    VARIABLE,

    UNARY_PLUS,
    UNARY_MINUS,
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION,

    EQUALITY_TEST,
    INEQUALITY_TEST,
    LESS_EQUAL_TEST,
    GREATER_EQUAL_TEST,
    LESS_TEST,
    MORE_TEST,

    MEMBER_ACCESS,
    ARRAY_ACCESS,

    LOGICAL_OR,
    LOGICAL_AND,

    OBJECT_MEMBER_CALL,
    OBJECT_VARIABLE_USING,
    OBJECT_EVENT_USING
}

class SmartBasicOperation {
    public SmartBasicOperatorType type = SmartBasicOperatorType.NONE;

    public long attribute_integer;
    public double attribute_real;
    public String attribute_string;
    public SmartBasicVariable attribute_variable;
    public SmartBasicSubroutine attribute_subroutine;

    SmartBasicLanguageObjectMethod attribute_object_method;
    SmartBasicLanguageObjectField attribute_object_field;
    SmartBasicLanguageObjectEvent attribute_object_event;

    public SmartBasicOperation operands[];
}