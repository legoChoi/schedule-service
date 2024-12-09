package sparta.scheduleservice.shared.exception.schedule.exception;

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException() {
        super(ScheduleExceptionMessages.PASSWORD_MISMATCH.getErrorMessage());
    }
}
