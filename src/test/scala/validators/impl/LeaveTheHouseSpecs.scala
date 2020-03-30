package validators.impl

import model.{Person, Temperature}
import org.scalatest.wordspec.AnyWordSpec

class LeaveTheHouseSpecs extends AnyWordSpec {

  "indexOfInvalidItem" when {
    "executed with HOT weather" should {
      "fail for command HOT 8,6,4,2,1,7" in {
        val inputActions = "8,4,1,2,6"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 5
        val leaveTheHouse = new LeaveTheHouseImpl
        val index = leaveTheHouse.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
      "success for command HOT 8,6,4,2,1,7" in {
        val inputActions = "8,6,4,2,1,7"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 6
        val leaveTheHouse = new LeaveTheHouseImpl
        val index = leaveTheHouse.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
    }

    "executed with COLD weather" should {
      "fail for command COLD 8,4,6,3,2,5,1" in {
        val inputActions = "8,4,6,3,2,5,1"
        val person = Person(Temperature.COLD.entryName, inputActions)
        val expectedResult = 7
        val leaveTheHouse = new LeaveTheHouseImpl
        val index = leaveTheHouse.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
      "success for command COLD 8,4,6,3,2,5,1,7" in {
        val inputActions = "8,4,6,3,2,5,1,7"
        val person = Person(Temperature.COLD.entryName, inputActions)
        val expectedResult = 8
        val leaveTheHouse = new LeaveTheHouseImpl
        val index = leaveTheHouse.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
    }
  }
}
