package com.Spring.TodoList.request;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The class implements the {@link DateValidator} interface and checks that the date given is in the format required.
 */
public class DateValidatorUsingLocalDate implements DateValidator {
    private String dateFormat;

    /**
     * Constructor for the DateValidatorUsingLocalDate class
     *
     * @param dateFormatter not null
     */
    public DateValidatorUsingLocalDate(String dateFormatter) {
        this.dateFormat = dateFormatter;
    }

    /**
     * The method gets a string and checks if it's in the date format required (according to RSP3339, section 5.6)
     *
     * @param dateStr not null
     * @return boolean not null
     */
    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
