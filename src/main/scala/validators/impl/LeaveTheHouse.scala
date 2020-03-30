package validators.impl

import model.{Actions, Person, Temperature}

/**
 * This class validate and returns the index of invalid action the following rule.
 * You cannot leave the house until all items of clothing are on (except socks and a jacket when it’s hot)
 *
 * @author Pramoda Kumar Sabat
 */

trait LeaveTheHouse extends Validator[Person] {
  def isLeaveTheHouse(person: Person): Boolean
}

class LeaveTheHouseImpl extends LeaveTheHouse {
  override def validate(person: Person): Boolean = isLeaveTheHouse(person)

  override def indexOfInvalidItem(person: Person): Int = {
    val INVALID_INPUT = -1
    val isValid = validate(person)
    if(!isValid) {
      val actions = person.actions
      if (!isLeaveTheHouseLastAction(person.actions))
        person.actions.size
      else if (actions.contains(Actions.LEAVE_HOUSE)
        && !isCorrectClothingOrder(person))
        actions.indexOf(Actions.LEAVE_HOUSE)
      else
        INVALID_INPUT
    } else person.actions.size
  }

  def isLeaveTheHouse(person: Person): Boolean = {
    isLeaveTheHouseLastAction(person.actions) && isCorrectClothingOrder(person)
  }

  private def isLeaveTheHouseLastAction(actions: List[Actions]): Boolean = {
    actions.contains(Actions.LEAVE_HOUSE) && actions(actions.size -1).equals(Actions.LEAVE_HOUSE)
  }

  private def isCorrectClothingOrder(person: Person): Boolean = {
    person.temperature match {
      case Temperature.HOT => !(person.actions.size != Temperature.HOT.maxLength)
      case Temperature.COLD => !(person.actions.size != Temperature.COLD.maxLength)
    }
  }
}

