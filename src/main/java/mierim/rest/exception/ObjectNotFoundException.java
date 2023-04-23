package mierim.rest.exception;

public class ObjectNotFoundException extends  RuntimeException{

    public ObjectNotFoundException(String s) {
    }

    public class DataIntegrityViolationException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public DataIntegrityViolationException(String message, Throwable cause) {
            super(
                    message,
                    cause
            );
        }

        public DataIntegrityViolationException(String message) {
            super(
                    message
            );
        }

    }

}
