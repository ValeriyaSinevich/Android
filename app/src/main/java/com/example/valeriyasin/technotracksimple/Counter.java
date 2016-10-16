package com.example.valeriyasin.technotracksimple;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by valeriyasin on 10/13/16.
 */
public class Counter {
    List< String> ones = new ArrayList<>();
    List< String> decades = new ArrayList<>();

    String hundred = "hundred";
    String thousand = "thousand";
    String million = "million";

    Counter() {
        ones.add("");
        ones.add("one");
        ones.add("two");
        ones.add("three");
        ones.add("four");
        ones.add("five");
        ones.add("six");
        ones.add("seven");
        ones.add("eight");
        ones.add("nine");
        ones.add("ten");
        ones.add("eleven");
        ones.add("twelve");
        ones.add("thirteen");
        ones.add("fourteen");
        ones.add("fifteen");
        ones.add("sixteen");
        ones.add("seventeen");
        ones.add("eighteen");
        ones.add("nineteen");

        decades.add("");
        decades.add("ten");
        decades.add("twenty");
        decades.add("thirty");
        decades.add("fifty");
        decades.add("sixty");
        decades.add("seventy");
        decades.add("eighty");
        decades.add("ninety");
    }

    public String parseLessThanThousand(int number) {
        StringBuilder builder = new StringBuilder();
        int hundreds = number / 100;
        int decade = (number % 100) / 10;
        int one;
        if (decade < 2) {
            decade = 0;
            one = number % 100;
        }
        else {
            one = (number % 10);
        }
        builder.append(String.valueOf(ones.get(hundreds)));
        if (hundreds > 0) {
            builder.append(" hundred");
        }
        builder.append(" ");
        builder.append(String.valueOf(decades.get(decade)));
        builder.append(" ");
        builder.append(String.valueOf(ones.get(one)));
        return builder.toString();
    }

    public String parse(int number) {
        StringBuilder builder = new StringBuilder();
        int millions = number / 1000000;
        int thousands = (number % 1000000) / 1000;
        int one = number % 1000;

        builder.append(parseLessThanThousand(millions));
        if (millions > 0) {
            builder.append(" million");
        }
        builder.append(" ");
        builder.append(parseLessThanThousand(thousands));
        if (thousands > 0) {
            builder.append(" thousand");
        }
        builder.append(" ");
        builder.append(parseLessThanThousand(one));
        return builder.toString().trim();
    }
}
