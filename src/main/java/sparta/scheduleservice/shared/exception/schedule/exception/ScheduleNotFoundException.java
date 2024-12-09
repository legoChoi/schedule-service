package sparta.scheduleservice.shared.exception.schedule.exception;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException() {
        super(ScheduleExceptionMessages.SCHEDULE_NOT_FOUND.getErrorMessage());
    }
}
