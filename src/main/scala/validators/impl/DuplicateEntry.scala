package validators.impl

import model.Person

/**
 * This class validate and returns the index of invalid action the following rule.
 * Only 1 piece of each type of clothing may be put on.
 *
 * @author Pramoda Kumar Sabat
 */

trait DuplicateEntry extends Validator[Person] {
  def hasDuplicateEntry(person: Person): Boolean
}

class DuplicateEntryImpl extends DuplicateEntry  {
  override def validate(person: Person): Boolean = !hasDuplicateEntry(person)

  override def indexOfInvalidItem(person: Person): Int = {
    val isValid = validate(person)
    if(!isValid) {
      val actions = person.actions.map(_.entryName)
      actions.groupBy(identity).collect{case (a, list) if list.size > 1 => actions.lastIndexOf(a)}.headOption.getOrElse(person.actions.size)
    } else person.actions.size
  }

  def hasDuplicateEntry(person: Person): Boolean = {
    person.actions.distinct.size != person.actions.size
  }
}
