package validators.impl

/**
 * This trait validates the input and return the index of invalid item.
 * @tparam A It is the input which will be validated and return the index
 *
 * @author Pramoda Kumar Sabat
 */

trait Validator[A] {

  /**
   * Validates the input
   * @param person The input which will be validated
   * @return
   */
  def validate(person: A): Boolean

  /**
   * Return the index of the invalid action
   * @param person The input which will be validated
   * @return Returns the index of the invalid action
   */
  def indexOfInvalidItem(person: A): Int
}
