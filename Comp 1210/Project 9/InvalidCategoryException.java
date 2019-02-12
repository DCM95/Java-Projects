 /**
  an exception to be thrown when the category taken in is incorrect.
 */

public class InvalidCategoryException extends RuntimeException {
/**
  the constructor for the exception.
  @param category the character representing the category.
 */
   public InvalidCategoryException(StringQ category) {
      super("For category: " + "\"" + category + "\"");
   }

}