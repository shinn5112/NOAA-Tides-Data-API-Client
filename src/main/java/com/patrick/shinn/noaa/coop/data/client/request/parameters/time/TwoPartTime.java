package com.patrick.shinn.noaa.coop.data.client.request.parameters.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Base class for time parameters that are composed of two parts.
 * @since 1.0
 * @author Patrick Shinn
 */
public abstract class TwoPartTime {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyddMM");

    /**
     * Creates a formated date string.
     * @param date date to format.
     * @return formatted date string.
     * @since 1.0
     */
    String formatDate(Date date){
        return dateFormat.format(date);
    }
}
