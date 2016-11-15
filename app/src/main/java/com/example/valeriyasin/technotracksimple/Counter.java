package com.example.valeriyasin.technotracksimple;

import android.content.Context;
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

    Counter(Context context) {
        ones.add(context.getResources().getString(R.string.empty));
        ones.add(context.getResources().getString(R.string.one));
        ones.add(context.getResources().getString(R.string.two));
        ones.add(context.getResources().getString(R.string.three));
        ones.add(context.getResources().getString(R.string.four));
        ones.add(context.getResources().getString(R.string.five));
        ones.add(context.getResources().getString(R.string.six));
        ones.add(context.getResources().getString(R.string.seven));
        ones.add(context.getResources().getString(R.string.eight));
        ones.add(context.getResources().getString(R.string.nine));
        ones.add(context.getResources().getString(R.string.ten));
        ones.add(context.getResources().getString(R.string.eleven));
        ones.add(context.getResources().getString(R.string.twelve));
        ones.add(context.getResources().getString(R.string.thirteen));
        ones.add(context.getResources().getString(R.string.fourteen));
        ones.add(context.getResources().getString(R.string.fifteen));
        ones.add(context.getResources().getString(R.string.sixteen));
        ones.add(context.getResources().getString(R.string.seventeen));
        ones.add(context.getResources().getString(R.string.eighteen));
        ones.add(context.getResources().getString(R.string.nineteen));

        decades.add(context.getResources().getString(R.string.empty));
        decades.add(context.getResources().getString(R.string.ten));
        decades.add(context.getResources().getString(R.string.twenty));
        decades.add(context.getResources().getString(R.string.thirty));
        decades.add(context.getResources().getString(R.string.fourty));
        decades.add(context.getResources().getString(R.string.fifty));
        decades.add(context.getResources().getString(R.string.sixty));
        decades.add(context.getResources().getString(R.string.seventy));
        decades.add(context.getResources().getString(R.string.eighty));
        decades.add(context.getResources().getString(R.string.ninety));
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
