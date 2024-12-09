package sparta.scheduleservice.exception.schedule.exception.exceptions;

import sparta.scheduleservice.exception.schedule.exception.ScheduleExceptionMessages;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException() {
        super(ScheduleExceptionMessages.SCHEDULE_NOT_FOUND.getErrorMessage());
    }
}
