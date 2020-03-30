package classes.impl

import model.{Actions, Person, Temperature}

/**
 * This class validates the user input and returns the desired result based on the action.
 *
 * @author Pramoda Kumar Sabat
 */
trait InputProcessor {
  def indexOfInvalidAction(person: Person): Int
  def validateAndReturnResult(input: String): String
}

class InputProcessorImpl(validation: Validation[Person]) extends InputProcessor {

  /**
   * Validates the input action and returns the index of invalid action
   * @param person Input to validate and process
   * @return The index of invalid action
   */

  def indexOfInvalidAction(person: Person): Int = {
    validation.indexOfInvalidAction(person)
  }

  /**
   * Validate and process the user action and return the final result
   * @param input Input to validate and process
   * @return Returns the final result
   */

  def validateAndReturnResult(input: String): String = {
    def isValidInput(input: String): Boolean = {
      val pattern: String = "^(HOT|COLD)\\s[1-8](,[1-8])*$"
      input.matches(pattern)
    }

    def getResult(): String = {
      if(isValidInput(input)){
        val inputTemperature = input.split(" ").headOption
        val inputAction = input.split(" ").lastOption

        (inputTemperature, inputAction) match {
          case (Some(temperature: String) , Some(actions: String)) =>
            val person = Person(temperature, actions)
            processResults(person)
          case _ => s"Error: No temperature or command provided"
        }
      } else {
        s"Error: Not a valid input"
      }
    }
    getResult
  }

  /**
   * Returns comma separated actions based on the index of invalid action
   * @param person The input to process
   * @return All actions
   */

  private def processResults(person: Person): String = {
    val FAIL = "fail"
    val SEPARATED = ", "
    val endIndex = indexOfInvalidAction(person)
    if (endIndex < 0)
      return FAIL;

    val actions: List[Actions] = person.actions.slice(0, endIndex)
    val temperature = person.temperature

    temperature match {
      case Temperature.HOT =>
        if(endIndex < 6){
          val actionWithFail = actions.map(_.getHotResponse) ::: List(FAIL)
          s"${actionWithFail.mkString(SEPARATED)}"
        } else {
          s"${actions.map(_.getHotResponse).mkString(SEPARATED)}"
        }

      case Temperature.COLD =>
        if(endIndex < 8){
          val actionWithFail = actions.map(_.getColdResponse) ::: List(FAIL)
          s"${actionWithFail.mkString(SEPARATED)}"
        } else {
          s"${actions.map(_.getColdResponse).mkString(SEPARATED)}"
        }
    }
  }
}
