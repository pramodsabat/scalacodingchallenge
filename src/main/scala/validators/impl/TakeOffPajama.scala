package validators.impl

import model.{Actions, Person}

/**
 * This class validate and returns the index of invalid action the following rule.
 * Pajamas must be taken off before anything else can be put on
 *
 * @author Pramoda Kumar Sabat
 */

trait TakeOffPajama extends Validator[Person] {
  def isPajamaPutOn(person: Person): Boolean
}

class TakeOffPajamaImpl extends TakeOffPajama {

  override def validate(person: Person): Boolean = isPajamaPutOn(person)

  override def indexOfInvalidItem(person: Person): Int = {
    val INVALID_INPUT = -1
    val isValid = validate(person)
    if(!isValid) {
      val actions = person.actions
      actions.headOption match {
        case Some(action) =>
          if(!action.equals(Actions.TAKE_OFF_PAJAMAS)) actions.indexOf(Actions.TAKE_OFF_PAJAMAS) else actions.size
        case None => INVALID_INPUT
      }
    } else person.actions.size
  }

  def isPajamaPutOn(person: Person): Boolean = {
    person.actions.headOption.map(_.equals(Actions.TAKE_OFF_PAJAMAS)).getOrElse(false)
  }
}
