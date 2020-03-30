package validators.impl

import model.{Actions, Person}

/**
 * This class validate and returns the index of invalid action the following rule.
 *
 * Socks must be put on before footwear
 * Pants must be put on before footwear
 * The shirt must be put on before the headwear or jacket
 *
 * @author Pramoda Kumar Sabat
 */

trait Ordering extends Validator [Person] {
  def isValidOrdering(person: Person): Boolean
}

class OrderingImpl extends Ordering {
  override def validate(person: Person): Boolean = isValidOrdering(person)

  override def indexOfInvalidItem(person: Person): Int = {
    val INVALID_INPUT = -1
    val isValid = validate(person)
    if(!isValid) {
      val actions = person.actions

      if (isSocksAfterShoes(actions)) actions.indexOf(Actions.PUT_ON_FOOTWEAR)
      else if (isPantsAfterShoes(actions)) actions.indexOf(Actions.PUT_ON_FOOTWEAR)
      else if (isShirtAfterHeadWear(actions)) actions.indexOf(Actions.PUT_ON_HEAD_WEAR)
      else if (isShirtAfterJacket(actions)) actions.indexOf(Actions.PUT_ON_JACKET)
      else INVALID_INPUT

    } else person.actions.size
  }

  def isValidOrdering(person: Person): Boolean = {
    val actions = person.actions
    !(isSocksAfterShoes(actions)
      || isPantsAfterShoes(actions)
      || isShirtAfterHeadWear(actions)
      || isShirtAfterJacket(actions))
  }

  private def isSocksAfterShoes(actions: List[Actions]) =
    if (actions.contains(Actions.PUT_ON_SOCKS) && actions.contains(Actions.PUT_ON_FOOTWEAR)) {
      actions.indexOf(Actions.PUT_ON_SOCKS) > actions.indexOf(Actions.PUT_ON_FOOTWEAR)
    } else false

  private def isPantsAfterShoes(actions: List[Actions]) =
    if (actions.contains(Actions.PUT_ON_PANTS) && actions.contains(Actions.PUT_ON_FOOTWEAR)) {
      actions.indexOf(Actions.PUT_ON_PANTS) > actions.indexOf(Actions.PUT_ON_FOOTWEAR)
    } else false

  private def isShirtAfterHeadWear(actions: List[Actions]) =
    if (actions.contains(Actions.PUT_ON_SHIRT) && actions.contains(Actions.PUT_ON_HEAD_WEAR)) {
      actions.indexOf(Actions.PUT_ON_SHIRT) > actions.indexOf(Actions.PUT_ON_HEAD_WEAR)
    } else false

  private def isShirtAfterJacket(actions: List[Actions]) =
    if (actions.contains(Actions.PUT_ON_SHIRT) && actions.contains(Actions.PUT_ON_JACKET)) {
      actions.indexOf(Actions.PUT_ON_SHIRT) > actions.indexOf(Actions.PUT_ON_JACKET)
    } else false
}
