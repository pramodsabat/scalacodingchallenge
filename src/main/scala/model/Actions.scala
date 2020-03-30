package model

import enumeratum.{Enum, EnumEntry}

sealed trait Actions extends EnumEntry {
  def getHotResponse: String
  def getColdResponse: String
}

object Actions extends Enum[Actions] {
  case object PUT_ON_FOOTWEAR extends Actions{
    def getHotResponse: String = "sandals"
    def getColdResponse: String = "boots"
  }

  case object PUT_ON_HEAD_WEAR extends Actions{
    def getHotResponse: String = "sunglasses"
    def getColdResponse: String = "hat"
  }

  case object PUT_ON_SOCKS extends Actions{
    def getHotResponse: String = "fail"
    def getColdResponse: String = "socks"
  }

  case object PUT_ON_SHIRT extends Actions{
    def getHotResponse: String = "shirt"
    def getColdResponse: String = "shirt"
  }

  case object PUT_ON_JACKET extends Actions{
    def getHotResponse: String = "fail"
    def getColdResponse: String = "jacket"
  }

  case object PUT_ON_PANTS extends Actions{
    def getHotResponse: String = "shorts"
    def getColdResponse: String = "pants"
  }

  case object LEAVE_HOUSE extends Actions{
    def getHotResponse: String = "leaving house"
    def getColdResponse: String = "leaving house"
  }

  case object TAKE_OFF_PAJAMAS extends Actions{
    def getHotResponse: String = "Removing PJs"
    def getColdResponse: String = "Removing PJs"
  }

  val values = findValues
}

case class Person(temperature: Temperature, actions: List[Actions])

object Person {
  def apply(temperature: String, action: String): Person = {
    val actions: List[Int] = action.split(",").map(_.toInt-1).toList
    val userAction = actions.map(action => Actions.values(action))
    Person(Temperature.get(temperature), userAction)
  }
}
