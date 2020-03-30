package classes.impl

import model.Person
import validators.impl._

/**
 * This class applies all the following validations, process actions and returns the result accordingly.
 *
 * You start in the house with your PJ’s on
 * Pajamas must be taken off before anything else can be put on
 * Only 1 piece of each type of clothing may be put on
 * You cannot put on socks when it is hot
 * You cannot put on a jacket when it is hot
 * Socks must be put on before footwear
 * Pants must be put on before footwear
 * The shirt must be put on before the head wear or jacket
 * You cannot leave the house until all items of clothing are on (except socks and a jacket when it’s hot)
 * If an invalid command is issued, respond with “fail” and stop processing commands
 *
 * @author Pramoda Kumar Sabat
 */

sealed trait BasicValidation[A]{
  def validate(person: A): Boolean
  def indexOfInvalidAction(person: A): Int
}

trait Validation[A] extends BasicValidation[Person]{
  def getValidators: List[Validator[Person]]
}

class ValidationImpl extends Validation[Person] {
  override def validate(person: Person): Boolean = {
    getValidators.map(_.validate(person)).headOption.getOrElse(false)
  }

  override def indexOfInvalidAction(person: Person): Int = {
    val index = getValidators.find(validator => (!validator.validate(person)))
      .map(validator => validator.indexOfInvalidItem(person))
    index.headOption.getOrElse(person.actions.size)
  }

  override def getValidators: List[Validator[Person]] = {
    List(new TakeOffPajamaImpl, new OrderingImpl, new DuplicateEntryImpl, new ClothForTemperatureImpl, new LeaveTheHouseImpl)
  }
}
