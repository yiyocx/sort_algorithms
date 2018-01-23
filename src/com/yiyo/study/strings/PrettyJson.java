package com.yiyo.study.strings;

import java.util.ArrayList;
import java.util.List;

public class PrettyJson {

    /*
    Pretty print a json object using proper indentation.

    - Every inner brace should increase one indentation to the following lines.
    - Every close brace should decrease one indentation to the same line and the following lines.
    - The indents can be increased with an additional ‘\t’

    [] and {} are only acceptable braces in this case.
    Assume for this problem that space characters can be done away with.
    Your solution should return a list of strings, where each entry corresponds to a single line.
    The strings should not have “\n” character in them.
     */
    public static void main(String[] args) {
        PrettyJson pretty = new PrettyJson();

        String json1 = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        List<String> prettyJson = pretty.prettyJSON(json1);
        for (String line : prettyJson) {
            System.out.println(line);
        }

        String json2 = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        List<String> prettyJson2 = pretty.prettyJSON(json2);
        for (String line : prettyJson2) {
            System.out.println(line);
        }

        String json3 = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        List<String> prettyJson3 = pretty.prettyJSON(json3);
        for (String line : prettyJson3) {
            System.out.println(line);
        }
    }

    private List<String> prettyJSON(String a) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int indentation = 0;

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            switch (c) {
                case '{':
                case '[':
                    if (current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuilder();
                    }
                    applyIndentation(current, indentation);
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuilder();
                    indentation++;
                    break;
                case ']':
                case '}':
                    if (current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuilder();
                    }
                    indentation--;
                    applyIndentation(current, indentation);
                    current.append(c);
                    break;
                case ',':
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuilder();
                    break;
                default:
                    if (current.length() == 0) {
                        applyIndentation(current, indentation);
                    }
                    current.append(c);
            }
        }

        if (current.length() > 0) {
            result.add(current.toString());
        }
        return result;
    }

    private void applyIndentation(StringBuilder current, int indentation) {
        for (int j = 0; j < indentation; j++) {
            current.append('\t');
        }
    }
}
