package validators.impl

import model.{Actions, Person, Temperature}

/**
 * This class validate and returns the index of invalid action the following rule
 * You cannot put on socks when it is hot
 * You cannot put on a jacket when it is hot
 *
 * @author Pramoda Kumar Sabat
 */

trait ClothForTemperature extends Validator[Person]{
  def validClothForTemperature(person: Person): Boolean
}

class ClothForTemperatureImpl extends ClothForTemperature {

  override def validate(person: Person): Boolean = {
    validClothForTemperature(person)
  }

  override def indexOfInvalidItem(person: Person): Int = {
    val MAX_VALUE = 10
    val isValid = validate(person)
    if(!isValid) {
      val actions = person.actions

      val socksIndex =
        if (actions.contains(Actions.PUT_ON_SOCKS))
          actions.indexOf(Actions.PUT_ON_SOCKS)
        else MAX_VALUE

      val jacketIndex =
        if (actions.contains(Actions.PUT_ON_JACKET))
          actions.indexOf(Actions.PUT_ON_JACKET)
        else MAX_VALUE

      if (socksIndex > jacketIndex)
        jacketIndex
      else socksIndex
    } else person.actions.size
  }

  def validClothForTemperature(person: Person): Boolean = {
    val actions = person.actions
    person.temperature match {
      case Temperature.HOT => !(actions.contains(Actions.PUT_ON_SOCKS)
        || actions.contains(Actions.PUT_ON_JACKET))
      case Temperature.COLD => true
    }
  }
}