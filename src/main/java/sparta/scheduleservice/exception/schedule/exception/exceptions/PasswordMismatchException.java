package sparta.scheduleservice.exception.schedule.exception.exceptions;

import sparta.scheduleservice.exception.schedule.exception.ScheduleExceptionMessages;

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException() {
        super(ScheduleExceptionMessages.PASSWORD_MISMATCH.getErrorMessage());
    }
}
