package model

import enumeratum.EnumEntry.Uppercase
import enumeratum.{Enum, EnumEntry}

sealed trait Temperature extends EnumEntry with Uppercase

object Temperature extends Enum[Temperature] {
  case object HOT extends Temperature {
    def maxLength(): Int = 6
  }
  case object COLD extends Temperature {
    def maxLength(): Int = 8
  }

  val values = findValues

  def get(temperature: String): Temperature = {
    if(values.map(_.entryName).toList.contains(temperature)){
      values(values.map(_.entryName).toList.indexOf(temperature))
    } else {
      throw new RuntimeException("Error: Invalid Temperature");
    }
  }
}

