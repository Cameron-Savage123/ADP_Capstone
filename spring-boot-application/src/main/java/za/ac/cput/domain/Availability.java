/* Availability.java
   Availability POJO class
   Author: Hope Ringane (221174109)
   Date: 11 May 2025 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;

    // Default constructor
    public Availability() {}

    // Builder constructor
    private Availability(Builder builder) {
        this.availabilityId = builder.availabilityId;
        this.dayOfWeek = builder.dayOfWeek;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    // Getters
    public Long getAvailabilityId() { return availabilityId; }
    public String getDayOfWeek() { return dayOfWeek; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    @Override
    public String toString() {
        return "Availability{" +
                "availabilityId=" + availabilityId +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private Long availabilityId;
        private String dayOfWeek;
        private String startTime;
        private String endTime;

        public Builder setAvailabilityId(Long availabilityId) {
            this.availabilityId = availabilityId;
            return this;
        }

        public Builder setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        // ✅ copy method
        public Builder copy(Availability availability) {
            this.availabilityId = availability.availabilityId;
            this.dayOfWeek = availability.dayOfWeek;
            this.startTime = availability.startTime;
            this.endTime = availability.endTime;
            return this;
        }

        public Availability build() {
            return new Availability(this);
        }
    }
}
