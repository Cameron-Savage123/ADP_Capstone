/*  AvailabilityFactory.java
    Availability Factory class
    Author: Hope Ringane (221174109)
    Date: 18 May 2025
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Availability;
import za.ac.cput.util.Helper;

public class AvailabilityFactory {

    public static Availability createAvailability(String dayOfWeek,
                                                  String startTime,
                                                  String endTime) {
        // Optional validation
        if (Helper.isNullOrEmpty(dayOfWeek) ||
                Helper.isNullOrEmpty(startTime) ||
                Helper.isNullOrEmpty(endTime)) {
            throw new IllegalArgumentException("All fields are required");
        }

        return new Availability.Builder()
                .setDayOfWeek(dayOfWeek)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .build();
    }
}
