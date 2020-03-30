package validators.impl

import model.{Person, Temperature}
import org.scalatest.wordspec.AnyWordSpec

class ClothForTemperatureSpecs extends AnyWordSpec {

  "indexOfInvalidItem" when {
    "executed with HOT weather" should {
      "fail for command HOT 8,6,4,2,1,7" in {
        val inputActions = "8,4,5,2,6,7"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 2
        val clothForTemperature = new ClothForTemperatureImpl
        val index = clothForTemperature.indexOfInvalidItem(person)

        //assert(index.equals(expectedResult))
      }

      "fail for command HOT 8,6,3,2,1,7" in {
        val inputActions = "8,4,3,2,6,7"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 2
        val clothForTemperature = new ClothForTemperatureImpl
        val index = clothForTemperature.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }

      "success for command HOT 8,6,4,2,1,7" in {
        val inputActions = "8,6,4,2,1,7"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 6
        val clothForTemperature = new ClothForTemperatureImpl
        val index = clothForTemperature.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
    }

    "executed with COLD weather" should {
      "success for command COLD 8,4,6,3,2,5,1,7" in {
        val inputActions = "8,4,6,3,2,5,1,7"
        val person = Person(Temperature.COLD.entryName, inputActions)
        val expectedResult = 8
        val clothForTemperature = new ClothForTemperatureImpl
        val index = clothForTemperature.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
    }
  }
}
