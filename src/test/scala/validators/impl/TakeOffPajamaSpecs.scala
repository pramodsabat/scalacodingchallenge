package validators.impl

import model.{Person, Temperature}
import org.scalatest.wordspec.AnyWordSpec

class TakeOffPajamaSpecs extends AnyWordSpec {

  "indexOfInvalidItem" when {
    "executed with HOT weather" should {
      "fail for command HOT 8,6,4,2,1" in {
        val inputActions = "8,6,4,2,1"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 5
        val takeOfPajama = new TakeOffPajamaImpl
        val index = takeOfPajama.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }

      "success for command HOT 8,6,4,2,1,7" in {
        val inputActions = "8,6,4,2,1,7"
        val person = Person(Temperature.HOT.entryName, inputActions)
        val expectedResult = 6
        val takeOfPajama = new TakeOffPajamaImpl
        val index = takeOfPajama.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
    }

    "executed with COLD weather" should {
      "fail for command COLD 8,6,3,4,2,5,1,7" in {
        val inputActions = "8,6,3,4,2,5,1"
        val person = Person(Temperature.COLD.entryName, inputActions)
        val expectedResult = 7
        val takeOfPajama = new TakeOffPajamaImpl
        val index = takeOfPajama.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }

      "success for command COLD 8,6,3,4,2,5,1,7" in {
        val inputActions = "8,6,3,4,2,5,1,7"
        val person = Person(Temperature.COLD.entryName, inputActions)
        val expectedResult = 8
        val takeOfPajama = new TakeOffPajamaImpl
        val index = takeOfPajama.indexOfInvalidItem(person)

        assert(index.equals(expectedResult))
      }
    }

  }

}
